/**
 * 
 */
package PrimeraEntrega.Negocio.Transfer;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferHabitacion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	protected int ID_Habitacion;
	
	protected int Piso;
	
	protected int Numero;
	
	protected int Tipo;
	
	protected boolean Ocupado;
	
	private boolean activo;

	/** 
	 * @return el Ocupado
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean isOcupado() {
		// begin-user-code
		return Ocupado;
		// end-user-code
	}

	/** 
	 * @param Ocupado el Ocupado a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setOcupado(boolean Ocupado) {
		// begin-user-code
		this.Ocupado = Ocupado;
		// end-user-code
	}

	/** 
	 * @return el ID_Habitacion
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getID_Habitacion() {
		return this.ID_Habitacion;
	
	}

	/** 
	 * @param ID_Habitacion el ID_Habitacion a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setID_Habitacion(int ID_Habitacion) {
		// begin-user-code
		this.ID_Habitacion = ID_Habitacion;
		// end-user-code
	}

	/** 
	 * @return el Numero
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getNumero() {
		return Numero;
		
	}

	/** 
	 * @param Numero el Numero a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNumero(int Numero) {
		// begin-user-code
		this.Numero = Numero;
		// end-user-code
	}

	/** 
	 * @return el Piso
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getPiso() {
		return Piso;
		
	}

	/** 
	 * @param Piso el Piso a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPiso(int Piso) {
		// begin-user-code
		this.Piso = Piso;
		// end-user-code
	}

	/** 
	 * @return el Tipo
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getTipo() {
		return Tipo;
		
	}

	/** 
	 * @param Tipo el Tipo a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setTipo(int Tipo) {
		// begin-user-code
		this.Tipo = Tipo;
		// end-user-code
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setId(int id_hab) {
		
		this.ID_Habitacion= id_hab;
		
	}

}