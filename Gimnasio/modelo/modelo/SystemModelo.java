package modelo;

import dao.SystemDAO;
import daoImplementacion.SystemImp;
import dto.ClienteDTO;
import dto.PlanDTO;
import variables.Fecha;

public class SystemModelo {

	private SystemDAO _sys;
	
	public SystemModelo() {
		this._sys = new SystemImp();
	}

//	public PlanDTO getCustomerPlanIn(ClienteDTO Clte, Fecha inscripcion) {
//		return this._sys.getPlanForCustomerRegistrationIn(Clte, inscripcion);
//	}

//	public void registerCustomer(ClienteDTO Clte) {
//		this._sys.registerCustomer(Clte);
//	}

	/* Obtiene la fecha de inscripcion para una determinado clientes. */
//	public Fecha getLastRegistratioDateFor(ClienteDTO clte) {
//		return this._sys.getLastRegistrationDateFor(clte);
//	}

//	public int getNumberOfRegistrationFrom(Fecha Inscripcion, ClienteDTO cliente) {
//		return this._sys.getNumberOfInFrom(Inscripcion, cliente);
//	}
}
