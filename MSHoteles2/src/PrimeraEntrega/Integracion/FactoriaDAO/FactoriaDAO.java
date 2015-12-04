/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaDAO {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaDAO instance;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente daoCliente;

	/** 
	 * @return el daoCliente
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente getDaoCliente() {
		// begin-user-code
		return daoCliente;
		// end-user-code
	}

	/** 
	 * @param daoCliente el daoCliente a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDaoCliente(DAOCliente daoCliente) {
		// begin-user-code
		this.daoCliente = daoCliente;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOHabitacion daoHabitacion;

	/** 
	 * @return el daoHabitacion
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOHabitacion getDaoHabitacion() {
		// begin-user-code
		return daoHabitacion;
		// end-user-code
	}

	/** 
	 * @param daoHabitacion el daoHabitacion a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDaoHabitacion(DAOHabitacion daoHabitacion) {
		// begin-user-code
		this.daoHabitacion = daoHabitacion;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOReserva daoReserva;

	/** 
	 * @return el daoReserva
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOReserva getDaoReserva() {
		// begin-user-code
		return daoReserva;
		// end-user-code
	}

	/** 
	 * @param daoReserva el daoReserva a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDaoReserva(DAOReserva daoReserva) {
		// begin-user-code
		this.daoReserva = daoReserva;
		// end-user-code
	}

	/** 
	 * @return el instance
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaDAO getInstance() {
		return instance;
	}

	/** 
	 * @param instance el instance a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setInstance(FactoriaDAO instance) {
		// begin-user-code
		FactoriaDAO.instance = instance;
		// end-user-code
	}

	
}