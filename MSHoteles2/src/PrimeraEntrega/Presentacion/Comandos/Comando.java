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
public abstract class Comando {

	protected Object datos;
	
	/**
	 * Ejecuta el comando
	 * @return devuelve la respuesta del comando tras su ejecucion
	 */
	public abstract RetornoComando execute();
	
	/**
	 * Permite cambiar los datos del comando
	 * @param datos los datos del comando
	 */
	public void setDatos(Object datos){
		this.datos = datos;
	}
	
	/**
	 * Permite obtener los datos del comando
	 * @return
	 */
	public Object getDatos(){
		return this.datos;
	}
}
