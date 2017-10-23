package modelo;

import dao.PlanDAO;
import daoImplementacion.PlanImp;
import dto.ClienteDTO;
import dto.PlanDTO;
import dto.PlanDetalleDTO;
import variables.Fecha;

public class PlanModelo {

	private PlanDAO _pln;
	
	public PlanModelo() {
		this._pln = new PlanImp();
	}
	
	public int daysToUseForCustomer(ClienteDTO Clte) {
		SystemModelo sys = new SystemModelo();
		
		/* Ultima fecha de inscripcion para el cliente X */
		Fecha inscripcion = sys.getLastRegistratioDateFor(Clte);		
		PlanDTO customerPlan = sys.getCustomerPlanIn(Clte, inscripcion);
		
		PlanDetalleDTO dtoPlnDtl = this._pln.getPlanDetail(customerPlan);
		
		if (inscripcion.daysToToday() > dtoPlnDtl.get_iDiasAlMes()) {
			
		} 
		return 0;
	}

	public static boolean pendientDaysFor(PlanDTO Plan) {
		return false;
	}

	public PlanDTO getPlan(String planName) {
		return this._pln.getPlan(planName);
	}
}
