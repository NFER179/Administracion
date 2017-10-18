package dao;

import dto.ClienteDTO;
import dto.PlanDTO;

public interface SystemDAO {

	/**
	 * @author nfernandez
	 * @param Customer
	 * @return Plan of Customer
	 */
	public PlanDTO getPlanForCustomer(ClienteDTO clte);

	/**
	 * @author nfernandez
	 * @param customer
	 */
	public void registerCustomer(ClienteDTO clte);
}
