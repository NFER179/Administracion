package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.PlanDetalleDAO;
import dbVars.Field;
import dbVars.Record;
import dto.PlanDetalleDTO;
import managers.QueryManager;
import variables.Fecha;

public class PLanDetalleImp implements PlanDetalleDAO {

	private ConectorDB cnt = ConectorDB.getInstancia();
	
	@Override
	public PlanDetalleDTO getPlanLineTo(String plan, Fecha date) {
		
		QueryManager qm = new QueryManager();
		
		qm.selectAllFrom(Record.plan_line);
		qm.addClausuleSame(Field.plan, QueryManager.insertCommon(plan));
		qm.addEffDate(new Field[] {Field.plan}, Record.plan_line, date);
		
//		qm.imprimirQuery("PlanDetalleImplementacion.getPlanLineTo");
		
		Statement st = this.cnt.getStatement();
		PlanDetalleDTO dtoPlanLine = null;
		ResultSet rs;
		
		try {
			rs = st.executeQuery(qm.getQueryTxt());
			
			while (rs.next()) {
				dtoPlanLine = new PlanDetalleDTO(rs.getString(Field.plan.field())
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
		
		return dtoPlanLine;
	}
}