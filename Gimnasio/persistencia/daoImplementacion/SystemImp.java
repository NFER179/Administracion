package daoImplementacion;

import dao.SystemDAO;

public class SystemImp implements SystemDAO {

//	private ConectorDB cnt;
	
	public SystemImp() {
//		this.cnt = ConectorDB.getInstancia();
	}

	/* Obtiene el plan del cliente  */
//	@Override
//	public PlanDTO getPlanForCustomerRegistrationIn(ClienteDTO clte, Fecha date) {
////		QueryManager subQm = new QueryManager("B");
////		subQm.selectFieldFrom("MAX(" + Field.fecha_inscripcion + ")", Record.cliente_plan.record());
//		
//		
//		QueryManager qm = new QueryManager("A");
//		qm.selectFieldFrom(Field.plan.field(), Record.cliente_plan.record());
//		qm.addClausuleSame(Field.id_cliente.field(), clte.getIdCliente().getIdCliente());
//		qm.addEffDate(Field.fecha_inscripcion, 
//				new Field[]{Field.id_cliente, Field.plan}, 
//				Record.cliente_plan, date);
//		
//		/* impresion de query */
//		//qm.imprimirQuery("SystemImp.getPlanForCustomer");
//		
//		Statement stm;
//		ResultSet rs = null;
//		String planName = "";
//		
//		try {
//			stm = this.cnt.getStatement();
//			rs = stm.executeQuery(qm.getQueryTxt());
//			
//			while(rs.next()) {
//				planName = rs.getString(1);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//		
//		PlanModelo mdlPlan = new PlanModelo();
//		
//		return mdlPlan.getPlan(planName);
//	}

//	@Override
//	public void registerCustomer(ClienteDTO Clte) {
//		
//		QueryManager qm = new QueryManager("A");
//		qm.insert(new Field[] {Field.id_cliente, Field.effdt}, 
//				new String[] {QueryManager.insertCommon(Clte.getIdCliente().getIdCliente()), 
//						Fecha.Today().ToSqlDate("MYSQL")},
//				Record.cliente_presentismo);
//		
//		/* impresion de query */
//		//qm.imprimirInsert("SystemImp");
//		
//		Statement stm;
//		
//		try {
//			stm = this.cnt.getStatement();
//			stm.executeUpdate(qm.getInsertTxt());
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//	}
//
//	/* get last date of registration fot one customer. */
//	@Override
//	public Fecha getLastRegistrationDateFor(ClienteDTO clte) {
//		
//		QueryManager qm = new QueryManager("A");
//		qm.selectMaxFrom(Field.fecha_inscripcion, Record.cliente_plan);
//		qm.addClausuleSame(Field.id_cliente, QueryManager.insertCommon(clte.getIdCliente().getIdCliente()));
//		
//		/* impresion de query */
//		//qm.imprimirQuery("SystemImp.getLastRegistrationDateFor()");
//		
//		Statement stm;
//		ResultSet rs = null;
//		Fecha registration = Fecha.getFecha(null);
//		
//		try {
//			stm = this.cnt.getStatement();
//			rs = stm.executeQuery(qm.getQueryTxt());
//			
//			while(rs.next()) {
//				registration = Fecha.getFecha(rs.getString(1));
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//		
//		return registration;
//	}

//	@Override
//	public int getNumberOfInFrom(Fecha inscripcion, ClienteDTO cliente) {
//		
//		QueryManager qm = new QueryManager();
//		qm.selectCountFrom(Field.ALL, Record.cliente_presentismo);
//		qm.addClausuleSame(Field.id_cliente, cliente.getIdCliente().getIdCliente());
//		qm.addClausuleLessSame(inscripcion.ToSqlDate("mysql"), Field.effdt.field());	
//		
//		/* Imprime la query. */
//		//qm.imprimirQuery("SystemImp.getNumberofInFrom");
//		
//		Statement stm = this.cnt.getStatement();
//		ResultSet rs = null;
//		int into = 0;
//		
//		try {
//			rs = stm.executeQuery(qm.getQueryTxt());
//			while(rs.next()) {
//				into = rs.getInt(1);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			this.cnt.cerrarConexion();
//		}
//		
//		return into;
//	}
	
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
