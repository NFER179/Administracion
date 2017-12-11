package dao;

import dto.PlanDetalleDTO;
import variables.Fecha;

public interface PlanDetalleDAO {

	/**
	 * @author nfernandez
	 * @param plan
	 * @param fecha
	 * @return Los detalles del plan hasta la fecha.
	 */
	public PlanDetalleDTO getPlanLineTo(String plan, Fecha fecha);

}
