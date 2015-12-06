/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.FactoriaDAO.Implementacion.FactoriaDAOImp;
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
	protected FactoriaDAO() {
	}
	
	private static FactoriaDAO instance;
	
	public abstract DAOCliente getDAOCliente();



	public abstract DAOHabitacion getDAOHabitacion();

	
	public abstract DAOReserva getDAOReserva();

	/** 
	 * @return el instance
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaDAO getInstance() {

		if (instance == null)
			instance = new FactoriaDAOImp();
		
		return instance;
	}

	
	
}