package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexio.ConectorDB;
import dao.ClienteDAO;
import dbVars.Record;
import dto.ClienteDTO;
import makeQuery.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class ClienteImp implements ClienteDAO {

	private ConectorDB cnt;
	
	public ClienteImp() {
		this.cnt = ConectorDB.getInstancia();
	}
	
	@Override
	public ClienteDTO getCliente(IdCliente IdClt) {
		
		Statement stm;
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom("CLIENTE");
		qm.addClausule("id_cliente", IdClt.getIdCliente());
		
		ResultSet rs = null;
		ClienteDTO cliente = null;
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				cliente = new ClienteDTO(IdCliente.getStrId(rs.getString("id_cliente"))
						, rs.getString("nombres")
						, rs.getString("apellido")
						, rs.getString("nacionalidad")
						, rs.getString("tipo_doc")
						, rs.getString("num_documento")
						, Fecha.getFecha(rs.getString("fecha_nacimiento"))
						, rs.getString("ciudad")
						, rs.getString("localidad"));
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

	@Override
	public int getIdLength() {
		
		String[] fields = {"MAX(id_cliente)"};
		QueryManager qm = new QueryManager();
		qm.selectFieldsFrom(fields, "CLIENTE");
		
		Statement stm;
		ResultSet rs = null;
		int lenth = 0;
		
		/* Impresion Query. (Test) */
		//System.out.println("class.ClienteImp" + qm.getQueryTxt());
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				lenth = rs.getString(1).toString().length();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return lenth;
	}

	@Override
	public boolean concideIdCliente(IdCliente idCliente) {
		
		String[] fields = {"'X'"};
		QueryManager qm = new QueryManager();
		qm.selectFieldsFrom(fields, "CLIENTE");
		qm.addClausule("id_cliente", idCliente.getIdCliente());
		
		Statement stm;
		ResultSet rs = null;
		String exists = "";
		
		/* Impresion Query. (Test) */
		//System.out.println("class.ClienteImp" + qm.getQueryTxt());
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				exists = rs.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return ((exists.isEmpty()) ? false : true);
	}

	@Override
	public boolean ingresoHoy(ClienteDTO _clte) {
		
		String field = "FECHA";
		String[] fields = {"MAX(" + field + ") AS " + field};
		QueryManager qm = new QueryManager();
		qm.selectFieldsFrom(fields, Record.CLIENTE_PRESENTISMO.toString());
		qm.addClausule("id_cliente", _clte.getIdCliente().getIdCliente());
		
		Statement stm = null;
		ResultSet rs = null;
		Fecha fecha = new Fecha(1, 1, 1900);
		
		/* Impresion Query. (Test) */
		System.out.println("class.ClienteImp " + qm.getQueryTxt());
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				fecha = Fecha.getFecha(rs.getString(field));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return ((fecha.isHoy()) ? true : false);
	}
}