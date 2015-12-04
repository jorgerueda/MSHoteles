/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosCliente;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class comandoBajaCliente extends Comando {
	@Override
	public RetornoComando execute() {
		String dni;
		
		//crea el servicio de clientes, lo crea utilizando una f�brica
		SACliente saCliente = FactoriaSA.getInstancia().generaSACliente();
		
		dni = (String)datos; //hacemos casting de los datos del comando
		
		int valorDevuelto = saCliente.bajaCliente(dni);
		
		RetornoComando retornoComando;

		if(valorDevuelto >= 0){
			retornoComando = new RetornoComando (EventoVista.BAJA_CLIENTE_EXITO,dni); //crea la respuesta de comando
		}
		else if(valorDevuelto == -1){
			retornoComando = new RetornoComando(EventoVista.BAJA_CLIENTE_NO_EXISTE,dni); //crea la respuesta de comando
		}
		
		else{
			retornoComando = new RetornoComando(EventoVista.BAJA_CLIENTE_FALLO,dni); //crea la respuesta de comando
		}
		
		return retornoComando;
	}
}
