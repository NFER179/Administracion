package managers;

import modelo.MessageModelo;

public class MessageManager {

	public MessageManager() {
		
	}
	
	public static String getMessage(int MessageNum, String[] values) {
		MessageModelo mdlMessage = new MessageModelo();
		String messageText = mdlMessage.getMessage(MessageNum).replace("/n", "\n");
		messageText = messageText.replace("/t", "\t");
		
		for (int i = 0; i<values.length; i++) {
			String oldChar = "%" + (i+1);
			messageText = messageText.replace(oldChar, values[i]);
		}
		
		return messageText;
	}

	public static String getMessage(int MessageNum, String Message) {
		MessageModelo mdlMessage = new MessageModelo();
		String messageText = mdlMessage.getMessage(MessageNum).replace("/n", "\n");
		messageText = messageText.replace("/t", "\t");
		
		messageText = messageText.replace("%1", Message);
		
		return messageText;
	}
}
