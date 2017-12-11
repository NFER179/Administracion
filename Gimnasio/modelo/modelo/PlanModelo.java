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
	
	/**
	 * @nfernandez
	 * @param Clte
	 * @return Dias que le fanta usar a un determinado usuario.
	 */
//	public int daysToUseForCustomer(ClienteDTO Clte) {
//		SystemModelo sys = new SystemModelo();
//		
//		/* Ultima fecha de inscripcion para el cliente X */
//		Fecha inscripcion = sys.getLastRegistratioDateFor(Clte);		
//		PlanDTO customerPlan = sys.getCustomerPlanIn(Clte, inscripcion);
//		
//		PlanDetalleDTO dtoPlnDtl = this._pln.getPlanDetail(customerPlan);
//		
//		int lostDays = inscripcion.daysToToday();
//				
//		if(lostDays <= 30) {
//			int registrationDays = sys.getNumberOfRegistrationFrom(inscripcion, Clte);
//
//			return dtoPlnDtl.get_iDiasAlMes() - registrationDays;
//		}
//
//		return 0;
//	}

	public static boolean pendientDaysFor(PlanDTO Plan) {
		return false;
	}

	public PlanDTO getPlan(String planName) {
		return this._pln.getPlan(planName);
	}
}
