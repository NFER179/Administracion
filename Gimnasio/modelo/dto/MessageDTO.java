package dto;

public class MessageDTO {

	private String language;
	private int messageNumber;
	private String message;
	
	public MessageDTO(String Language, int MessageNumber, String Message) {
		this.language = Language;
		this.messageNumber = MessageNumber;
		this.message = Message;
	}

	public String getLanguage() {
		return language;
	}

	public int getMessageNumber() {
		return messageNumber;
	}

	public String getMessage() {
		return message;
	}
}