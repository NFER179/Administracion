package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dto.ClienteDTO;
import managers.MessageManager;
import modelo.ClienteModelo;
import validador.VldCustomerCreation;
import variables.Fecha;
import vista.VtCustomerCreation;

public class CtrCustomerCreation implements ActionListener {

	private VtCustomerCreation vtCC;
	private VldCustomerCreation vldCC;
	
	/* Contuctor */
	public CtrCustomerCreation() {
		this.vtCC = new VtCustomerCreation();
		this.addListenerToView();
		
		this.vldCC = new VldCustomerCreation(this.vtCC);
	}
	
	private void addListenerToView() {
		JButton[] components = this.vtCC.getAllAction();
		
		for (int i = 0; i < components.length; i++) {
			components[i].addActionListener(this);
		}
	}
	
	public void init() {
		this.vtCC.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCC.getBtnGuardar()) {
			if(this.vldCC.passValidation()) {
				this.registryCustomer();
			}
			else {
				JOptionPane.showMessageDialog(this.vtCC, this.vldCC.getMessage());
			}
		}
		if (arg0.getSource() == this.vtCC.getBtnCancelar()) {
			this.cancelarUserCreation();
		}
	}

	/**
	 * This method registry a new custome into system
	 */
	private void registryCustomer() {
		ClienteModelo mdlCustomer = new ClienteModelo();
		
		String name = this.vtCC.getTxtNombre().getText();
		String lastname = this.vtCC.getTxtApellido().getText();
		String document = this.vtCC.getTxtDocumento().getText();
		Fecha birthday = this.vtCC.getDateFechaNacimiento();
		
		ClienteDTO customer = new ClienteDTO(mdlCustomer.getNewCustomerId(), name, lastname, document, birthday, Fecha.Today());
		
		mdlCustomer.registryCustomer(customer);
		
		/* Ver de hacerlo mas personalizado, si es posible. */
		String message = MessageManager.getMessage(1, customer.getIdCliente().getIdCliente());
		JOptionPane.showMessageDialog(this.vtCC, message);
		
		this.vtCC.setVisible(false);
	}
	
	/**
	 * Use this method when press the cancal button.
	 */
	private void cancelarUserCreation() {
		this.vtCC.setVisible(false);
	}
}