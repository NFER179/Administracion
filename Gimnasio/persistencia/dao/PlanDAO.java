package dao;

import dto.PlanDTO;
import dto.PlanDetalleDTO;

public interface PlanDAO {

	/**
	 * @author nfernandez
	 * @param nombre del plan que se esta buscando.
	 */
	public PlanDTO getPlan(String planName);

	/**
	 * @author nfernandez
	 * @param customerPlan
	 * @return
	 */
	public PlanDetalleDTO getPlanDetail(PlanDTO customerPlan);
}