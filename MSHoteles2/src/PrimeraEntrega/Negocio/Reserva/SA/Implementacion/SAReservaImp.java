/**
 * 
 */
package PrimeraEntrega.Negocio.Reserva.SA.Implementacion;

import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAReservaImp implements SAReserva {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean nuevaReserva(TransferReserva TReserva) {
		Boolean esta = false;
		Boolean correcto = false;
		
		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
		
		transaction.start();
		
		DAOReserva daoReserva = FactoriaDAO.getInstance().getDaoReserva();
		
		// buscamos al Reserva
		esta = daoReserva.buscarReserva(TReserva);

		if (!esta){
			correcto = daoReserva.nuevaReserva(TReserva);
			transaction.commit();
		}else if (esta){ // esta
			// Si no esta activo
			if (!TReserva.isActivo()){
				TReserva.setActivo(true);
				correcto = daoReserva.modificarReserva(TReserva);
				transaction.commit();
			} else {
				transaction.rollback();
			}
		}
		
		TransactionManager.getInstancia().eliminarTransaccion();
		
		return correcto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void anadirHabitacion() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void quitarHabitacion() {
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva mostrarReserva(TransferReserva TReserva) {
		Boolean esta = false;
		TransferReserva ReservaEncontrado = new TransferReserva();

		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
						
		transaction.start();

		DAOReserva daoReserva = FactoriaDAO.getInstance().getDaoReserva();
					
				// Leemos Reserva
		esta = daoReserva.buscarReserva(TReserva);
		
		// esta
		if(esta){	
					
			if(!TReserva.isActivo()){
				ReservaEncontrado = null;
				transaction.rollback();
						
			} else {// Si esta activo
				ReservaEncontrado = daoReserva.mostrarReserva(TReserva);
				transaction.commit();
				
			}		
		}   else if (!esta){ // !esta
			// Si no esta activo
			ReservaEncontrado = null;
			transaction.rollback();			
		}

		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
			
		return ReservaEncontrado;
	}
}