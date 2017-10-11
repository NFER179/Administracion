package makeQuery;

public class QueryManager {

	private String sqlTxt;
	
	public QueryManager() {
		this.sqlTxt = "";
	}
	
	public void selectFieldsFrom(String[] fields, String Record) {
		this.sqlTxt = "SELECT " + fields[0];
		
		for(int i = 1; i < fields.length; i++) {
			this.sqlTxt = this.sqlTxt + ", " + fields[i];
		}
		
		this.sqlTxt = this.sqlTxt + " FROM " + Record;
	}
	
	public void selectAllFrom(String Record) {
		this.sqlTxt = "SELECT * FROM " + Record;
	}
	
	public void addClausule(String field, String value) {
		if (this.sqlTxt.indexOf("WHERE") == -1) {
			this.sqlTxt = this.sqlTxt + " WHERE " + field.toUpperCase() + " = '" + value + "'";
		}
		else {
			this.sqlTxt = this.sqlTxt + " AND " + field.toUpperCase() + " = '" + value + "'";
		}
	}
	
	public String getQueryTxt() {
		return this.sqlTxt;
	}
}
