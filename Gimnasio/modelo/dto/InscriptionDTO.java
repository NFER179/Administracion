package dto;

import variables.Fecha;
import variables.IdCliente;

public class InscriptionDTO {

	private IdCliente _idCliente;
	private String _plan;
	private Fecha _inscription;
	
	public InscriptionDTO(IdCliente idCliente, String plan, Fecha inscription) {
		this._idCliente = idCliente;
		this._plan = plan;
		this._inscription = inscription;
	}

	public IdCliente getIdCliente() {
		return _idCliente;
	}

	public String getPlan() {
		return _plan;
	}

	public Fecha getInscription() {
		return _inscription;
	}
}
