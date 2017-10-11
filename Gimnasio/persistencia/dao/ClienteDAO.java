package dao;

import dto.ClienteDTO;
import variables.IdCliente;

public interface ClienteDAO {

	/* Información en sistema para cliente. */
	public ClienteDTO getCliente(IdCliente cliente);

	/**@author nfernandez
	 * @Descripcion Obtiene largo del Id.**/
	public int getIdLength();

	/**
	 * @author nfernandez
	 * @param idCliente
	 * @return True if exists idCliente.
	 */
	public boolean concideIdCliente(IdCliente idCliente);
}