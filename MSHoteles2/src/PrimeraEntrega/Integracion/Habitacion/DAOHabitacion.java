/**
 * 
 */
package PrimeraEntrega.Integracion.Habitacion;

import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;


public interface DAOHabitacion {

	public int altaHabitacion(TransferHabitacion THabitacion);

	public TransferHabitacion mostrarHabitacion(int id_hab);

	public int getId(int numero);
}