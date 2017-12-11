package dto;

import variables.Fecha;

public class PlanDetalleDTO {

	private String _sIdPlan;
	private Fecha _fEffdt;
	private String _sTipoPlan;
	private int _iDiasAlMes;
	private int _iPrecio;
	
	public PlanDetalleDTO(String idPlan, Fecha effdt, String tipoPlan, int diasAlMes, int precio) {
		this._sIdPlan = idPlan;
		this._fEffdt = effdt;
		this._sTipoPlan = tipoPlan;
		this._iDiasAlMes = diasAlMes;
		this._iPrecio = precio;
	}

	public String get_sIdPlan() {
		return _sIdPlan;
	}

	public Fecha get_fEffdt() {
		return _fEffdt;
	}
	
	public String get_sTipoPlan() {
		return _sTipoPlan;
	}

	public int get_iDiasAlMes() {
		return _iDiasAlMes;
	}

	public int get_iPrecio() {
		return _iPrecio;
	}
}