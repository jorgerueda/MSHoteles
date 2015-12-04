/**
 * 
 */
package PrimeraEntrega.Integracion.Cliente.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteImp implements DAOCliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean altaCliente(TransferCliente TCliente) {
		boolean correcto = false;
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		PreparedStatement statementPrepared;
		
		try {
			statementPrepared = connection.prepareStatement(
					"INSERT INTO Cliente (Nombre, Apellidos, DNI, Descuento, Puntos_Acumulados, flag)");
			statementPrepared.setString(1, TCliente.getNombre());
			statementPrepared.setString(2, TCliente.getApellidos());
			statementPrepared.setString(3, TCliente.getDni());
			statementPrepared.setInt(4, TCliente.getDescuento());
			statementPrepared.setInt(5, TCliente.getPuntos_Acumulados());
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
	@Override
	public boolean bajaCliente(TransferCliente TCliente) {
		boolean correcto;
		int id = TCliente.getID_Cliente();
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Update Cliente SET flag = false where ? =idAeropuerto");
			statement.setInt(1, id);
			statement.executeUpdate();
			correcto = true;
		} catch (SQLException e) {
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
	@Override
	public boolean modificarCliente(TransferCliente TCliente) {
		boolean correcto;
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();
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
	@Override
	public boolean mostrarCliente(TransferCliente TCliente) {
		return false;
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#mostrarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void mostrarClientes() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	
}