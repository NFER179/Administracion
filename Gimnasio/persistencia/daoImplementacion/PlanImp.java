package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.PlanDAO;
import dbVars.Field;
import dbVars.Record;
import dto.ClienteDTO;
import dto.PlanDTO;
import dto.PlanDetalleDTO;
import makeQuery.QueryManager;
import variables.Fecha;
import variables.IdCliente;

public class PlanImp implements PlanDAO {

	private ConectorDB cnt;

	public PlanImp() {
		this.cnt = ConectorDB.getInstancia();
	}

	@Override
	public PlanDTO getPlan(String planName) {
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom(Record.plan);
		qm.addClausuleSame(Field.plan, QueryManager.insertCommon(planName));

		Statement stm;
		ResultSet rs = null;
		PlanDTO plan = null;
		
		/* Impresion Query. */
		//qm.imprimirQuery("PlanImp.getPlan()");
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				plan = new PlanDTO(rs.getString(Field.plan.field())
						, rs.getString(Field.descripcion.field()));
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
		qm.selectAllFrom(Record.plan_detalle);
		qm.addClausuleSame(Field.plan, qm.insertCommon(customerPlan.get_sPlan()));
		
		Statement stm;
		ResultSet rs;
		PlanDetalleDTO planDetalle = new PlanDetalleDTO("SIN PLAN"
				, Fecha.getFecha(null)
				, 0
				, 0);
		
		//qm.imprimirQuery("PlanImp.class.getPlanDetail");
		
		try {
			stm = this.cnt.getStament();
			rs = stm.executeQuery(qm.getQueryTxt());
			
			while(rs.next()) {
				planDetalle = new PlanDetalleDTO(rs.getString(Field.plan.field())
						, Fecha.getFecha(rs.getString(Field.effdt.field()))
						, rs.getInt(Field.diasAlMes.field())
						, rs.getInt(Field.precio.field()));
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