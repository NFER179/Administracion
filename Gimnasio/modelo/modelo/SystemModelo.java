package modelo;

import dao.SystemDAO;
import daoImplementacion.SystemImp;
import dto.ClienteDTO;
import dto.PlanDTO;

public class SystemModelo {

	private SystemDAO _sys;
	
	public SystemModelo() {
		this._sys = new SystemImp();
	}

	public PlanDTO getCustomerPlan(ClienteDTO Clte) {
		return this._sys.getPlanForCustomer(Clte);
	}

	public void registerCustomer(ClienteDTO Clte) {
		this._sys.registerCustomer(Clte);
	}
}
