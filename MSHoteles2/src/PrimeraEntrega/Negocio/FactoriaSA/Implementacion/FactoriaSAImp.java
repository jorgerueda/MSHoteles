/**
 * 
 */
package PrimeraEntrega.Negocio.FactoriaSA.Implementacion;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.Cliente.SA.Implementacion.SAClienteImp;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Habitacion.SA.Implementacion.SAHabitacionImp;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
import PrimeraEntrega.Negocio.Reserva.SA.Implementacion.SAReservaImp;


public class FactoriaSAImp extends FactoriaSA {

	public SACliente generaSACliente() {
		return new SAClienteImp();
	}

	public SAHabitacion generaSAHabitacion() {
		return new SAHabitacionImp();
	}
	
	public SAReserva generaSAReserva() {
		return new SAReservaImp();
	}
}