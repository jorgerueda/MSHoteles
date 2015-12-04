/**
 * 
 */
package PrimeraEntrega.Integracion.Habitacion.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public boolean altaHabitacion(TransferHabitacion THabitacion) {
		boolean correcto = false;
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		PreparedStatement statementPrepared;
		
		try {
			statementPrepared = connection.prepareStatement(
					"INSERT INTO Habitacion (Piso, Ocupado, Numero, Tipo, flag)");
			statementPrepared.setInt(1, THabitacion.getNumero());
			statementPrepared.setBoolean(2, THabitacion.getOcupado());
			statementPrepared.setInt(3, THabitacion.getPiso());
			statementPrepared.setInt(4, THabitacion.getTipo());
			statementPrepared.setBoolean(4, true); //Activado por defecto, es un alta
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
	public boolean mostrarHabitacion(TransferHabitacion THabitacion) {
		boolean correcto = false;
		
		return correcto;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOHabitacion#buscarHabitacion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean buscarHabitacion(TransferHabitacion THabitacion) {
		boolean correcto = false;
		
		return correcto;
		
	}
}