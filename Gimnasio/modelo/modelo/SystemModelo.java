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

	public PlanDTO getCustomerPlan(ClienteDTO clte) {
		return this._sys.getPlanForCustomer(clte);
	}
}
