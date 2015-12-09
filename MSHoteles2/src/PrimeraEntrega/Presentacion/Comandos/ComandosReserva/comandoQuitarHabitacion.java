/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosReserva;

import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
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
public class comandoQuitarHabitacion extends Comando{

	@Override
	public RetornoComando execute() {
		int id;
		
		SAReserva saReserva = FactoriaSA.getInstancia().generaSAReserva();
		
		TransferReserva transferReserva = (TransferReserva)datos; //hacemos casting de los datos del comando
		
		id = saReserva.quitarHabitacion(transferReserva);
		
		RetornoComando retornoComando;

		if(id >= 0){
			retornoComando = new RetornoComando(EventoVista.QUITAR_HABITACION_EXITO,id); //crea la respuesta de comando
		}
		
		else{
			retornoComando = new RetornoComando(EventoVista.QUITAR_HABITACION_FALLO,id); //crea la respuesta de comando
		}
		return retornoComando;
	}

}