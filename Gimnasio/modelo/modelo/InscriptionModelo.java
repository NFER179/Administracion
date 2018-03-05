package modelo;

import dao.InscriptionDAO;
import daoImplementacion.InscriptionImp;
import dto.ClienteDTO;
import dto.InscriptionDTO;

public class InscriptionModelo {

	private InscriptionDAO _insc;
	
	public InscriptionModelo() {
		this._insc = new InscriptionImp();
	}
	
	public InscriptionDTO lastInscriptionFor(ClienteDTO clte) {
		return this._insc.getLastInscription(clte);
	}

}
