/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosReserva;

import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class comandoNuevaReserva extends Comando{

	@Override
	public RetornoComando execute() {
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una f�brica
		SAReserva saReserva = FactoriaSA.getInstancia().generaSAReserva();
		
		TransferReserva transferReserva = (TransferReserva)datos; //hacemos casting de los datos del comando
		
		id = saReserva.nuevaReserva(transferReserva);
		
		RetornoComando retornoComando;

		if(id >= 0){
			retornoComando = new RetornoComando(EventoVista.ALTA_RESERVA_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			retornoComando = new RetornoComando(EventoVista.ALTA_RESERVA_CLIENTE_NO_EXISTE,id); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.ALTA_RESERVA_FALLO,id); //crea la respuesta de comando
		}
		return retornoComando;
	}

}