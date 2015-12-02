/**
 * 
 */
package PrimeraEntrega.Integracion.Cliente.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteImp implements DAOCliente, DAOCliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean altaCliente(TransferCliente TCliente) {
		boolean correcto = false;
		Transaction transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		PreparedStatement statementPrepared;
		
		try {
			statementPrepared = conecction.prepareStatement(
					"INSERT INTO Cliente (Nombre, Apellidos, DNI, Descuento, Puntos_Acumulados, flag)");
			statementPrepared.setString(1, TCliente.getNombre());
			statementPrepared.setString(2, TCliente.getApellidos());
			statementPrepared.setString(3, TCliente.getDni());statementPreparedZ
			statementPrepared.setInt(4, TCliente.getDescuento());
			statementPrepared.setInt(5, TCliente.getPuntosAcumulados());
			statementPrepared.setBoolean(6, true); //Activado por defecto, es un alta
			statementPrepared.executeUpdate();
			correcto = true;
		} catch (SQLException e) {
			System.out.println("Error, no se pudo crear el cliente");
			e.printStackTrace();
		}
		return correcto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void bajaCliente(TransferCliente TCliente) {
		boolean correcto;
		int id = TCliente.getID_Cliente();
		Transaction transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Update Cliente SET flag = false where ? =idAeropuerto");
			statement.setInt(1, id);
			statement.executeUpdate();
			correcto = true;
		} catch (SQLException e) {
			valorDevuelto = false;
			e.printStackTrace();
		}
		return correcto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modificarCliente(TransferCliente TCliente) {
		boolean correcto;
		Transaction transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Update Cliente SET Nombre = ?, Apellidos = ?, DNI = ?, Descuento = ?, Puntos_Acumulados = ? WHERE ? = ID_Cliente");
				statement.setString(1, TCliente.getNombre());
				statement.setString(2, TCliente.getApellidos());
				statement.setString(3, TCliente.getDni());
				statement.setInt(4, TCliente.getDescuento());
				statement.setInt(5, TCliente.getPuntos_Acumulados());
				statement.executeUpdate();
				
				correcto = true;
		} catch(SQLException e) {
			correcto = false;
			e.printStackTrace();			
		}
		return correcto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void mostrarCliente() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#mostrarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void mostrarClientes() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}
}