/**
 * 
 */
package PrimeraEntrega.Integracion.Reserva;

import java.sql.Date;

import PrimeraEntrega.Negocio.Transfer.TransferReserva;


public interface DAOReserva {

	public int nuevaReserva(TransferReserva Treserva, int ID_Cliente);

	public int anadirHabitacion(TransferReserva Treserva,int ID_Habitacion);

	public int quitarHabitacion(TransferReserva Treserva,int ID_Habitacion);

	public TransferReserva mostrarReserva(int id);

	public boolean eliminarReserva(Integer idReserva);
	
	public int getId(Date entrada, Date salida, int ID_Cliente);
}