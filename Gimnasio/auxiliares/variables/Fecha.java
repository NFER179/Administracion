package variables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

	private int iDia;
	private int iMes;
	private int iAno;
	
	public Fecha(int dia, int mes, int ano) {
		this.iDia = dia;
		this.iMes = mes;
		this.iAno = ano;
	}

	public boolean isToday() {
		DateFormat asf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		Fecha today = Fecha.getFecha(asf.format(cal.getTime()));
		
		if (today.getAno() == this.iAno && today.getMes() == this.iMes && today.getDia() == this.iDia) {
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
		
		for (int anio = this.iAno + 1 ; anio < today.getAno(); anio++) {
			
			dias += 365;
			if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
				dias += 1;
			}
		}  
		
		if (today.getAno() - this.iAno >= 1) {
			for (int mesInicio = this.iMes +1; mesInicio <= 12; mesInicio++) {
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
			for (int meses = this.iMes ; meses < today.iMes; meses ++) {
				dias += diasEnMeses[meses];
			}
			
			
		}
		
		if (((today.getAno() % 4 == 0) && ((today.getAno() % 100 != 0) || (today.getAno() % 400 == 0))) && today.getMes() > 2) {
			dias += 1;
		}
		
		if(today.iMes == this.iMes) {
			dias += today.getDia() - this.iDia + 1;
		}
		else {
			dias += diasEnMeses[this.iMes - 1] - this.iDia;
			
			dias += today.getDia();
		}
			
		
		return dias;
	}
	
	/**
	 * @author nfernandez
	 * @param fecha Format of string "yyyy-mm-dd"
	 * @return Fecha If string is null return 1900-01-01
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
	
	public static String[] getLastHundredArrayList() {
		
		Fecha f = Fecha.Today();
		
		int año = f.getAno();
		String[] list = new String[año - 1899];
		
		for (int i = 0; 1900 + i <= año; i++) {
			list[i] = Integer.toString(i + 1900);
		}
		
		return list;
	}

	public int getDia() {
		return iDia;
	}

	public String getSDia() {
		if (this.iDia < 10){
			return "0" + this.iDia;
		}
		return Integer.toString(this.iDia);
	}
	
	public int getMes() {
		return iMes;
	}
	
	public String getSMes() {
		if (this.iMes < 10){
			return "0" + this.iMes;
		}
		return Integer.toString(this.iMes);
	}

	public int getAno() {
		return iAno;
	}
	
	public String getStrFecha() {
		String dia = Integer.toString(this.iDia);
		if (dia.length() < 2)
			dia = "0" + dia;
		
		String mes = Integer.toString(this.iMes);
		if (mes.length() < 2)
			mes = "0" + mes;
		
		return dia + "/" + mes + "/" + Integer.toString(this.iAno);
	}
}