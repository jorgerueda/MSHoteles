/**
 * 
 */
package PrimeraEntrega.Negocio.Transfer;

import java.util.ArrayList;
import java.util.List;


public class TransferCliente {
	
	protected int ID_Cliente;
	
	protected String Nombre;
	
	protected String Apellidos;
	
	protected String Dni;
	
	private boolean activo;
	
	private List<Integer> id_reservas_cliente;
	
	public TransferCliente(){
		
		//Crea la lista
		id_reservas_cliente = new ArrayList<Integer>();
		
		activo = true; //Se crea estando activo
	}

	public int getID_Cliente() {
		
		return this.ID_Cliente;
	}

	public void setID_Cliente(int ID_Cliente) {
		// begin-user-code
		this.ID_Cliente = ID_Cliente;
		// end-user-code
	}





	

	/** 
	 * @return el Nombre
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		return this.Nombre;
	
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

	public List<Integer> getId_reservas_cliente() {
		return id_reservas_cliente;
	}

	public void setId_reservas_cliente(List<Integer> id_reservas_cliente) {
		this.id_reservas_cliente = id_reservas_cliente;
	}
	public void setId(int id_cliente) {

		this.ID_Cliente=id_cliente;
		
	}
	


}