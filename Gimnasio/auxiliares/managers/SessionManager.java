package managers;

public class SessionManager {

	private static SessionManager set;
	private String language;
	
	private SessionManager(String Language) {
		this.language = Language;
	}
	
	public static SessionManager createNewSession(String Language) {
		set = new SessionManager(Language);
		
		return set;
	}
	
	public static SessionManager getCurrentSession() {
		return set;
	}
	
	public String getLanguage() {
		return this.language;
	}
}
