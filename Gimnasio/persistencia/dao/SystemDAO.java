package dao;

import dto.ClienteDTO;
import dto.PlanDTO;
import variables.Fecha;

public interface SystemDAO {

	/**
	 * @author nfernandez
	 * @param Customer
	 * @return Plan of Customer
	 */
	public PlanDTO getPlanForCustomerRegistrationIn(ClienteDTO clte, Fecha date);

	/**
	 * @author nfernandez
	 * @param customer
	 */
	public void registerCustomer(ClienteDTO clte);

	/**
	 * @author nfernandez
	 * @param clte
	 * @return
	 */
	public Fecha getLastRegistrationDateFor(ClienteDTO clte);
}
