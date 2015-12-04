/**
 * 
 */
package PrimeraEntrega.Presentacion.Controlador.Implementacion;

import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Controlador.Controlador;
import PrimeraEntrega.Presentacion.Dispatcher.Dispatcher;
import PrimeraEntrega.Presentacion.FactoriaComando.FactoriaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
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
