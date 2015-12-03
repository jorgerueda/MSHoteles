/**
 * 
 */
package PrimeraEntrega.Negocio.Habitacion.SA.Implementacion;

import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAHabitacionImp implements SAHabitacion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean altaHabitacion(TransferHabitacion THabitacion) {
		
		Boolean esta = false;
		Boolean correcto = false;
		
		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
		
		transaction.start();
		
		DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
		
		// buscamos al cliente
		esta = daoHabitacion.buscarHabitacion(THabitacion);

		if (!esta){
			correcto = daoHabitacion.altaHabitacion(THabitacion);
			transaction.commit();
		}else if (esta){ // esta
			// Si no esta activo
			if (!TCliente.isActivo()){
				THabitacion.setActivo(true);
				correcto = daoHabitacion.modificarHabitacion(THabitacion);
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
	public TransferHabitacion  mostrarHabitacion(TransferHabitacion THabitacion) {
		Boolean esta = false;
		TransferHabitacion habitacionEncontrada = new TransferHabitacion();

		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
						
		transaction.start();

		DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
					
				// Leemos cliente
		esta = daoHabitacion.buscarHabitacion(THabitacion);
		
		// esta
		if(esta){	
					
			if(!THabitacion.isActivo()){
				habitacionEncontrada = null;
				transaction.rollback();
						
			} else {// Si esta activo
				habitacionEncontrada = daoHabitacion.mostrarHabitacion(THabitacion);
				transaction.commit();
				
			}		
		}   else if (!esta){ // !esta
			// Si no esta activo
			habitacionEncontrada = null;
			transaction.rollback();			
		}

		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
			
		return habitacionEncontrada;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAHabitacion#MostrarHabitacion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void MostrarHabitacion() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}