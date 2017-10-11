package thread;

import controlador.CtrPrincipal;
import modelo.ClienteModelo;
import variables.IdCliente;
import vista.Principal;

public class LectorCod extends Thread {

	private boolean bleer;
	private CtrPrincipal ctr;
	private ClienteModelo clteMld;
	private int lenthIdCliente;
	
	public LectorCod(CtrPrincipal Ctr) {
		this.bleer = true;
		this.ctr = Ctr;
		this.clteMld = new ClienteModelo();
		this.lenthIdCliente = this.clteMld.getIdLength();
	}
	
	public void run() {
		try {
			while(this.bleer){
				if(this.lenthIdCliente <= this.ctr.getUserCod().length()) {//if(this.ctr.getUserCod().length() == 5) {
					if(this.clteMld.existeId(IdCliente.getStrId(this.ctr.getUserCod()))) {//if (this.ctr.getUserCod().equals("1327")) {
						//this.ctr.mostrarMensaje("codigo acceptado");
						this.ctr.codigoCorrecto(true);
						this.ctr.limpiarCodUser();
					}
					else {
						this.ctr.mostrarMensaje("El codigo no Existe");
						this.ctr.limpiarCodUser();
					}
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void parar(){
		this.bleer = false;
		this.interrupt();
	}
}
