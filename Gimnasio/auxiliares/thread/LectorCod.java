package thread;

import controlador.CtrPrincipal;

import modelo.ClienteModelo;
import variables.IdCliente;

public class LectorCod extends Thread {

	private boolean bLeer;
	private CtrPrincipal ctr;
	private ClienteModelo clteMld;
	private int lenthIdCliente;
	
	public LectorCod(CtrPrincipal Ctr) {
		this.bLeer = true;
		this.ctr = Ctr;
		this.clteMld = new ClienteModelo();
		this.lenthIdCliente = this.clteMld.getIdLength();
	}
	
	public void run() {
		try {
			while(this.bLeer){
				if(this.lenthIdCliente <= this.ctr.getUserCod().length()) {
					if(this.clteMld.existeId(IdCliente.getStrId(this.ctr.getUserCod()))) {
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
		this.bLeer = false;
		this.interrupt();
	}
}
