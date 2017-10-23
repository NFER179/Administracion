package variables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {

	private int _dia;
	private int _mes;
	private int _ano;
	
	public Fecha(int dia, int mes, int ano) {
		this._dia = dia;
		this._mes = mes;
		this._ano = ano;
	}
	
	public String getStrFecha() {
		String dia = Integer.toString(this._dia);
		if (dia.length() < 2)
			dia = "0" + dia;
		
		String mes = Integer.toString(this._mes);
		if (mes.length() < 2)
			mes = "0" + mes;
		
		return Integer.toString(this._ano) + "/" + mes + "/" + dia;
	}

	public boolean isToday() {
		/* Falta desarrollar metodo. */
		return false;
	}

	public String ToSqlDate(String db) {
		switch(db.toUpperCase()) {
			case "MYSQL":
		return "STR_TO_DATE('" + this.getStrFecha() + "','%Y/%m/%d')";
		default:
			return "";
		}
	}

	/* Retorna la cantidad de días desde la fecha hasta hoy. */
	public int daysToToday() {
		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		Fecha today = Fecha.getFecha(asf.format(cal.getTime()));
		
		int anosDiferencia = today.getAno() - this._ano;
		int mesesDiferencia =  
		
		return 0;
	}
	
	/**
	 * @author nfernandez
	 * @param fecha Format of string "yyyy-mm-dd"
	 * @return Fecha If string is null return 01-01-1900
	 */
	public static Fecha getFecha(String fecha) {
		if (fecha == null)
			fecha = "1900-01-01";
		
		String[] ArrFecha = fecha.split("-");
		return new Fecha(Integer.parseInt(ArrFecha[2]), 
				Integer.parseInt(ArrFecha[1]), 
				Integer.parseInt(ArrFecha[0]));
	}

	public static Fecha Today(){
		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		return Fecha.getFecha(asf.format(cal.getTime())); 
	}

	public int getDia() {
		return _dia;
	}

	public int getMes() {
		return _mes;
	}

	public int getAno() {
		return _ano;
	}
}