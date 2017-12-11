package dto;

import variables.Fecha;
import variables.IdCliente;

public class EntryRegistrationDTO {

	private IdCliente _idCliente;
	private Fecha _fechaIngreso;
	
	public EntryRegistrationDTO(IdCliente idCliente, Fecha fechaIngreso) {
		this._idCliente = idCliente;
		this._fechaIngreso = fechaIngreso;
	}

	public IdCliente getIdCliente() {
		return _idCliente;
	}

	public Fecha getFechaIngreso() {
		return _fechaIngreso;
	}
}