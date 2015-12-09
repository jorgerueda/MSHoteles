/**
 * 
 */
package PrimeraEntrega.Negocio.Habitacion.SA;

import java.util.List;

import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;


public interface SAHabitacion {

	public int altaHabitacion(TransferHabitacion THabitacion);

	public TransferHabitacion mostrarHabitacion(int num_habitacion);

	public List<TransferHabitacion> mostrarHabitacionNReservas(int datos);
}