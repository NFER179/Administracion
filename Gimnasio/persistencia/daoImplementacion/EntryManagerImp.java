package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.EntryManagerDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import dto.EntryRegistrationDTO;
import managers.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class EntryManagerImp implements EntryManagerDAO {

	private ConectorDB cnt;
	
	public EntryManagerImp() {
		this.cnt = ConectorDB.getInstancia();
	}

	@Override
	public EntryRegistrationDTO obtenerUltimoEntRegistrationFor(ClienteDTO clte) {
		
		QueryManager qm = new QueryManager();
		
		qm.selectAllFrom(Record.customer_pay);
		qm.addClausuleSame(Field.customer_id, clte.getIdCliente().getIdCliente());
		qm.addEffdt(new Field[] {Field.customer_id}, Record.customer_pay);
		
		//qm.imprimirQuery("EntryManager.obtenerUltimoEntRegistrationFor");
		
		Statement stm;
		ResultSet rs;
		
		EntryRegistrationDTO erDto = null;
		
		try {
			stm = this.cnt.getStatement();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				erDto = new EntryRegistrationDTO(
						new IdCliente(rs.getString(Field.customer_id.field()))
						, Fecha.getFecha(rs.getString(Field.effdt.field())));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return erDto;
	}

	@Override
	public void registerEntryFor(ClienteDTO customer, Fecha today) {
		QueryManager qm = new QueryManager();
		
		qm.insert(new Field[] {Field.customer_id, Field.effdt}, 
				new String[] {QueryManager.insertCommon(customer.getIdCliente().getIdCliente()),
						QueryManager.toDateFormat(today)}, 
				Record.customer_pay);
		
		//qm.imprimirInsert("EntryManagerImp.registerEntryFor()");
		
		Statement st;
		
		try {
			st = this.cnt.getStatement();
			st.executeUpdate(qm.getInsertTxt());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
	}

	@Override
	public int amountOfIncomeForFrom(ClienteDTO customer, Fecha inscription) {
		
		QueryManager qm = new QueryManager();
		
		qm.selectCountFrom(Field.effdt, Record.customer_pay);
		qm.addClausuleSame(Field.customer_id, customer.getIdCliente().getIdCliente());
		qm.addEffDate(new Field[] {Field.customer_id}, Record.customer_pay, inscription);
		
		//qm.imprimirQuery("EntryMangerImp.amountOfIncomeForFrom()");
		
		Statement st = this.cnt.getStatement();
		ResultSet rs = null;
		int income = 0;
		
		try {
			rs = st.executeQuery(qm.getQueryTxt());
			while (rs.next()) {
				income = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return income;
	}
}