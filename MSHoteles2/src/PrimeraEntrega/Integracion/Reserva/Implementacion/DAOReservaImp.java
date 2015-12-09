/**
 * 
 */
package PrimeraEntrega.Integracion.Reserva.Implementacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOReservaImp implements DAOReserva {

	@Override
	public int nuevaReserva(TransferReserva TReserva, int ID_Cliente) {
		//Si no se cambia el valor, devuelve error
				int valorDevuelto = -1;
				
				Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

				Connection connection = (Connection) transaction.getResource();
				
				//Si no esta activada y tiene id, es decir, que ya exist�a
				//Se hace Update
				if((!TReserva.isActivo()&&TReserva.getID_Reserva() >= 0)){
					
					PreparedStatement statementPrepared;
					try {
						statementPrepared = connection.prepareStatement(
								"UPDATE Reserva SET Precio = ? , FechaEntrada = ?, FechaSalida = ?, ID_Cliente = ?"
								+ "NumeroOcupantes = ? flag = 1 WHERE ? = ID_Reserva");
						
						statementPrepared.setFloat(1, TReserva.getPrecio());
						
						statementPrepared.setDate(2, TReserva.getFechaEntrada());
						
						statementPrepared.setDate(3, TReserva.getFechaSalida());
						
						statementPrepared.setInt(4, ID_Cliente);
						
						statementPrepared.setInt(5, TReserva.getNumOcupantes());
						
						statementPrepared.setInt(6, TReserva.getID_Reserva());
						
						statementPrepared.executeUpdate();

						valorDevuelto = TReserva.getID_Reserva();
					} catch (SQLException e) {
						System.err.println("Error, no se ha podido efectuar el alta");
						valorDevuelto = -1;
						e.printStackTrace();
					}
					
					
				}
				else{

					//Si no, se hace Insert
					try {
						PreparedStatement statementPrepared = connection.prepareStatement(
								"INSERT INTO Reserva (Precio, FechaEntrada, FechaSalida, ID_Cliente, NumeroOcupantes, flag) VALUES (?,?,?,?,?,?)");
					
						statementPrepared.setFloat(1, TReserva.getPrecio());
						
						statementPrepared.setDate(2, TReserva.getFechaEntrada());
						
						statementPrepared.setDate(3, TReserva.getFechaSalida());
						
						statementPrepared.setInt(4, ID_Cliente);
												
						statementPrepared.setInt(5, TReserva.getNumOcupantes());
												
						statementPrepared.setInt(6, 1);
						
						statementPrepared.executeUpdate();
						
						statementPrepared = null;
						
						valorDevuelto = getId(TReserva.getFechaEntrada(), TReserva.getFechaSalida(), ID_Cliente); //para crear la reserva miramos 
																												 //la ID del cliente y las fechas.
					
						
					} catch (SQLException e) {
						System.err.println("Error, no se ha creado la Reserva");
						valorDevuelto = -1;
						e.printStackTrace();
					}
					
				}
				
				return valorDevuelto;
	}

	@Override
	public int anadirHabitacion(TransferReserva TReserva, int ID_Habitacion) {
		int valorDevuelto = 0;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya exist�a
		//Se hace Update
		if((TReserva.getID_Reserva() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"INSERT INTO HabitacionesReservadas (ID_Habitacion,ID_Reserva) VALUES (?,?)");
				
				statementPrepared.setInt(1, ID_Habitacion);
				statementPrepared.setInt(2, TReserva.getID_Reserva());			

				
				statementPrepared.executeUpdate();

				valorDevuelto = 1;
			} catch (SQLException e) {
				System.err.println("Error, no se ha podido anadir la habitacion a la reserva");
				valorDevuelto = -1;
				e.printStackTrace();
			}
		}
		return valorDevuelto;
	}

	@Override
	public int quitarHabitacion(TransferReserva TReserva,int ID_Habitacion) {
		int valorDevuelto = 0;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya exist�a
		//Se hace Update
		if((TReserva.getID_Reserva() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"DELETE FROM HabitacionesReservadas WHERE ID_Reserva = ? AND ID_Habitacion = ?");
				
				statementPrepared.setInt(1, TReserva.getID_Reserva());
				statementPrepared.setInt(2,ID_Habitacion );

				statementPrepared.executeUpdate();

				valorDevuelto = 1;
			} catch (SQLException e) {
				System.err.println("Error, no se ha podido quitar la habitacion a la reserva");
				valorDevuelto = -1;
				e.printStackTrace();
			}
		}
		return valorDevuelto;
	}

	@Override
	public TransferReserva mostrarReserva(int id) {
		TransferReserva TReserva = null;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		try {
		
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Reserva WHERE ID_Reserva = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				TReserva = new TransferReserva();
				TReserva.setID_Reserva(id);

				//Aplica los datos que hab�a en la BD al transfer
				TReserva.setPrecio(rs.getFloat("Precio"));
				TReserva.setFechaEntrada(rs.getDate("FechaEntrada"));	
				TReserva.setFechaSalida(rs.getDate("FechaSalida"));
				TReserva.setIdCliente(rs.getInt("ID_Cliente"));
				TReserva.setNumOcupantes(Integer.valueOf(rs.getInt("NumeroOcupantes")));
				TReserva.setId_Habitaciones(mostrarHabitacionesReserva(id));
				
				
				
				if(rs.getInt("flag") == 1){
					TReserva.setActivo(true);
				}
				else{
					TReserva.setActivo(false);
				}
			}
		} catch(SQLException e) {
			
		}
		return TReserva;
	}

	@Override
	public boolean eliminarReserva(Integer id) {
		boolean valorDevuelto;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Reserva SET flag = false WHERE ? = ID_Reserva");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.executeUpdate();
				
				valorDevuelto = true;
		} catch (SQLException e) {
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
		
	}
	
	public int getId(Date entrada, Date salida, int ID_Cliente) {
		int valorDevuelto;
			
			Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

			Connection connection = (Connection) transaction.getResource();
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement("SELECT ID_Reserva FROM Reserva WHERE FechaEntrada = ? AND FechaSalida = ? AND "
						+ "ID_Cliente = ? FOR UPDATE");
			
				statementPrepared.setDate(1, entrada);
				
				statementPrepared.setDate(2, salida);
				
				statementPrepared.setInt(3, ID_Cliente);
			
				statementPrepared.execute();
			
				ResultSet rs = statementPrepared.getResultSet();
			
				//Obtiene el ID de la fila devuelta
				
				//Avanzar el cursor, sino error
				rs.next();
				valorDevuelto = rs.getInt("ID_Reserva");	
			} catch (SQLException e) {
				valorDevuelto = -1;
				System.err.println("Esa Reserva no existe en el sistema");
			}
			
			return valorDevuelto;
		}
	
	public ArrayList<Integer> mostrarHabitacionesReserva(int id_reserva) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ResultSet rs;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		
		try {
			statementPrepared = connection.prepareStatement( "SELECT * FROM HabitacionesReservadas WHERE ID_Reserva = ? ");
			statementPrepared.setInt(1, id_reserva);
			statementPrepared.execute();
			rs = statementPrepared.getResultSet();
			while(rs.next()) {
				
				ret.add(Integer.valueOf(rs.getString("ID_Habitacion")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Esa Reserva no tiene habitaciones");

		}
		// end-user-code
		return ret;
	}
	
}