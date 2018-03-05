package modelo;

import dao.MessageDAO;
import daoImplementacion.MessageImp;
import dto.MessageDTO;
import managers.SessionManager;

public class MessageModelo {

	public MessageDAO daoMessage;
	
	public MessageModelo() {
		this.daoMessage = new MessageImp();
	}
	
	public String getMessage(int MessageNumber) {
		 MessageDTO message = this.daoMessage.getMessage(SessionManager.getCurrentSession(), MessageNumber);
		 return message.getMessage();
	}
}
