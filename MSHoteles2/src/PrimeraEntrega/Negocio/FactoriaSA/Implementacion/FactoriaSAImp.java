/**
 * 
 */
package PrimeraEntrega.Negocio.FactoriaSA.Implementacion;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.Cliente.SA.Implementacion.SAClienteImp;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Habitacion.SA.Implementacion.SAHabitacionImp;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
import PrimeraEntrega.Negocio.Reserva.SA.Implementacion.SAReservaImp;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAImp extends FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACliente generaSACliente() {
		return new SAClienteImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAHabitacion generaSAHabitacion() {
		return new SAHabitacionImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAReserva generaSAReserva() {
		return new SAReservaImp();
	}
}