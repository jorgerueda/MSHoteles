/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaTransaccion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaTransaccion factoriaTransacciones;

//	/** 
//	 * <!-- begin-UML-doc -->
//	 * <!-- end-UML-doc -->
//	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
//	 */
//	public void nuevaTransaccion() {
//		// begin-user-code
//		// TODO Apéndice de método generado automáticamente
//
//		// end-user-code
//	}

	/** 
	 * @return el instancia
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public FactoriaTransaccion getInstancia() {
		if(factoriaTransacciones == null)
			factoriaTransacciones = new FactoriaTransaccionesImp();
		return factoriaTransacciones;
	}

	/** 
	 * @param instancia el instancia a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract TransactionMySQL nuevaTransaccion();
	}
}