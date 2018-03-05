package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorDB;
import dao.MessageDAO;
import dbVars.Field;
import dbVars.Record;
import dto.MessageDTO;
import managers.QueryManager;
import managers.SessionManager;

public class MessageImp implements MessageDAO {

	private ConectorDB cnt;
	
	public MessageImp() {
		this.cnt = ConectorDB.getInstancia();
	}
	
	@Override
	public MessageDTO getMessage(SessionManager currentSession, int messageNumber) {
		
		QueryManager qm = new QueryManager();
		qm.selectAllFrom(Record.message_tbl);
		qm.addClausuleSame(Field.language, QueryManager.insertCommon(currentSession.getLanguage()));
		qm.addClausuleSame(Field.messageNumber, QueryManager.insertCommon(Integer.toString(messageNumber)));
		
		qm.imprimirQuery("MessageImp.getMessage");
		
		Statement stm = this.cnt.getStatement();
		MessageDTO message = null;
		
		try {
			ResultSet rs = stm.executeQuery(qm.getQueryTxt());
			while(rs.next()) {
				message = new MessageDTO(rs.getString(Field.language.field()),
						rs.getInt(Field.messageNumber.field()),
						rs.getString(Field.messageText.field()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.cnt.cerrarConexion();
		}
		
		return message;
	}
}