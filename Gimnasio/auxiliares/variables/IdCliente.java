package variables;

public class IdCliente {
	
	private String IdCliente;
	
	public IdCliente(String Id) {
		this.IdCliente = Id;
		this.cargarCerosIzq();
	}

	/**
	 * @author nfernandez.
	 * @Description Toma un String y devuelve un objeto Id sin necesidad de crear una nueva clase.
	 **/
	public static IdCliente getStrId(String id) {
		while (id.length() < 5) {
			id = "0" + id;
		}
		return new IdCliente(id);
	}
	
	private void cargarCerosIzq() {
		while (this.IdCliente.length() < 5) {
			this.IdCliente = "0" + this.IdCliente;
		}
	}

	public String getIdCliente() {
		return IdCliente;
	}
}