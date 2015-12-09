/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosCliente;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class comandoAltaCliente extends Comando{

	@Override
	public RetornoComando execute() {
		int id;
		SACliente saCliente = FactoriaSA.getInstancia().generaSACliente();
		
		TransferCliente transferCliente = (TransferCliente)datos; //hacemos casting de los datos del comando
		
		id = saCliente.altaCliente(transferCliente);
		
		RetornoComando retornoComando;

		if(id >= 0){
			retornoComando = new RetornoComando(EventoVista.ALTA_CLIENTE_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			retornoComando = new RetornoComando(EventoVista.ALTA_CLIENTE_DNI_YA_EXISTE,id); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.ALTA_HABITACION_FALLO,id); //crea la respuesta de comando
		}
		return retornoComando;
	}

}
