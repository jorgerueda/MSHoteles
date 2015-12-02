/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion.Implementacion;

import PrimeraEntrega.Integracion.FactoriaTransaccion.FactoriaTransaccion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaTransaccionImp extends FactoriaTransaccion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransactionMySQL nuevaTransaccion() {
		return new TransactionMySQL();
	}
}