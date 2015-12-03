/**
 * 
 */
package PrimeraEntrega.Integracion.Reserva.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOReservaImp implements DAOReserva {

	@Override
	public boolean nuevaReserva(TransferReserva Treserva) {
		boolean correcto = false;
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		PreparedStatement statementPrepared;
		
		try {
			statementPrepared = connection.prepareStatement(
					"INSERT INTO Habitacion (Piso, Ocupado, Numero, Tipo, flag)");
			statementPrepared.setDate(1, Treserva.getFechaEntrada());
			statementPrepared.setDate(2, Treserva.getFechaSalida());
			statementPrepared.setFloat(3, Treserva.getPrecio());
			statementPrepared.setBoolean(4, true); //Activado por defecto, es un alta
			statementPrepared.executeUpdate();
			correcto = true;
		} catch (SQLException e) {
			System.out.println("Error, no se pudo crear el cliente");
			e.printStackTrace();
		}
		return correcto;
	}

	@Override
	public boolean anadirHabitacion(TransferReserva Treserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitarHabitacion(TransferReserva Treserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mostrarReserva(TransferReserva Treserva) {
		// TODO Auto-generated method stub
		return false;
	}
	
}