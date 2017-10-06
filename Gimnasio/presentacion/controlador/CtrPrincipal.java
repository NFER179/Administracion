package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import thread.LectorCod;
import vista.Principal;

public class CtrPrincipal implements ActionListener {

	private Principal vt;
	private LectorCod threadLector;
	
	public CtrPrincipal() {
		this.vt = new Principal();
		this.addListener();
		
		this.threadLector = new LectorCod(this);
	}
	
	private void addListener() {
		this.vt.getBtnSalir().addActionListener(this);
	}
	
	public void init() {
		this.vt.setVisible(true);
		this.threadLector.run();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == this.vt.getBtnSalir()) {
				this.salir();
			}
	}

	/**
	 * Metodos privados
	 */
	private void salir() {
		this.threadLector.parar();
		this.vt.dispose();
	}
	
	/**
	 *Metodos externos 
	 */
	public String getUserCod() {
		return this.vt.getTxtCodUsuario().getText();
	}

	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	public void limpiarCodUser() {
		this.vt.getTxtCodUsuario().setText("");
	}
}