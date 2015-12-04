/**
 * 
 */
package PrimeraEntrega.Presentacion.FactoriaComando;

import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.FactoriaComando.Implementacion.FactoriaComandoImp;

/** 
 *  * Clase abstracta singleton que gestiona la creacion de comandos

 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaComando {

	private static FactoriaComando factoriaComando;
	
	/**
	 * Constructor privado por ser singleton
	 */
	protected FactoriaComando(){}

	/**
	 * Crea un comando dado el id del evento y los datos
	 * @param id_comando el id del evento
	 * @param datos los datos con los que trabaja
	 * @return el comando creado
	 */
	public abstract Comando getComando(int id_comando, Object datos);
	
	/**
	 * Obtiene una instancia de la clase
	 * @return la instancia de la clase
	 */
	public static FactoriaComando getInstancia() {

		if (factoriaComando == null) {
			factoriaComando = new FactoriaComandoImp();
		}

		return factoriaComando;

	}
}
