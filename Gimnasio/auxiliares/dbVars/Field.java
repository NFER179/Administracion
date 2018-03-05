package dbVars;

public enum Field {
	customer_id("CUSTOMER_ID"), 
	name("name"), 
	last_name("LAST_NAME"), 
	//nacionalidad("NACIONALIDAD"), 
	//tipo_doc("TIPO_DOC"), 
	num_documento("NUM_DOCUMENTO"), 
	birthday("BIRTHDAY"), 
	//ciudad("CIUDAD"),
	//localidad("LOCALIDAD"),
	plan("PLAN"),
	description("DESCRIPTION"),
	effdt("EFFDT"),
	plan_type("PLAN_TYPE"),
	faysOfPlan("DAYS_OF_PLAN"),
	amount("AMOUNT"),
	//date("DATE"),
	duravilityOfPlan("DURABILITY_OF_PLAN"),
	sign_on("SIGNON_DATE"),
	language("LANGUAGE"),
	messageNumber("MESSAGENUMBER"),
	messageText("MESSAGETEXT"),
	ALL("*");
	
	private String Field;
	
	Field(String field) {
		this.Field = field;
	}
	
	public String field() {
		return this.Field;
	}
	
	/*public static String getField(Field field) {
		switch(field) {
			case id_cliente:
				return "ID_CLIENTE";
			case nombre:
				return "NOMBRE";
			case apellido:
				return "APELLIDO";
			case nacionalidad:
				return "NACIONALIDAD";
			case tipo_doc: 
				return "TIPO_DOC";
			case num_documento:
				return "NUM_DOC";
			case fecha_nacimiento:	
				return "FECHA_NACIMIENTO"; 
			case ciudad:		
				return "CIUDAD";
			case localidad:	
				return "LOCALIDAD";
			case plan:			
				return "PLAN";
			case descripcion:	
				return "DESCRIPCION";
			case dt_to:
				return "DT_TO";
			case diasAlMes:
				return "DIASDELMES";
			case precio:				
				return "PRECIO";
			case fecha_inscripcion:				
				return "FECHA_INSCRIPCION";
			case fecha:
				return "FECHA";
			default:
				return "X";
		}
	}*/
}
