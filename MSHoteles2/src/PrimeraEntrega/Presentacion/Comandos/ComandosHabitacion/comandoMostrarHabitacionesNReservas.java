package PrimeraEntrega.Presentacion.Comandos.ComandosHabitacion;

import java.util.List;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class comandoMostrarHabitacionesNReservas extends Comando {
	@Override
	public RetornoComando execute() {
		SAHabitacion saHabitacion = FactoriaSA.getInstancia().generaSAHabitacion();
		
		List<TransferHabitacion> lista_HabitacionesNReservas = saHabitacion.mostrarHabitacionNReservas((int) datos);
		
		RetornoComando retornoComando;
		
		if(lista_HabitacionesNReservas.size()>0){
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_HABITACION_N_RESERVAS_EXITO,lista_HabitacionesNReservas); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_HABITACION_N_RESERVAS_FALLO,lista_HabitacionesNReservas); //crea la respuesta de comando
		}
		
		return retornoComando;
	}
}



