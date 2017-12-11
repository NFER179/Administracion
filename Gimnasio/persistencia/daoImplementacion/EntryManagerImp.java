package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.EntryManagerDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import dto.EntryRegistrationDTO;
import makeQuery.QueryManager;
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
		
		qm.selectAllFrom(Record.cliente_presentismo);
		qm.addClausuleSame(Field.id_cliente, clte.getIdCliente().getIdCliente());
		qm.addEffdt(new Field[] {Field.id_cliente}, Record.cliente_presentismo);
		
		qm.imprimirQuery("EntryManager.obtenerUltimoEntRegistrationFor");
		
		Statement stm;
		ResultSet rs;
		
		EntryRegistrationDTO erDto = null;
		
		try {
			stm = this.cnt.getStatement();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				erDto = new EntryRegistrationDTO(
						new IdCliente(rs.getString(Field.id_cliente.field()))
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

}
