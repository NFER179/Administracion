package variables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		Fecha today = Fecha.getFecha(asf.format(cal.getTime()));
		
		if (today.getAno() == this._ano && today.getMes() == this._mes && today.getDia() == this._dia) {
			return true;
		}
		else {
			return false;
		}
	}

//	public String ToSqlDate(String db) {
//		switch(db.toUpperCase()) {
//			case "MYSQL":
//		return "STR_TO_DATE('" + this.getStrFecha() + "','%Y/%m/%d')";
//		default:
//			return "";
//		}
//	}

	/* Retorna la cantidad de días desde la fecha hasta hoy. */
	public int daysToToday() {
		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
	
		Fecha today = Fecha.getFecha(asf.format(cal.getTime()));
		
		int dias = 0; 
		int[] diasEnMeses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int anio = this._ano + 1 ; anio < today.getAno(); anio++) {
			
			dias += 365;
			if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
				dias += 1;
			}
		}  
		
		if (today.getAno() - this._ano >= 1) {
			for (int mesInicio = this._mes +1; mesInicio <= 12; mesInicio++) {
				dias += diasEnMeses[mesInicio - 1];
			}
		
			for (int mesFin = 1; mesFin < today.getMes() - 1; mesFin++) {
				dias += diasEnMeses[mesFin -1];
			}
			
			if (((today.getAno() % 4 == 0) && ((today.getAno() % 100 != 0) || (today.getAno() % 400 == 0))) && this.getMes() > 2) {
				dias += 1;
			}
			
		}
		else {
			for (int meses = this._mes ; meses < today._mes; meses ++) {
				dias += diasEnMeses[meses];
			}
			
			
		}
		
		if (((today.getAno() % 4 == 0) && ((today.getAno() % 100 != 0) || (today.getAno() % 400 == 0))) && today.getMes() > 2) {
			dias += 1;
		}
		
		if(today._mes == this._mes) {
			dias += today.getDia() - this._dia + 1;
		}
		else {
			dias += diasEnMeses[this._mes - 1] - this._dia;
			
			dias += today.getDia();
		}
			
		
		return dias;
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


	public static int daysForYear(Fecha date) {
		int totalDays = 0;
		Calendar cal;
		
		for (int i = 1; i <= 12; i++) {
			cal = new GregorianCalendar(date.getAno(), i, date.getDia());
			totalDays = totalDays + cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		
		return totalDays;
	}
	
	public static int daysForMonth(Fecha fecha) {
		Calendar cal = new GregorianCalendar(fecha.getAno(), fecha.getMes(), fecha.getDia());
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static Fecha addDays(Fecha date, int days) {

		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar(date.getAno(), date.getMes(), date.getDia());
		
		cal.add(Calendar.DATE, days);
		
		return Fecha.getFecha(asf.format(cal.getTime()));
	}

	public int getDia() {
		return _dia;
	}

	public String getSDia() {
		if (this._dia < 10){
			return "0" + this._dia;
		}
		return Integer.toString(this._dia);
	}
	
	public int getMes() {
		return _mes;
	}
	
	public String getSMes() {
		if (this._mes < 10){
			return "0" + this._mes;
		}
		return Integer.toString(this._mes);
	}

	public int getAno() {
		return _ano;
	}
}