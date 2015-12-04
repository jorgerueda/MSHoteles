/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO.Implementacion;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.Cliente.Implementacion.DAOClienteImp;
import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Habitacion.Implementacion.DAOHabitacionImp;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Reserva.Implementacion.DAOReservaImp;


public class FactoriaDAOImp extends FactoriaDAO {
//	/** 
//	 * <!-- begin-UML-doc -->
//	 * <!-- end-UML-doc -->
//	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
//	 */
//	public void getClassLoader() {
//		// begin-user-code
//		// TODO Apéndice de método generado automáticamente
//
//		// end-user-code
//	}
//
//	/** 
//	 * <!-- begin-UML-doc -->
//	 * <!-- end-UML-doc -->
//	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
//	 */
//	public void getResourcesAsStream() {
//		// begin-user-code
//		// TODO Apéndice de método generado automáticamente
//
//		// end-user-code
//	}


	public DAOCliente getDAOCliente() {
		return new DAOClienteImp();
	}


	public DAOHabitacion getDAOHabitacion() {
		return new DAOHabitacionImp();
	}


	public DAOReserva getDAOReserva() {
		return new DAOReservaImp();
	}
}