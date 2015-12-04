/**
 * 
 */
package PrimeraEntrega.Presentacion.Dispatcher;

import PrimeraEntrega.Presentacion.Dispatcher.Implementacion.DispatcherImp;

/** 
 *  * Clase abstracta singleton que gestiona la seleccion de la vista a actualizar

 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispatcher {
	
	private static Dispatcher dispatcher;
	
	/**
	 * Constructor privado por ser singleton
	 */
	protected Dispatcher(){}
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static Dispatcher getInstancia() {
	
		if(dispatcher == null){
			dispatcher = new DispatcherImp();
		}
		
		return dispatcher;
	
	}

	/**
	 * permite actualizar la vista en funcion de un evento producido
	 * @param id_evento_vista el id del evento de la vista
	 * @param datos los datos necesarios por si hay algun cambio
	 */
	public abstract void dispatch(int id_evento_vista, Object datos);
}
