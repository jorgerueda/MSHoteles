/**
 * 
 */
package PrimeraEntrega.Integracion.Reserva.Implementacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
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
				
				//Si no esta activada y tiene id, es decir, que ya existía
				//Se hace Update
				if((!TReserva.isActivo()&&TReserva.getID_Reserva() >= 0)){
					
					PreparedStatement statementPrepared;
					try {
						statementPrepared = connection.prepareStatement(
								"UPDATE Reserva SET Precio = ? , FechaEntrada = ?, FechaSalida = ?, ID_Cliente = ?, ID_Habitacion = -1"
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
								"INSERT INTO Reserva (Precio, FechaEntrada, FechaSalida, ID_Cliente, ID_Habitacion, NumeroOcupantes, ID_Reserva, flag) VALUES (?,?,?,?,?,?,?)");
					
						statementPrepared.setFloat(1, TReserva.getPrecio());
						
						statementPrepared.setDate(2,  TReserva.getFechaEntrada());
						
						statementPrepared.setDate(3,  TReserva.getFechaSalida());
						
						statementPrepared.setInt(4, ID_Cliente);
						
						statementPrepared.setInt(5, -1);
						
						statementPrepared.setInt(6, TReserva.getNumOcupantes());
						
						statementPrepared.setInt(7, TReserva.getID_Reserva());
						
						statementPrepared.setInt(8, 1);
						
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
	public boolean anadirHabitacion(TransferReserva TReserva, int ID_Habitacion) {
		boolean valorDevuelto = false;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if((TReserva.getID_Reserva() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"UPDATE Reserva SET ID_Habitacion = ? WHERE ? = ID_Reserva");
				
				statementPrepared.setInt(1, ID_Habitacion);			
				
				statementPrepared.executeUpdate();

				valorDevuelto = true;
			} catch (SQLException e) {
				System.err.println("Error, no se ha podido añadir la habitacion a la reserva");
				valorDevuelto = false;
				e.printStackTrace();
			}
		}
		return valorDevuelto;
	}

	@Override
	public boolean quitarHabitacion(TransferReserva TReserva) {
		boolean valorDevuelto = false;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if((TReserva.getID_Reserva() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"UPDATE Reserva SET ID_Habitacion = ? WHERE ? = ID_Reserva");
				
				statementPrepared.setInt(1, -1);	//Si el id está a -1 es que no tiene habitación		
				
				statementPrepared.executeUpdate();

				valorDevuelto = true;
			} catch (SQLException e) {
				System.err.println("Error, no se ha podido añadir la habitacion a la reserva");
				valorDevuelto = false;
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
			TReserva.setID_Reserva(id);
		
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Reserva WHERE ID_Reserva = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				TReserva.setPrecio(rs.getFloat("Precio"));
				TReserva.setFechaEntrada(rs.getDate("FechaEntrada"));	
				TReserva.setFechaSalida(rs.getDate("FechaSalida"));
				TReserva.setIdCliente(rs.getInt("ID_Cliente"));
				TReserva.setIdHabitacion(rs.getInt("ID_Habitacion"));
				
				
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
				statementPrepared = connection.prepareStatement("SELECT ID_Reserva FROM Reserva WHERE FechaEntrada = ? AND FechaSalida = ? AND"
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
	
}