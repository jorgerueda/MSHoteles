package PrimeraEntrega.Integracion.TransactionManager.Implementacion;

import java.util.concurrent.ConcurrentHashMap;

import PrimeraEntrega.Integracion.FactoriaTransaccion.FactoriaTransaccion;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL.TransaccionMYSQL;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Héctor
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

	public class TransactionManagerImp extends TransactionManager {
		ConcurrentHashMap<Thread, Transaccion> myConcurrentHashMap;
		
		public TransactionManagerImp() {
			myConcurrentHashMap = new ConcurrentHashMap<Thread, Transaccion>();
		}
		
		
		@Override
		public Transaccion nuevaTransaccion() {
			// TODO Auto-generated method stub
			Transaccion t = new TransaccionMYSQL();
			myConcurrentHashMap.put(Thread.currentThread(),t);
			return getTransaccion();
		}

		@Override
		public void eliminarTransaccion() {
			myConcurrentHashMap.remove(Thread.currentThread());
			
		}

		@Override
		public Transaccion getTransaccion() {
			// TODO Auto-generated method stub
			Transaccion TransaccionReturned = myConcurrentHashMap.get(Thread
					.currentThread());
		
			return TransaccionReturned;
		}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

}