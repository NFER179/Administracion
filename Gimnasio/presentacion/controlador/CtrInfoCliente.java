package controlador;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;
import modelo.EntryManagerModelo;
import vista.VtInfoCliente;

public class CtrInfoCliente implements ActionListener {

	private EntryManagerModelo mdlEntryMgr;
	private ClienteDTO _clte;
	private VtInfoCliente vt;
	
	public CtrInfoCliente(ClienteDTO cliente) {
		this._clte = cliente;
		this.vt = new VtInfoCliente(this._clte); 
	}
	
	public void init() {
		/* 1) Falta funcion que resta un dia del plan en que esta anotado el cliente. */
		/* Controla que tenga dias disponibles para usar */
		if (this.mdlEntryMgr.canPass(this._clte)) {
//		if (this.mdlCliente.canPass(this._clte)) {
//			this.mdlCliente.registrarIngreso(this._clte);
			this.mdlEntryMgr.registrarIngreso(this._clte);
			this.vt.getTxtVencimiento().setText("Vigente");
			this.vt.getTxtVencimiento().setBackground(Color.GREEN);
		}
		else {
			this.vt.getTxtVencimiento().setText("Vencido");
			this.vt.getTxtVencimiento().setBackground(Color.RED);
		}
		/* 2) Despues de la resta del dia controlar dias restantes y vencimiento del plan 
		 * para mostrar algun tipo de alerta de ser necesario. */
		this.vt.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}

	public void terminar() {
		this.vt.dispose();
	}
}