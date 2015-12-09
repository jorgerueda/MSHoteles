/**
 * 
 */
package PrimeraEntrega.Negocio.Cliente.SA;
import java.util.List;

import javax.swing.Spring;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface SACliente {


	
	/**
	 * Permite dar de alta un cliente en el sistema
	 * Hace dos comprobaciones de ID:
	 * 1: Para ver si existe es ID en el sistema
	 * 2: Para obtener el ID en el caso de que no exista
	 * Si est� desactivada la habitaci�n, la activa con la capacidad anterior
	 * 
	 * @param transferResidente La informaci�n del residente que se desea dar de alta
	 * @return Un flag indicando si se ha dado el residente de alta o no 
	 *  Un n�mero mayor o igual que 0, Alta exitosa (devuelve el ID en ese caso)
	 * -1 dni ya existe y activo 
	 * -2 Otro fallo
	 */
	public int altaCliente(TransferCliente TCliente);

	
	/**
	 * Permite borrar un cliente en el sistema (borrado l�gico)
	 * Debe ajustar lo correspondiente de las habitaciones (ocupantes)
	 * @param dni El dni del residente que se desea dar de baja
	 * @return flag indicando si se ha borrado la habitaci�n o no
	 *  0 Borrado exitoso
	 * -1 No existe el residente con ese dni
	 * -2 Otro fallo
	 */
	
	public int bajaCliente(String DNI);

	/**
	 * Permite buscar un cliente  en el sistema y mostrar su informaci�n
	 * En el caso de que ese cliente est� activa
	 * @param DNI El DNI del cliente que se quiere buscar
	 * @return La informaci�n del cliente buscado (null si no la encuentra)
	 */
	public TransferCliente mostrarCliente(String DNI);


	/**
	 * Permite obtener la informaci�n de los cliente del sistema
	 * Exclusivamente de los cliente activos
	 * Devuelve una lista vacia en el caso de que no haya cliente
	 * @return Una lista con la informaci�n de los cliente en el sistema
	 */
	
	public List<TransferCliente> mostrarClientes();

	/**
	 * Permite modificar un cliente ya existente
	 * Solo se puede modifcar aqullo que se considere modificable en cliente existentes y activos
	 * @param transferClienteInformacionNueva la nueva informaci�n del cliente
	 * @return Un flag indicando si se ha modificado la habitaci�n o no
	 *   0 Modificaci�n exitosa
	 *  -1 No existe el residente con ese dni
	 *  -2 Otro fallo
	 */
	
	public int modificarCliente(TransferCliente TCliente);


	public List<TransferCliente> mostrarClienteNReservas(int Reservas);
}