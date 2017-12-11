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

//	/* falta logica de que si ingreso hoy no le vuelva a restar dia. */
//	public void registrarIngreso(ClienteDTO Clte) {
//		if(this.clte.ingresoHoy(Clte)) {
//			
//		}
//		else {
//			SystemModelo sys = new SystemModelo();
//			sys.registerCustomer(Clte);
//		}
//	}
	

//	public boolean canPass(ClienteDTO Clte) {
//		if (this.clte.ingresoHoy(Clte))
//			return true;
//		else {
//			PlanModelo mdlPlan = new PlanModelo();
//			/*dias mayores a 4 y vencimiento mayor igual a hoy*/
//			if (mdlPlan.daysToUseForCustomer(Clte) > 0) {
//				return true;
//			}
//			else
//				return false;
//		}
//	}
}
