package thread;

import controlador.CtrPrincipal;
import vista.Principal;

public class LectorCod extends Thread {

	private boolean bleer;
	private CtrPrincipal ctr;
	
	public LectorCod(CtrPrincipal Ctr) {
		this.bleer = true;
		this.ctr = Ctr;
	}
	
	public void run() {
		try {
			while(this.bleer){
				if(this.ctr.getUserCod().length() == 5) {
					if (this.ctr.getUserCod().equals("12345")) {
						this.ctr.mostrarMensaje("codigo acceptado");
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
