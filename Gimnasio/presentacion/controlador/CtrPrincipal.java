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

	private Principal vtPrincipal;
	private LectorCod threadLector;
	
	private CtrInfoCliente ctrInfCliente;
	
	public CtrPrincipal() {
		this.vtPrincipal = new Principal();
		this.addListener();
		
		this.threadLector = new LectorCod(this);
	}
	
	private void addListener() {
		this.vtPrincipal.getBtnRegistrarCliente().addActionListener(this);
		this.vtPrincipal.getBtnSalir().addActionListener(this);
	}
	
	public void init() {
		this.loadCustomer();
		this.vtPrincipal.setVisible(true);
		this.threadLector.run();
	}
	
	private void loadCustomer() {
		this.vtPrincipal.getModelTableUser().setRowCount(0);
		this.vtPrincipal.getModelTableUser().setColumnCount(0);
		this.vtPrincipal.getModelTableUser().setColumnIdentifiers(
				this.vtPrincipal.getTableUserHeader());
		
		for(int i = 0; i < 10; i++) {
			Object[] fila = {Integer.toString(i), "nicolas"};
			this.vtPrincipal.getModelTableUser().addRow(fila);
		}
		
		this.vtPrincipal.getTableUser().setModel(this.vtPrincipal.getModelTableUser());;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtPrincipal.getBtnRegistrarCliente()) {
			this.registerNewCustomer();
		}
		else if(arg0.getSource() == this.vtPrincipal.getBtnSalir()) {
			this.salir();
		}
	}

	private void registerNewCustomer() {
		CtrCustomerCreation ctrCC = new CtrCustomerCreation();
		ctrCC.init();
	}

	/**
	 * Metodos privados
	 */
	private void salir() {
		this.threadLector.parar();
		this.vtPrincipal.dispose();
	}
	
	/**
	 *Metodos externos 
	 */
	public String getUserCod() {
		return this.vtPrincipal.getTxtCodUsuario().getText();
	}

	/**
	 * @author nfernandez
	 * @Desciption Metodo para hacer pruebas rapidas de mostrar carteles.
	 **/
	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	public void limpiarCodUser() {
		this.vtPrincipal.getTxtCodUsuario().setText("");
	}

	/**
	 * @author nfernandez
	 * @param boolean (if de code is correct or not)
	 * @return New Frame with customer information
	 */
	public void codigoCorrecto(boolean b) {
		ClienteDTO clte = new ClienteModelo().getCliente(IdCliente.getStrId(this.vtPrincipal.getTxtCodUsuario().getText()));
		this.ctrInfCliente = new CtrInfoCliente(clte);
		this.ctrInfCliente.init();
		int i = 1;
		while(i < 6 ) {
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.ctrInfCliente.terminar();
	}
}