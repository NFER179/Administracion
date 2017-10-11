package conexio;

import java.sql.*;

public class ConectorDB {

	private static ConectorDB instancia = null;
	private Connection conexion = null;
	private Statement statement = null;
	
	protected ConectorDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio", "root", "root");
			this.statement = this.conexion.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConectorDB getInstancia() {
		if (instancia == null) {
			instancia = new ConectorDB();
		}
		
		return instancia;
	}
	
	public Statement getStament() {
		if (this.conexion == null || this.statement == null) {
			try {
				this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio", "root", "root");
				this.statement = this.conexion.createStatement();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return this.statement;
	}
	
	public void cerrarConexion() {
		if (this.conexion != null) {
			this.conexion = null;
		}
		if (this.statement != null) {
			this.statement = null;
		}
	}
}		