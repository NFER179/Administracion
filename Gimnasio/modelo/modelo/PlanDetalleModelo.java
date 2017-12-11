package modelo;

import dao.PlanDetalleDAO;
import daoImplementacion.PLanDetalleImplementacion;
import dto.PlanDetalleDTO;
import variables.Fecha;

public class PlanDetalleModelo {

	private PlanDetalleDAO _planLineDao;
	
	public PlanDetalleModelo() {
		this._planLineDao = new PLanDetalleImplementacion();
	}

	public PlanDetalleDTO getPlanLineTo(String plan, Fecha fecha) {
		return this._planLineDao.getPlanLineTo(plan, fecha);
	}
}
