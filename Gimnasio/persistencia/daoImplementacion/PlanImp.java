package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.PlanDAO;
import dbVars.Field;
import dbVars.Record;
import dto.PlanDTO;
import dto.PlanDetalleDTO;
import managers.QueryManager;
import variables.Fecha;

public class PlanImp implements PlanDAO {

	private ConectorDB cnt;

	public PlanImp() {
		this.cnt = ConectorDB.getInstancia();
	}

	@Override
	public PlanDTO getPlan(String planName) {
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom(Record.plan_hdr);
		qm.addClausuleSame(Field.plan, QueryManager.insertCommon(planName));

		Statement stm;
		ResultSet rs = null;
		PlanDTO plan = null;
		
		/* Impresion Query. */
		//qm.imprimirQuery("PlanImp.getPlan()");
		
		try {
			stm = this.cnt.getStatement();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				plan = new PlanDTO(rs.getString(Field.plan.field())
						, rs.getString(Field.description.field()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
			
		return plan;
	}

	/* Obtiene los detalles del plan que se le pasa como parametro. */
	@Override
	public PlanDetalleDTO getPlanDetail(PlanDTO customerPlan) {
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom(Record.plan_line);
		qm.addClausuleSame(Field.plan, QueryManager.insertCommon(customerPlan.get_sPlan()));
		
		Statement stm;
		ResultSet rs;
		PlanDetalleDTO planDetalle = null;
		
		/* Se imprime la query como seguimiento. */
//		qm.imprimirQuery("PlanImp.class.getPlanDetail");
		
		try {
			stm = this.cnt.getStatement();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				planDetalle = new PlanDetalleDTO(rs.getString(Field.plan.field())
						, Fecha.getFecha(rs.getString(Field.effdt.field()))
						, rs.getString(Field.plan_type.field())
						, rs.getInt(Field.duravilityOfPlan.field())
						, rs.getInt(Field.faysOfPlan.field())
						, rs.getInt(Field.amount.field()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return planDetalle;
	}	
}