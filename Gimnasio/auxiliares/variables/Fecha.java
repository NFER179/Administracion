package variables;

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
		return Integer.toString(this._dia) + "/" + Integer.toString(this._mes) + "/" + Integer.toString(this._ano);
	}

	/**
	 * @author nfernandez
	 * @param fecha Format of string "yyyy-mm-dd"
	 * @return Fecha
	 */
	public static Fecha getFecha(String fecha) {
		String[] ArrFecha = fecha.split("-");
		return new Fecha(Integer.parseInt(ArrFecha[2]), 
				Integer.parseInt(ArrFecha[1]), 
				Integer.parseInt(ArrFecha[0]));
	}

	public boolean isHoy() {
		/* Falta desarrollar metodo. */
		return false;
	}
}
