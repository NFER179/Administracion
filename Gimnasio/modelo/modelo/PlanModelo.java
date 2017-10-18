package modelo;

import dao.PlanDAO;
import daoImplementacion.PlanImp;
import dto.ClienteDTO;
import dto.PlanDTO;

public class PlanModelo {

	private PlanDAO _pln;
	
	public PlanModelo() {
		this._pln = new PlanImp();
	}
	
	public int daysToUseForCustomer(ClienteDTO Clte) {
		SystemModelo sys = new SystemModelo();
		
		PlanDTO customerPlan = sys.getCustomerPlan(Clte);
		
//		int daysOfPlan = 
		return 0;
	}

	public static boolean pendientDaysFor(PlanDTO Plan) {
		return false;
	}
}
