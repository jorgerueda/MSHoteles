/**
 * 
 */
package PrimeraEntrega.Negocio.FactoriaSA;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.Implementacion.FactoriaSAImp;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaSA instancia;

	/** 
	 * @return el instancia
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public FactoriaSA getInstancia() {

		if (instancia == null)
			instancia = new FactoriaSAImp();
		
		return instancia;
	}


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SACliente generaSACliente();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAHabitacion generaSAHabitacion();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAReserva generaSAReserva();
}