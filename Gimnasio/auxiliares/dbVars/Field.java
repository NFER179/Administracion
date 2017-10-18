package dbVars;

public enum Field {
	id_cliente("ID_CLIENTE"), 
	nombre("NOMBRE"), 
	apellido("APELLIDO"), 
	nacionalidad("NACIONALIDAD"), 
	tipo_doc("TIPO_DOC"), 
	num_documento("NUM_DOCUMENTO"), 
	fecha_nacimiento("FECHA_NACIMIENTO"), 
	ciudad("CIUDAD"),
	localidad("LOCALIDAD"),
	plan("PLAN"),
	descripcion("DESCRIPCION"),
	dt_to("DT_TO"),
	diasAlMes("DIASALMES"),
	precio("PRECIO"),
	fecha_inscripcion("FECHA_INSCRIPCION"),
	fecha("FECHA");
	
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
