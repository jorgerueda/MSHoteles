/**
 * 
 */
package PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL;

import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransaccionMYSQL implements Transaccion {

	private Connection connection;
	@Override
	public void start() {
		 try {
	           try {
	        	   
	                Class.forName("com.mysql.jdbc.Driver");
	                connection = DriverManager.getConnection("jdbc:mysql://localhost/mshoteles", "root", "");
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