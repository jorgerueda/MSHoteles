package PrimeraEntrega.Integracion.TransactionManager;

import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.Implementacion.TransactionManagerImp;

public abstract class TransactionManager {
	
		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		private static TransactionManagerImp instancia;

		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public abstract Transaccion nuevaTransaccion();

		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public abstract void eliminarTransaccion();

		/** 
		 * <!-- begin-UML-doc -->+
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public static TransactionManager getInstancia() {
			if (instancia == null){
				instancia = new TransactionManagerImp();
			}
			return instancia;
			
		}

		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public abstract Transaccion getTransaccion();
}