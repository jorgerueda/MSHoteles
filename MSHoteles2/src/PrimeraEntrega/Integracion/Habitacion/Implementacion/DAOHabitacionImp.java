/**
 * 
 */
package PrimeraEntrega.Integracion.Habitacion.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOHabitacionImp implements DAOHabitacion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int altaHabitacion(TransferHabitacion THabitacion) {
		//Si no se cambia el valor, devuelve error
		int valorDevuelto = -1;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		//Si no esta activada y tiene id, es decir, que ya existía
		//Se hace Update
		if((!THabitacion.isActivo()&&THabitacion.getID_Habitacion() >= 0)){
			
			PreparedStatement statementPrepared;
			try {
				statementPrepared = connection.prepareStatement(
						"UPDATE Habitacion SET Piso = ? , Ocupado = ?, Numero = ?, Tipo = ?, flag = 1; WHERE ? = ID_Habitacion");
				
				statementPrepared.setInt(1, THabitacion.getPiso());
				
				statementPrepared.setBoolean(2, false); //por defecto la creamos sin ocupar
				
				statementPrepared.setInt(3, THabitacion.getNumero());
				
				statementPrepared.setInt(4, THabitacion.getTipo());
				
				statementPrepared.setInt(5, THabitacion.getID_Habitacion());
				
				statementPrepared.executeUpdate();

				valorDevuelto = THabitacion.getID_Habitacion();
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
						"INSERT INTO Habitacion (Piso, Ocupado, Numero, Tipo, ID_Habitacion, flag) VALUES (?,?,?,?,?,?)");
			
				statementPrepared.setInt(1, THabitacion.getPiso());
				
				statementPrepared.setBoolean(2,  false);
				
				statementPrepared.setInt(3,  THabitacion.getNumero());
				
				statementPrepared.setInt(4, THabitacion.getTipo());
				
				statementPrepared.setInt(5, THabitacion.getID_Habitacion());
				
				statementPrepared.setInt(6, 1);
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				valorDevuelto = getId(THabitacion.getNumero());
			
				
			} catch (SQLException e) {
				System.err.println("Error, no se ha creado la habitacion");
				valorDevuelto = -1;
				e.printStackTrace();
			}
			
		}
		
		return valorDevuelto;
	}
	
	@Override
	public TransferHabitacion mostrarHabitacion(int id_hab) {
		TransferHabitacion THabitacion = null;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		try {
			THabitacion.setID_Habitacion(id_hab);
		
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM Habitacion WHERE ID_Habitacion = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id_hab);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				THabitacion.setPiso(rs.getInt("Piso"));	
				THabitacion.setNumero(rs.getInt("Numero"));
				THabitacion.setOcupado(rs.getBoolean("Ocupado"));
				THabitacion.setTipo(rs.getInt("Tipo"));
				
				if(rs.getInt("flag") == 1){
					THabitacion.setActivo(true);
				}
				else{
					THabitacion.setActivo(false);
				}
			}
		} catch(SQLException e) {
			
		}
		return THabitacion;
	}

	public int getId(int numero) {
	int valorDevuelto;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement("SELECT ID_Habitacion FROM Habitacion WHERE Numero = ? FOR UPDATE");
		
			statementPrepared.setInt(1, numero);
		
			statementPrepared.execute();
		
			ResultSet rs = statementPrepared.getResultSet();
		
			//Obtiene el ID de la fila devuelta
			
			//Avanzar el cursor, sino error
			rs.next();
			valorDevuelto = rs.getInt("ID_Habitacion");	
		} catch (SQLException e) {
			valorDevuelto = -1;
			// TODO Auto-generated catch block
			System.err.println("Ese Numero no existe en el sistema");
		}
		
		return valorDevuelto;
	}

	
}