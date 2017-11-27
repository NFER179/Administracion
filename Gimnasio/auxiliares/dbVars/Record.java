package dbVars;

public enum Record {
	cliente("CLIENTE"),
	cliente_plan("CLIENTE_PLAN"),
	cliente_presentismo("CLIENTE_PRESENTISMO"),
	config("CONFIG"),
	plan_hdr("PLAN_HDR"),
	plan_line("PLAN_LINE");

	private String record;
	
	Record(String record) {
		this.record = record;
	}
	
	public String record() {
		return this.record;
	}
}