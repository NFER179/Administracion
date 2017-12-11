package modelo;

import dao.InscriptionDAO;
import daoImplementacion.InscriptionImplementacion;
import dto.ClienteDTO;
import dto.InscriptionDTO;

public class InscriptionModelo {

	InscriptionDAO _insc;
	
	public InscriptionModelo() {
		this._insc = new InscriptionImplementacion();
	}
	
	public InscriptionDTO lastInscriptionFor(ClienteDTO clte) {
		return this._insc.getLastInscription(clte);
	}

}
