/**
 * 
 */
package PrimeraEntrega.Presentacion.Controlador;

import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;



public abstract class Controlador {

	private static Controlador controlador;


	protected Controlador(){}
	
	
	public static Controlador getInstancia() {
	
		if(controlador == null){
			controlador = new ControladorImp();
		}
		
		return controlador;
	
	}

	
	public abstract void execute(int id_evento, Object datos);
	
}