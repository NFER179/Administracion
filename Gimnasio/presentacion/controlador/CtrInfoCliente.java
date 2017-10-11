package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;
import vista.VtInfoCliente;

public class CtrInfoCliente implements ActionListener {

	private VtInfoCliente vt;
	
	public CtrInfoCliente(ClienteDTO cliente) {
		this.vt = new VtInfoCliente(cliente); 
	}
	
	public void init() {
		this.vt.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}