package dbVars;

public enum Record {
	customer_tbl("CUSTOMER"),
	customer_plan("CUSTOMER_PLAN"),
	customer_pay("CUSTOMER_PAY"),
	config("CONFIG"),
	plan_hdr("PLAN_HDR"),
	plan_line("PLAN_LINE"), 
	message_tbl("MESSAGE_TBL");

	private String record;
	
	Record(String record) {
		this.record = record;
	}
	
	public String record() {
		return this.record;
	}
}