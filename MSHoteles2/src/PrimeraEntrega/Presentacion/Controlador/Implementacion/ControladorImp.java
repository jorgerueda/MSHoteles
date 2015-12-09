/**
 * 
 */
package PrimeraEntrega.Presentacion.Controlador.Implementacion;

import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Controlador.Controlador;
import PrimeraEntrega.Presentacion.Dispatcher.Dispatcher;
import PrimeraEntrega.Presentacion.FactoriaComando.FactoriaComando;


public class ControladorImp extends Controlador {
	
	@Override
	public void execute(int id_evento, Object datos) {
		
		Comando comando = FactoriaComando.getInstancia().getComando(id_evento, datos);
		comando.setDatos(datos); //le da los datos al comando
		RetornoComando respuesta = comando.execute(); //lo ejecuta
		Dispatcher.getInstancia().dispatch(respuesta.getId_evento_vista(), respuesta.getDatos()); 
		//redirige la vista en funcion de la respuesta
	}
}
