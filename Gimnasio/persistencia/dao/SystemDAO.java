package dao;

import dto.ClienteDTO;
import dto.PlanDTO;

public interface SystemDAO {

	/**
	 * @author nfernandez
	 * @param Customer
	 * @return Plan of Customer
	 */
	PlanDTO getPlanForCustomer(ClienteDTO clte);
}
