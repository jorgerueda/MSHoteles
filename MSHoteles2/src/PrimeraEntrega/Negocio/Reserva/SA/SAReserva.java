/**
 * 
 */
package PrimeraEntrega.Negocio.Reserva.SA;

import PrimeraEntrega.Negocio.Transfer.TransferReserva;

public interface SAReserva {

	public int nuevaReserva(TransferReserva TReserva);

	public int anadirHabitacion(TransferReserva TReserva);

	public int quitarHabitacion(TransferReserva TReserva);

	public TransferReserva mostrarReserva(int id);
}