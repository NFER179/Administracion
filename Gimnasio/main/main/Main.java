package main;

import javax.swing.UIManager;
import controlador.CtrPrincipal;
import managers.SessionManager;

public class Main {

	public static void main(String[] args) {
		
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		SessionManager.createNewSession("ESP");
		
		CtrPrincipal ctr01 = new CtrPrincipal();
		ctr01.init();
	}
}