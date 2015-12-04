/**
 * 
 */
package PrimeraEntrega.Presentacion.Controlador;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Controlador {

	private static Controlador controlador;

	/**
	 * Constructor privado por ser singleton
	 */
	protected Controlador(){}
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static Controlador getInstancia() {
	
		if(controlador == null){
			controlador = new ControladorImp();
		}
		
		return controlador;
	
	}

	/**
	 * Realiza la respuesta del evento sucedido
	 * @param id_evento el id del evento sucedido
	 * @param datos los datos con los que trabaja
	 */
	public abstract void execute(int id_evento, Object datos);
	
}