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
public class comandoMostrarCliente extends Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public RetornoComando execute() {
		SACliente saCliente = FactoriaSA.getInstancia().generaSACliente();
		
		TransferCliente transferCliente = saCliente.mostrarCliente((String)datos);
		
		RetornoComando retornoComando;
		
		if((transferCliente != null)&&(transferCliente.isActivo())){
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTE_EXITO,transferCliente); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTE_FALLO,transferCliente); //crea la respuesta de comando
		}
		
		return retornoComando;
	}
}
