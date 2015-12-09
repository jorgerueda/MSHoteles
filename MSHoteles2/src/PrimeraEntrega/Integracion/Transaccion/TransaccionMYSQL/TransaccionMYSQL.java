/**
 * 
 */
package PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL;

import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransaccionMYSQL implements Transaccion {

	private Connection connection;
	@Override
	public void start() {
		 try {
	           try {
	        	   
	        	 //Driver JDBC
	               Class.forName("com.mysql.jdbc.Driver");
	               //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexion MySQL
	               //panamahitek_text es el nombre que le dimos a la base de datos
	               String servidor = "jdbc:mysql://localhost:3306/mshoteles";
	               //El root es el nombre de usuario por default. No hay pass
	               String usuario = "root";
	               String pass = "";
	               //Se inicia la conexion
	               	connection = DriverManager.getConnection(servidor, usuario, pass);
	                connection.setAutoCommit(false);
	                
	            } catch (ClassNotFoundException e) {
	            	
	                
	                e.printStackTrace();	               
	            }
	        } catch (SQLException e) {
	        	
	            System.err.println("SQLException: " + e.getMessage());
	            System.err.println("SQLState: " + e.getSQLState());
	            System.err.println("VendorError: " + e.getErrorCode());
	        }
	}

	@Override
	public void commit() {
		try {
			connection.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void rollback() {
		try {
			connection.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Connection getResource() {
		return connection;
	}
	
}