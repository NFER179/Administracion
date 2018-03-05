package modelo;

import dao.EntryManagerDAO;
import daoImplementacion.EntryManagerImp;
import dto.ClienteDTO;
import dto.EntryRegistrationDTO;
import dto.InscriptionDTO;
import dto.PlanDetalleDTO;
import variables.Fecha;

public class EntryManagerModelo {

	private EntryManagerDAO _EtrMng;
	
	public EntryManagerModelo() {
		this._EtrMng = new EntryManagerImp();
	}
	
	public boolean ingresoHoy(ClienteDTO clte) {
		EntryRegistrationDTO er = this._EtrMng.obtenerUltimoEntRegistrationFor(clte);
		
		if(er != null) {
			if (er.getFechaIngreso().isToday())
				return true;
			else {
				return false;
			}
		}
		else
			return false;
	}

	public void registrarIngreso(ClienteDTO clte) {
		if (ingresoHoy(clte)) {
			/*No registra nada.*/
		}
		else {
			this._EtrMng.registerEntryFor(clte, Fecha.Today());
		}
	}
	
	public boolean canPass(ClienteDTO clte) {
		if(this.ingresoHoy(clte)) {
			return true;
		}
		else {
			InscriptionModelo insMdl = new InscriptionModelo();
			InscriptionDTO insDto = insMdl.lastInscriptionFor(clte);
			
			if(insDto == null) {
				return false;
			}
			else {
			
				PlanDetalleModelo planLineMdl = new PlanDetalleModelo();
				PlanDetalleDTO planLineDto = planLineMdl.getPlanLineTo(insDto.getPlan(), insDto.getInscription()); 
			
				if(insDto.getInscription().daysToToday() <= Fecha.daysForMonth(insDto.getInscription())) {
					if(planLineDto.getDiasAlMes() > this.amountOfIncomeForFrom(clte, insDto.getInscription())) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
	}

	/**
	 * @author nfernandez
	 * @param customer
	 * @param date
	 * @return Cantidad de veces que ingreso el cliente luego de la fecha especificada. 
	 */
	public int amountOfIncomeForFrom(ClienteDTO clte, Fecha inscription) {
		return this._EtrMng.amountOfIncomeForFrom(clte, inscription);
	}
}
