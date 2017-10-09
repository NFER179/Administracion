package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexio.ConectorDB;
import dao.ClienteDAO;
import dto.ClienteDTO;
import makeQuery.QueryManager;
import variables.IdCliente;

public class ClienteImp implements ClienteDAO {

	private ConectorDB cnt;
	
	public ClienteImp() {
		this.cnt = ConectorDB.getInstancia();
	}
	
	@Override
	public ClienteDTO getCliente(IdCliente IdCliente) {
		
		Statement stm;
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom("USUARIO");
		qm.addClausule("id_cliente", IdCliente.toString());
		
		ResultSet rs = null;
		ClienteDTO cliente = null;
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				cliente = new ClienteDTO();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return cliente;
	}
}