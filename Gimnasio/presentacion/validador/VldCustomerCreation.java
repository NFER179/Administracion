package validador;

import java.awt.Color;

import managers.MessageManager;
import vista.VtCustomerCreation;

public class VldCustomerCreation {

	private VtCustomerCreation vt;
	private String message;
	
	public VldCustomerCreation(VtCustomerCreation Vt) {
		this.vt = Vt;
	}
	
	public boolean passValidation() {
		
		boolean completeFields = true;
		String msg = "";
		
		if(vt.getTxtApellido().getText().equals("")) { 
			completeFields = false;
			vt.getTxtApellido().setBackground(Color.RED);
			msg = msg + "\u00B0 Apellido\n";
		}
		if (vt.getTxtNombre().getText().equals("")) {
			completeFields = false;
			vt.getTxtNombre().setBackground(Color.RED);
			msg = msg + "\u00B0 Nombre\n";
		}
		if (vt.getTxtDocumento().getText().equals("")) {
			completeFields = false;
			vt.getTxtDocumento().setBackground(Color.RED);
			msg = msg + "\u00B0 Documento\n";
		}
		
		if (!completeFields) {
			this.message = MessageManager.getMessage(2, msg);
		}
		
		return completeFields;
	}
	
	public String getMessage() {
		return this.message;
	}
}
