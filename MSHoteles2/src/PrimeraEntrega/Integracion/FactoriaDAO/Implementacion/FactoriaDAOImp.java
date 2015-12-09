/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO.Implementacion;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.Cliente.Implementacion.DAOClienteImp;
import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Habitacion.Implementacion.DAOHabitacionImp;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Reserva.Implementacion.DAOReservaImp;


public class FactoriaDAOImp extends FactoriaDAO {

	public DAOCliente getDAOCliente() {
		return new DAOClienteImp();
	}


	public DAOHabitacion getDAOHabitacion() {
		return new DAOHabitacionImp();
	}


	public DAOReserva getDAOReserva() {
		return new DAOReservaImp();
	}
}