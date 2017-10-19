package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.PlanDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import makeQuery.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class PlanImp implements PlanDAO {

	private ConectorDB cnt;

	public PlanImp() {
		this.cnt = ConectorDB.getInstancia();
	}

	@Override
	public void getPlan(String planName) {
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom(Record.cliente);
		qm.addClausuleSame(Field.id_cliente.field(), IdClt.getIdCliente());
		
		Statement stm;
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
}