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
public class TransferCliente {
	
	protected int ID_Cliente;
	
	protected String Nombre;
	
	protected String Apellidos;
	
	protected String Dni;
	
	private boolean activo;
	

	/** 
	 * @return el ID_Cliente
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getID_Cliente() {
		
		return this.ID_Cliente;
	}

	/** 
	 * @param ID_Cliente el ID_Cliente a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setID_Cliente(int ID_Cliente) {
		// begin-user-code
		this.ID_Cliente = ID_Cliente;
		// end-user-code
	}



	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setApellidos() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDni() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * @return el Nombre
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		return this.Nombre;
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * @param Nombre el Nombre a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNombre(String Nombre) {
		// begin-user-code
		this.Nombre = Nombre;
		// end-user-code
	}

	/** 
	 * @return el Apellidos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getApellidos() {
		return this.Apellidos;
	
	}

	/** 
	 * @param Apellidos el Apellidos a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setApellidos(String Apellidos) {
		// begin-user-code
		this.Apellidos = Apellidos;
		// end-user-code
	}

	/** 
	 * @return el Dni
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDni() {
		return this.Dni;
		
	}

	/** 
	 * @param Dni el Dni a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDni(String Dni) {
		// begin-user-code
		this.Dni = Dni;
		// end-user-code
	}

	public boolean isActivo() {
		// TODO Auto-generated method stub
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo=activo;
	}
}