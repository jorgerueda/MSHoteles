/**
 * 
 */
package PrimeraEntrega.Negocio.FactoriaSA;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.Implementacion.FactoriaSAImp;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;


public abstract class FactoriaSA {

	private static FactoriaSA instancia;

	public static FactoriaSA getInstancia() {

		if (instancia == null)
			instancia = new FactoriaSAImp();
		
		return instancia;
	}

	public abstract SACliente generaSACliente();

	public abstract SAHabitacion generaSAHabitacion();

	public abstract SAReserva generaSAReserva();
}