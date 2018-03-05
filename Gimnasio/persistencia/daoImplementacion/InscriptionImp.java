package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.InscriptionDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import dto.InscriptionDTO;
import managers.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class InscriptionImp implements InscriptionDAO {

	private ConectorDB cnt = ConectorDB.getInstancia();
	
	@Override
	public InscriptionDTO getLastInscription(ClienteDTO customer) {
		
		QueryManager qm = new QueryManager();
		
		qm.selectAllFrom(Record.customer_plan);
		qm.addClausuleSame(Field.customer_id, customer.getIdCliente().getIdCliente());
		qm.addEffdt(new Field[] {Field.customer_id}, Record.customer_plan);
		
//		qm.imprimirQuery("InscriptionImplementacion.getLastInscription");
		
		Statement st = this.cnt.getStatement();
		InscriptionDTO inscription = null;
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				inscription = new InscriptionDTO(IdCliente.getStrId(rs.getString(Field.customer_id.field()))
						, rs.getString(Field.plan.field())
						, Fecha.getFecha(rs.getString(Field.effdt.field())));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return inscription;
	}

}
