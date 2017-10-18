package dto;

public class PlanDTO {

	private String _sPlan;
	private String _sDescr;
	
	public PlanDTO(String plan, String descr) {
		this._sPlan = plan;
		this._sDescr = descr;
	}

	public String get_sPlan() {
		return _sPlan;
	}

	public String get_sDescr() {
		return _sDescr;
	}
}