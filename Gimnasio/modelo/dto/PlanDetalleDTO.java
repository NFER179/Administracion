package dto;

import variables.Fecha;

public class PlanDetalleDTO {

	private String IdPlan;
	private Fecha Effdt;
	private String TipoPlan;
	private int DuravilityOfPlan;
	private int DiasAlMes;
	private int Precio;
	
	public PlanDetalleDTO(String idPlan, Fecha effdt, String tipoPlan, int duravilityOfPlan, int diasAlMes, int precio) {
		this.IdPlan = idPlan;
		this.Effdt = effdt;
		this.TipoPlan = tipoPlan;
		this.DuravilityOfPlan = duravilityOfPlan;
		this.DiasAlMes = diasAlMes;
		this.Precio = precio;
	}

	public String getIdPlan() {
		return IdPlan;
	}

	public Fecha getEffdt() {
		return Effdt;
	}
	
	public String getTipoPlan() {
		return TipoPlan;
	}

	public int getDuravilityOfPlan() {
		return DuravilityOfPlan;
	}

	public int getDiasAlMes() {
		return DiasAlMes;
	}

	public int getPrecio() {
		return Precio;
	}
}