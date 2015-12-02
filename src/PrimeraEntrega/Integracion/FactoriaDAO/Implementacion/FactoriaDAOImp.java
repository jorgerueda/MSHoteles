/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO.Implementacion;

import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaDAOImp extends FactoriaDAO {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void getClassLoader() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void getResourcesAsStream() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#getDAOCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void getDAOCliente() {
		return new DAOClienteImp();
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#getDAOHabitacion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void getDAOHabitacion() {
		return new DAOHabitacionImp();
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#getDAOReserva()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void getDAOReserva() {
		return new DAOReservaImp();
	}
}