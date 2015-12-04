/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RetornoComando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int id_evento_vista; //tiene el id de la respuesta y los datos devueltos
	private Object datos;
	
	public RetornoComando(int id_evento_vista, Object datos){
		this.id_evento_vista = id_evento_vista;
		this.datos = datos;
	}
	
	public int getId_evento_vista() {
		return id_evento_vista;
	}
	public void setId_evento_vista(int id_evento_vista) {
		this.id_evento_vista = id_evento_vista;
	}
	public Object getDatos() {
		return datos;
	}
	public void setDatos(Object datos) {
		this.datos = datos;
	}

}
