package dbVars;

public enum Record {
	cliente("CLIENTE"),
	cliente_plan("CLIENTE_PLAN"),
	cliente_presentismo("CLIENTE_PRESENTISMO"),
	config("CONFIG"),
	plan("PLAN"),
	plan_precio("PLAN_PRECIO");

	private String record;
	
	Record(String record) {
		this.record = record;
	}
	
	public String record() {
		return this.record;
	}
}