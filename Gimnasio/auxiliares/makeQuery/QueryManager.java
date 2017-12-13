package makeQuery;

import java.util.ArrayList;
import java.util.List;

import dbVars.Field;
import dbVars.Record;
import variables.Fecha;

public class QueryManager {

	private String _sPrefix;
	private String[] _asFields;
	private String[] _asValues;
	private String _sRecord;
	private List<String> _lsClausules;
	private String sqlTxt;
	
	public QueryManager() {
		this._sPrefix = "";
		this._sRecord = "";
		this._lsClausules = new ArrayList<String>();
		this.sqlTxt = "";
	}
	
	public QueryManager(String prefix) {
		this._sPrefix = prefix;
		this._sRecord = "";
		this._lsClausules = new ArrayList<String>();
		this.sqlTxt = "";
	}
	
	private String fieldPrefix() {
		if(this._sPrefix.equals(""))
			return "";
		else
			return this._sPrefix + ".";
	}
	
	public void selectFieldFrom(String field, String record) {
		this._asFields = new String[]{"%" + field} ;
		this._sRecord = record + "%";
//		this.sqlTxt = "SELECT " + field + " FROM " + record;
	}
	
	public void selectFieldFrom(String field, Record record) {
		this._asFields = new String[]{"%" + field} ;
		this._sRecord = record.record() + "%";
	}
	
	public void selectFieldsFrom(String[] fields, String record) {
		this._asFields = fields;
		for(int i = 0; i < this._asFields.length; i++) {
			this._asFields[i] = "%" + this._asFields[i];
		}
		
		this._sRecord = record + "%";
		
//		this.sqlTxt = "SELECT " + fields[0];
//		
//		for(int i = 1; i < fields.length; i++) {
//			this.sqlTxt = this.sqlTxt + ", " + fields[i];
//		}
//		
//		this.sqlTxt = this.sqlTxt + " FROM " + Record;
	}
	
	public void selectAllFrom(Record record) {
		this._asFields = new String[] {"%*"};
		this._sRecord = record.record() + "%";
//		this.sqlTxt = "SELECT * FROM " + Record;
	}
	
	public void selectCountFrom(Field field, Record record) {
		this._asFields = new String[] {"COUNT(%" + field.field() + ")"};
		this._sRecord = record.record() + "%";
	}
	
	public void selectMaxFrom(Field field, Record record) {
		this._asFields = new String[] {"MAX(%" + field.field() + ")"};
		this._sRecord = record.record() + "%";
	}
	
	/* insert metods */
	public void insert(Field[] fields, String[] values, Record record) {
		if(fields.length == values.length) {
			this._asFields = new String[fields.length];
			for(int i = 0; i < fields.length; i++) {
				this._asFields[i] = fields[i].field();
			}
			this._asValues = values;
		}
		this._sRecord = record.record();
	}
	
	/* Clausules */
	public void addClausuleSame(String field, String value) {
//		if (this.sqlTxt.indexOf("WHERE") == -1) {
//			this.sqlTxt = this.sqlTxt + " WHERE " + field.toUpperCase() + " = '" + value + "'";
//		}
//		else {
//			this.sqlTxt = this.sqlTxt + " AND " + field.toUpperCase() + " = '" + value + "'";
//		}
		this._lsClausules.add(field.toUpperCase() + " = '" + value + "'");
	}
	
	public void addClausuleSame(Field field, String value) {
		this._lsClausules.add(field.field() + " = " + value);
	}
	
	public void addClausuleSame(Field field01, Field field02) {
		this._lsClausules.add(field01.field() + " = " + field02.field());
	}
	
	public void addClausuleLess(String field, String value) {
		this._lsClausules.add(field.toUpperCase() + " < " + value);	
	}
	
	public void addClausuleLess(Field field01, Field field02) {
		this._lsClausules.add(field01.field() + " < " + field02.field());	
	}
	
	public void addClausuleLessSame(String field, String value) {
		this._lsClausules.add(field.toUpperCase() + " <= " + value);	
	}
	
	public void addClausuleLessSame(Field field01, Field field02) {
		this._lsClausules.add(field01.field() + " <= " + field02.field());	
	}
	
	private void addClausuleLessSame(Field field, String value) {
		this._lsClausules.add(field + " <= " + value);
	}
	
