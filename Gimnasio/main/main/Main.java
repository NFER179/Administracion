package main;

import javax.swing.UIManager;

import controlador.CtrPrincipal;
import makeQuery.QueryManager;

public class Main {

	public static void main(String[] args) {
		
		try {
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		}
		catch(Exception e) {
			
		}
		
		CtrPrincipal ctr01 = new CtrPrincipal();
		ctr01.init();
	}
}