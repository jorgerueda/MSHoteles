/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosCliente;

import java.util.List;

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
public class comandoMostrarClientes extends Comando {


	@Override
	public RetornoComando execute() {

		List<TransferCliente> lista_residentes = FactoriaSA.getInstancia().generaSACliente().mostrarClientes();
		
		RetornoComando retornoComando;

		if(lista_residentes.size() > 0){
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTES_EXITO,lista_residentes); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTES_FALLO,lista_residentes); //crea la respuesta de comando
		}
		
		return retornoComando;
	}

}
