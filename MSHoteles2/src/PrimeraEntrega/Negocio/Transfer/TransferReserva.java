/**
 * 
 */
package PrimeraEntrega.Negocio.Transfer;

import java.sql.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferReserva {
	
	protected int ID_Reserva;
	
	protected float Precio;
	
	protected Date FechaEntrada;

	protected Date FechaSalida;
	
	private boolean activo;
	
	private String dniCliente;
	
	private int numHabitacion;
	
	private int idCliente;
	
	private int idHabitacion;
	

	
	public int getID_Reserva() {
		return ID_Reserva;
		
	}

	/** 
	 * @param ID_Reserva el ID_Reserva a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setID_Reserva(int ID_Reserva) {
		// begin-user-code
		this.ID_Reserva = ID_Reserva;
		// end-user-code
	}

	/** 
	 * @return el Precio
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float getPrecio() {
		return Precio;
	
	}

	/** 
	 * @param Precio el Precio a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPrecio(float Precio) {
		// begin-user-code
		this.Precio = Precio;
		// end-user-code
	}

	/** 
	 * @return el FechaEntrada
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFechaEntrada() {
		return FechaEntrada;
		
	}

	/** 
	 * @param FechaEntrada el FechaEntrada a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaEntrada(Date FechaEntrada) {
		// begin-user-code
		this.FechaEntrada = FechaEntrada;
		// end-user-code
	}

	/** 
	 * @return el FechaSalida
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFechaSalida() {
		return FechaSalida;
		
	}

	/** 
	 * @param FechaSalida el FechaSalida a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaSalida(Date FechaSalida) {
		// begin-user-code
		this.FechaSalida = FechaSalida;
		// end-user-code
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public void setId(int idReserva) {
		this.ID_Reserva = idReserva;
		
	}

	

}