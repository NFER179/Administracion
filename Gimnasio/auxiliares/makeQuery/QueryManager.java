package makeQuery;

public class QueryManager {

	private String sqlTxt;
	
	public QueryManager() {
		this.sqlTxt = "";
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
