package dao;

public interface PlanDAO {

	/**
	 * @author nfernandez
	 * @param nombre del plan que se esta buscando.
	 */
	void getPlan(String planName);
}