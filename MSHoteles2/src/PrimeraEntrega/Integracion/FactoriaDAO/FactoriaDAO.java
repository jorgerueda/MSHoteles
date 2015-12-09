/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaDAO;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.FactoriaDAO.Implementacion.FactoriaDAOImp;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;


public abstract class FactoriaDAO {

	protected FactoriaDAO() {
	}
	
	private static FactoriaDAO instance;
	
	public abstract DAOCliente getDAOCliente();



	public abstract DAOHabitacion getDAOHabitacion();

	
	public abstract DAOReserva getDAOReserva();

	public static FactoriaDAO getInstance() {

		if (instance == null)
			instance = new FactoriaDAOImp();
		
		return instance;
	}

	
	
}