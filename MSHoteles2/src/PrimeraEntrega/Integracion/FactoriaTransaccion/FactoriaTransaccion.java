/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion;

import PrimeraEntrega.Integracion.FactoriaTransaccion.Implementacion.FactoriaTransaccionImp;
import PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL.TransaccionMYSQL;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaTransaccion {

	private static FactoriaTransaccion instancia;


	public static FactoriaTransaccion getInstancia() {
		if (instancia == null) 
			instancia = new FactoriaTransaccionImp();
		return instancia;
	}
	
	public abstract TransaccionMYSQL nuevaTransaccionMySQL();

}