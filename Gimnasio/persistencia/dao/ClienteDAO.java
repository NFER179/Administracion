package dao;

import dto.ClienteDTO;
import variables.IdCliente;

public interface ClienteDAO {

	/* Información en sistema para cliente. */
	public ClienteDTO getCliente(IdCliente cliente);
}
