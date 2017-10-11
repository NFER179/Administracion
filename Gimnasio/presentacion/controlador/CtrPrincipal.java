package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.ClienteDTO;
import modelo.ClienteModelo;
import thread.LectorCod;
import variables.IdCliente;
import vista.Principal;

public class CtrPrincipal implements ActionListener {

	private Principal vt;
	private LectorCod threadLector;
	
	private CtrInfoCliente ctrInfCliente;
	
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

	/**
	 * @author nfernandez
	 * @Desciption Metodo para hacer pruebas rapidas de mostrar carteles.
	 **/
	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	public void limpiarCodUser() {
		this.vt.getTxtCodUsuario().setText("");
	}

	/**
	 * @author nfernandez
	 * @param boolean (if de code is correct or not)
	 * @return New Frame with customer information
	 */
	public void codigoCorrecto(boolean b) {
		ClienteDTO clte = new ClienteModelo().getCliente(IdCliente.getStrId(this.vt.getTxtCodUsuario().getText()));
		this.ctrInfCliente = new CtrInfoCliente(clte);
		this.ctrInfCliente.init();
	}
}