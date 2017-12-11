package dao;

import dto.ClienteDTO;
import dto.EntryRegistrationDTO;
import variables.Fecha;

public interface EntryManagerDAO {

	/**
	 * @author NFERNANDEZ
	 * @param cliente para el cual quiero saber la ultima fecha de ingreso.
	 * @return La ultima fecha de ingreso del cliente.
	 */
	public EntryRegistrationDTO obtenerUltimoEntRegistrationFor(ClienteDTO clte);

	/**
	 * @author nfernandez
	 * @param cliente que ingresa.
	 * @param Fecha en la que ingrasa el cliente.
	 */
	public void registerEntryFor(ClienteDTO clte, Fecha today);

	/**
	 * @author nfernandez
	 * @param customer
	 * @param inscription
	 * @return Devuelve la cantidad de registros despues de la fecha especificada.
	 */
	public int amountOfIncomeForFrom(ClienteDTO clte, Fecha inscription);

}
