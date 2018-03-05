package modelo;

import dto.ClienteDTO;
import dto.InscriptionDTO;
import dto.PlanDetalleDTO;
import variables.Fecha;

public class UserPlanModelo {

	public UserPlanModelo() {
		
	}
	
	public int getRestOfDay(ClienteDTO customer) {
		InscriptionModelo mdlIns = new InscriptionModelo();
		InscriptionDTO dtoIns = mdlIns.lastInscriptionFor(customer);
		
		EntryManagerModelo mdlEM = new EntryManagerModelo();
		int amountOfIncome = mdlEM.amountOfIncomeForFrom(customer, dtoIns.getInscription());
		
		PlanDetalleModelo mdlPD = new PlanDetalleModelo();
		PlanDetalleDTO dtoPD = mdlPD.getPlanLineTo(dtoIns.getPlan(), dtoIns.getInscription());
		
		
		int daysInPlan = dtoPD.getDiasAlMes();
		
		return daysInPlan - amountOfIncome;
	}

	public Fecha getExpirationDatePlanFor(ClienteDTO customer) {
		InscriptionModelo mdlIns = new InscriptionModelo();
		InscriptionDTO dtoIns = mdlIns.lastInscriptionFor(customer);
		
		PlanDetalleModelo mdlPD = new PlanDetalleModelo();
		PlanDetalleDTO dtoPD = mdlPD.getPlanLineTo(dtoIns.getPlan(), dtoIns.getInscription());		
		
		Fecha ExpirationDate = Fecha.addDays(dtoIns.getInscription(), this.getDurationOfPlan(dtoIns, dtoPD));
		
		return ExpirationDate;
	}

	private int getDurationOfPlan(InscriptionDTO dtoInscription, PlanDetalleDTO dtoPlanDetalle) {
		int duravility;
		
		switch (dtoPlanDetalle.getTipoPlan()) {
		case "ANUAL": duravility = Fecha.daysForYear(dtoInscription.getInscription());
				break;
		case "MENSUAL": duravility = Fecha.daysForMonth(dtoInscription.getInscription());
				break;
		default: duravility = dtoPlanDetalle.getDuravilityOfPlan();
				break;
		}
		
		return duravility;
	}
}
