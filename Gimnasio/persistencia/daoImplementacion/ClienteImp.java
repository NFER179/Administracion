package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.ClienteDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import managers.QueryManager;
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
		qm.selectAllFrom(Record.customer_tbl);
		qm.addClausuleSame(Field.customer_id.field(), IdClt.getIdCliente());
		
		//qm.imprimirQuery("ClienteImp.getCliente()");
		
		ResultSet rs = null;
		ClienteDTO cliente = null;
		
		try {
			stm = this.cnt.getStatement();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				/*cliente = new ClienteDTO(IdCliente.getStrId(rs.getString(Field.id_cliente.field()))
						, rs.getString(Field.nombre.field())
						, rs.getString(Field.apellido.field())
						, rs.getString(Field.nacionalidad.field())
						, rs.getString(Field.tipo_doc.field())
						, rs.getString(Field.num_documento.field())
						, Fecha.getFecha(rs.getString(Field.fecha_nacimiento.field()))
						, rs.getString(Field.ciudad.field())
						, rs.getString(Field.localidad.field()));
						*/
				cliente = new ClienteDTO(IdCliente.getStrId(rs.getString(Field.customer_id.field()))
						, rs.getString(Field.name.field())
						, rs.getString(Field.last_name.field())
						, rs.getString(Field.num_documento.field())
						, Fecha.getFecha(rs.getString(Field.birthday.field()))
						, Fecha.getFecha(rs.getString(Field.sign_on.field())));
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
		
		QueryManager qm = new QueryManager("hola");
		qm.selectMaxFrom(Field.customer_id, Record.customer_tbl);
		
		Statement stm;
		ResultSet rs = null;
		int lenth = 0;
		
		/* Impresion Query. (Test) */
		//qm.imprimirQuery("ClienteImp.getIdLenght");
		
		try {
			stm = this.cnt.getStatement();
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
		qm.selectFieldFrom("'X'", Record.customer_tbl);
		qm.addClausuleSame(Field.customer_id, QueryManager.insertCommon(idCliente.getIdCliente()));
		
		Statement stm;
		ResultSet rs = null;
		String exists = "";
		
		/* Impresion Query. (Test) */
		//qm.imprimirQuery("ClienteImp");

		try {
			stm = this.cnt.getStatement();
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
	public IdCliente getMaxCustomerId() {
		
		QueryManager qm = new QueryManager("CUSTOMER");
		qm.selectMaxFrom(Field.customer_id, Record.customer_tbl);
		
		//qm.imprimirQuery("CLienteImp.getMaxCustomerId()");
		
		Statement stm = this.cnt.getStatement();
		IdCliente customerID = new IdCliente("0");
				
		try {
			ResultSet rs = stm.executeQuery(qm.getQueryTxt());
			while ( rs.next() ) {
				customerID = new IdCliente(rs.getString(Field.customer_id.field()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return customerID;
	}

	@Override
	public void insertCustomer(ClienteDTO customer) {
		
		QueryManager qm = new QueryManager("CUSTOMER");
		Field[] fields = new Field[] {Field.customer_id, 
				Field.name, 
				Field.last_name, 
				Field.num_documento,
				Field.birthday,
				Field.sign_on};
		String[] values = new String[] {QueryManager.insertCommon(customer.getIdCliente().getIdCliente()),
				QueryManager.insertCommon(customer.getNombre()),
				QueryManager.insertCommon(customer.getApellido()),
				QueryManager.insertCommon(customer.getNumDocumento()),
				QueryManager.toDateFormat(customer.getFechaNacimiento()),
				QueryManager.toDateFormat(customer.getSignon())};
		qm.insert(fields, values, Record.customer_tbl);
		
		//qm.imprimirInsert("ClienteImp.insertCustomer");
		
		Statement stm = this.cnt.getStatement();
		
		try {
			stm.executeLargeUpdate(qm.getInsertTxt());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
	}

//	@Override
//	public boolean ingresoHoy(ClienteDTO _clte) {
//		
////		String field = Field.fecha.field();
////		String[] fields = {"MAX(" + field + ") AS " + field};
//		QueryManager qm = new QueryManager();
//		qm.selectMaxFrom(Field.effdt, Record.cliente_presentismo);
//		//qm.selectFieldsFrom(fields, Record.cliente_presentismo.record());
//		qm.addClausuleSame(Field.id_cliente.field(), _clte.getIdCliente().getIdCliente());
//		
//		Statement stm = null;
//		ResultSet rs = null;
//		Fecha fecha = new Fecha(1, 1, 1900);
//		
//		/* Impresion Query. (Test) */
//		//qm.imprimirQuery("ClienteImp.ingresoHoy");
//		
//		try {
//			stm = this.cnt.getStatement();
//			rs = stm.executeQuery(qm.getQueryTxt());
//			
//			while(rs.next()) {
//				fecha = Fecha.getFecha(rs.getString(1));
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//		
//		return ((fecha.isToday()) ? true : false);
//	}
}