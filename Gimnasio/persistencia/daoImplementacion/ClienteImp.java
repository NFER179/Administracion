package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.ClienteDAO;
import dbVars.Field;
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
		qm.selectAllFrom(Record.cliente);
		qm.addClausuleSame(Field.id_cliente.field(), IdClt.getIdCliente());
		
		ResultSet rs = null;
		ClienteDTO cliente = null;
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				cliente = new ClienteDTO(IdCliente.getStrId(rs.getString(Field.id_cliente.field()))
						, rs.getString(Field.nombre.field())
						, rs.getString(Field.apellido.field())
						, rs.getString(Field.nacionalidad.field())
						, rs.getString(Field.tipo_doc.field())
						, rs.getString(Field.num_documento.field())
						, Fecha.getFecha(rs.getString(Field.fecha_nacimiento.field()))
						, rs.getString(Field.ciudad.field())
						, rs.getString(Field.localidad.field()));
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
		
//		String[] fields = {"MAX(" + Field.id_cliente.field() + ")"};
		QueryManager qm = new QueryManager("hola");
		qm.selectMax(Field.id_cliente, Record.cliente);
		
		Statement stm;
		ResultSet rs = null;
		int lenth = 0;
		
		/* Impresion Query. (Test) */
		qm.imprimirQuery("ClienteImp");
		
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
		
		QueryManager qm = new QueryManager();
		qm.selectFieldFrom("'X'", Record.cliente);
		qm.addClausuleSame(Field.id_cliente, idCliente.getIdCliente());
		
		Statement stm;
		ResultSet rs = null;
		String exists = "";
		
		/* Impresion Query. (Test) */
		//qm.imprimirQuery("ClienteImp");

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
		
//		String field = Field.fecha.field();
//		String[] fields = {"MAX(" + field + ") AS " + field};
		QueryManager qm = new QueryManager();
		qm.selectMax(Field.fecha, Record.cliente_presentismo);
		//qm.selectFieldsFrom(fields, Record.cliente_presentismo.record());
		qm.addClausuleSame(Field.id_cliente.field(), _clte.getIdCliente().getIdCliente());
		
		Statement stm = null;
		ResultSet rs = null;
		Fecha fecha = new Fecha(1, 1, 1900);
		
		/* Impresion Query. (Test) */
		qm.imprimirQuery("ClienteImp");
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				fecha = Fecha.getFecha(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return ((fecha.isToday()) ? true : false);
	}
}