	/**
	 * @author nfernandez
	 * @param fieldDate
	 * @param keys
	 * @param record
	 * @param date
	 * @description select effdt
	 */
	public void addEffDate(Field[] keys, Record record, Fecha date) {
		if (this._sPrefix.equals(""))
			this._sPrefix = "A";
		
		QueryManager qm = new QueryManager(this._sPrefix + "2");
		qm.selectMaxFrom(Field.effdt, record);
		
		for(int i = 0 ; i < keys.length; i++) {
			qm.addClausuleSame(keys[i], this.fieldPrefix() + keys[i].field().toUpperCase());
		}
		qm.addClausuleLessSame(Field.effdt.field(), this.toDate(date));
		
		this._lsClausules.add(Field.effdt.field() + " = (" + qm.getQueryTxt() + ")");
	}
	
	/**
	 * @author nfernandez
	 * @param fieldDate
	 * @param keys
	 * @param record
	 * @param date
	 * <br>Descripcion:</br> 
	 * Toma el camo effdt por defecto y busca la maxima fecha effectiva
	 * para el nuevo record que se ingresa utilizando las claves que van por parametro
	 */
	public void addEffdt(Field[] keys, Record record) {
		if (this._sPrefix.equals(""))
			this._sPrefix = "A";
		
		QueryManager qm = new QueryManager(this._sPrefix + "2");
		qm.selectMaxFrom(Field.effdt, record);
		
		for(int i = 0 ; i < keys.length; i++) {
			qm.addClausuleSame(keys[i], this.fieldPrefix() + keys[i].field().toUpperCase());
		}
		qm.addClausuleLessSame(Field.effdt, "CURDATE()");
		
		this._lsClausules.add(Field.effdt + " = (" + qm.getQueryTxt() + ")");
	}

	private void armarQuery() {
		this.sqlTxt = "SELECT " + this._asFields[0].replace("%", this.fieldPrefix());
		
		for(int i = 1; i < this._asFields.length; i++) {
			this.sqlTxt = this.sqlTxt + ", " + this._asFields[i].replace("%", this.fieldPrefix());
		}
		
		this.sqlTxt = this.sqlTxt + " FROM " + this._sRecord.replace("%", " " + this._sPrefix);
		
		boolean where = true;
		for(String clausule : this._lsClausules) {
			if(where) {
				this.sqlTxt = this.sqlTxt + " WHERE " + this.fieldPrefix() + clausule;
				where = false;
			}
			else
				this.sqlTxt = this.sqlTxt + " AND " + this.fieldPrefix() + clausule;
		}
	}
	
	private void armarInsert() {
		this.sqlTxt = "INSERT INTO " + this._sRecord + " (" + this._asFields[0];
		
		for(int i = 1; i < this._asFields.length; i++) {
			this.sqlTxt = this.sqlTxt + ", " + this._asFields[i];
		}
		
		this.sqlTxt = this.sqlTxt + ") VALUES(" + this._asValues[0];
		
		for(int i = 1; i < this._asValues.length; i++) {
			this.sqlTxt = this.sqlTxt + ", " + this._asValues[i];
		}
		
		this.sqlTxt = this.sqlTxt + ")";
	}
	
	private String toDate(Fecha date) {
		return "TO_DATE('" + date.getAno() + "-" + date.getSMes() + "-" + date.getSDia() + "','YYYY-MM-DD')";
	}
	
	/* Metodos de seguimiento. */
	public String getQueryTxt() {
		this.armarQuery();
		return this.sqlTxt;
	}
	
	public String getInsertTxt() {
		this.armarInsert();
		return this.sqlTxt;
	}

	public void imprimirQuery(String Class) {
		this.armarQuery();
		System.out.println("class." + Class + " " + sqlTxt);
	}
	
	public void imprimirInsert(String Class) {
		this.armarInsert();
		System.out.println("class." + Class + " " + sqlTxt);
	}
	
	public static String insertCommon(String value){
		return "'" + value + "'";
	}
	
	public static String toDateFormat(Fecha date) {
		return "TO_DATE('" + date.getAno() + "-" + date.getSMes() + "-" + date.getSDia() + "','YYYY-MM-DD')";
	}
}
