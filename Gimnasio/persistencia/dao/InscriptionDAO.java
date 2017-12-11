package dao;

import dto.ClienteDTO;
import dto.InscriptionDTO;

public interface InscriptionDAO {

	/**
	 * @author nfernandez
	 * @param clte
	 * @return Last inscriton for customer; 
	 */
	public InscriptionDTO getLastInscription(ClienteDTO clte);

}
