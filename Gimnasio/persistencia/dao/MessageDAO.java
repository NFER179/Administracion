package dao;

import dto.MessageDTO;
import managers.SessionManager;

public interface MessageDAO {

	/**
	 * @author nfernandez
	 * @param currentSession
	 * @param messageNumber
	 * @return Message
	 */
	MessageDTO getMessage(SessionManager currentSession, int messageNumber);
}