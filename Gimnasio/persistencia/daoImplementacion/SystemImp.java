package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexio.ConectorDB;
import dao.SystemDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import dto.PlanDTO;
import makeQuery.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class SystemImp implements SystemDAO {

	private ConectorDB cnt;
	
	public SystemImp() {
		this.cnt = ConectorDB.getInstancia();
	}
	
	@Override
	public PlanDTO getPlanForCustomer(ClienteDTO clte) {
//		QueryManager subQm = new QueryManager("B");
//		subQm.selectFieldFrom("MAX(" + Field.fecha_inscripcion + ")", Record.cliente_plan.record());
		
		
		QueryManager qm = new QueryManager("A");
		qm.selectFieldFrom(Field.plan.field(), Record.cliente_plan.record());
		qm.addClausuleSame(Field.id_cliente.field(), clte.getIdCliente().getIdCliente());
		qm.addEffDate(Field.fecha_inscripcion, 
				new Field[]{Field.id_cliente, Field.plan}, 
				Record.cliente_plan, Fecha.Today());
		
		/* impresion de query */
		qm.imprimirQuery("SystemImp");
		
		Statement stm;
		ResultSet rs = null;
		PlanDTO plan = null;
		
		try {
			//stm = this.cnt.getStament();
			//rs = stm.executeQuery(qm.getQueryTxt());
		}
		catch(Exception e) {
			
		}
		finally {
			
		}
		
		return new PlanDTO("Ptest","holaaaaa"); 
	}
	
//	@Override
//	public ClienteDTO getCliente(IdCliente IdClt) {		
//		try {
//			stm = this.cnt.getStament();
//			rs = stm.executeQuery(qm.getQueryTxt());
//			
//			while(rs.next()) {
//				cliente = new ClienteDTO(IdCliente.getStrId(rs.getString(Field.id_cliente.field()))
//						, rs.getString(Field.nombre.field())
//						, rs.getString(Field.apellido.field())
//						, rs.getString(Field.nacionalidad.field())
//						, rs.getString(Field.tipo_doc.field())
//						, rs.getString(Field.num_documento.field())
//						, Fecha.getFecha(rs.getString(Field.fecha_nacimiento.field()))
//						, rs.getString(Field.ciudad.field())
//						, rs.getString(Field.localidad.field()));
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//			
//		return cliente;
//	}
}
