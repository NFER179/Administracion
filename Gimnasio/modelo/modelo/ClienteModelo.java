package modelo;

import dao.ClienteDAO;
import daoImplementacion.ClienteImp;
import dto.ClienteDTO;
import variables.IdCliente;

public class ClienteModelo {

	private ClienteDAO clte;
	
	public ClienteModelo() {
		this.clte = new ClienteImp();
	}
	
	public ClienteDTO getCliente(IdCliente id) {
		return this.clte.getCliente(id);
	}

	public int getIdLength() {
		return this.clte.getIdLength();
	}

	public boolean existeId(IdCliente idCliente) {
		if(this.clte.concideIdCliente(idCliente)){
			return true;
		}
		else {
			return false;
		}
	}
}
