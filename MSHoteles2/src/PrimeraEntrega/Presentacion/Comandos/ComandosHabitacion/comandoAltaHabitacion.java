/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos.ComandosHabitacion;

import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class comandoAltaHabitacion extends Comando{

	@Override
	public RetornoComando execute() {
		int id;
		
		//crea el servicio de departamentos, lo crea utilizando una f�brica
		SAHabitacion saHabitacion = FactoriaSA.getInstancia().generaSAHabitacion();
		
		TransferHabitacion transferHabitacion = (TransferHabitacion)datos; //hacemos casting de los datos del comando
		
		id = saHabitacion.altaHabitacion(transferHabitacion);
		
		RetornoComando retornoComando;

		if(id >= 0){
			retornoComando = new RetornoComando(EventoVista.ALTA_HABITACION_EXITO,id); //crea la respuesta de comando
		}
		else if(id == -1){
			retornoComando = new RetornoComando(EventoVista.ALTA_HABITACION_NUMERO_YA_EXISTE,id); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.ALTA_HABITACION_FALLO,id); //crea la respuesta de comando
		}
		return retornoComando;
	}

}
