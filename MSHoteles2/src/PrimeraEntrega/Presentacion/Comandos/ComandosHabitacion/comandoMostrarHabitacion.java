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
public class comandoMostrarHabitacion extends Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public RetornoComando execute() {
		SAHabitacion saHabitacion = FactoriaSA.getInstancia().generaSAHabitacion();
		
		TransferHabitacion transferHabitacion = saHabitacion.mostrarHabitacion((int)datos);
		
		RetornoComando retornoComando;
		
		if((transferHabitacion != null)&&(transferHabitacion.isActivo())){
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_HABITACION_EXITO,transferHabitacion); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_HABITACION_FALLO,transferHabitacion); //crea la respuesta de comando
		}
		
		return retornoComando;
	}
}