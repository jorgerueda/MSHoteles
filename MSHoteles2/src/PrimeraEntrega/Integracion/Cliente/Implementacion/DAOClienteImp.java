/**
 * 
 */
package PrimeraEntrega.Integracion.Cliente.Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferClienteStandar;
import PrimeraEntrega.Negocio.Transfer.TransferClienteVip;

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
	public int altaCliente(TransferCliente TCliente) {
		//Si no se cambia el valor, devuelve error
				int valorDevuelto = -1;
				
				Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

				Connection connection = (Connection) transaction.getResource();
				
				//Si no esta activada y tiene id, es decir, que ya existía
				//Se hace Update
				if((!TCliente.isActivo()&&TCliente.getID_Cliente() >= 0)){
					
					PreparedStatement statementPrepared;
					try {
						statementPrepared = connection.prepareStatement(
								"UPDATE Cliente SET Nombre = ? , Apellidos = ?, DNI = ?, flag = 1 WHERE ? = ID_Cliente");
						
						statementPrepared.setString(1, TCliente.getNombre());
						
						statementPrepared.setString(2, TCliente.getApellidos());
						
						statementPrepared.setString(3, TCliente.getDni());
						
						statementPrepared.setInt(4, TCliente.getID_Cliente());
						
						statementPrepared.executeUpdate();
		
						valorDevuelto = TCliente.getID_Cliente();
					} catch (SQLException e) {
						System.err.println("Error, no se ha podido efectuar el alta");
						valorDevuelto = -1;
						e.printStackTrace();
					}
					
					
				}
				else{

					//Si no, se hace Insert
					
					//Parte general de todos los tipos de clientes
					try {
						PreparedStatement statementPrepared = connection.prepareStatement(
								"INSERT INTO Clientes (Nombre, Apellidos, DNI, ID_Cliente, flag) VALUES (?,?,?,?,?)");
					
						statementPrepared.setString(1, TCliente.getNombre());
						
						statementPrepared.setString(2,  TCliente.getApellidos());
						
						statementPrepared.setString(3,  TCliente.getDni());
						
						statementPrepared.setInt(4, TCliente.getID_Cliente());
						
						statementPrepared.setInt(5, 1);
						
						statementPrepared.executeUpdate();
						
						statementPrepared = null;
						
						valorDevuelto = getId(TCliente.getDni());
						
						//Comprueba si el cliente es VIP
						if(TCliente.getClass() == TransferClienteVip.class){
							PreparedStatement statementPrepared2 = connection.prepareStatement(
									"INSERT INTO ClienteVip (ID_Cliente, Descuento) VALUES (?,?)");
							
							//Se pone el ID del Cliente
							statementPrepared2.setInt(1, valorDevuelto);
							
							statementPrepared2.setInt(2, ((TransferClienteVip)TCliente).getDescuento());
							
							statementPrepared2.executeUpdate();
						}
						else{
							//Caso de cliente Estandar (No vip)
							
							PreparedStatement statementPrepared2 = connection.prepareStatement(
									"INSERT INTO ClienteEstandar (ID_Cliente, PuntosAcumulados) VALUES (?,?)");
							
							//Se pone el ID del Cliente
							statementPrepared2.setInt(1, valorDevuelto);
							
							statementPrepared2.setInt(2, ((TransferClienteStandar)TCliente).getPuntosAcumulados());
							
							statementPrepared2.executeUpdate();
						}
						
					} catch (SQLException e) {
						System.err.println("Error, no se ha creado el cliente");
						valorDevuelto = -1;
						e.printStackTrace();
					}
					
				}
				
				return valorDevuelto;
			}


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean bajaCliente(int id) {
	boolean valorDevuelto;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Clientes SET flag = false WHERE ? = ID_Cliente");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.executeUpdate();
				
				valorDevuelto = true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public boolean modificarCliente(TransferCliente TCliente) {
		boolean valorDevuelto;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
				PreparedStatement statementPrepared = connection.prepareStatement(
						"UPDATE Clientes SET Nombre = ?, Apellidos = ?, DNI = ? WHERE ? = ID_Cliente");
				
				statementPrepared.setString(1, TCliente.getNombre());
				
				statementPrepared.setString(2, TCliente.getApellidos());
				
				statementPrepared.setString(3, TCliente.getDni());
				
				statementPrepared.setInt(4, TCliente.getID_Cliente());
				
				statementPrepared.executeUpdate();
				
				statementPrepared = null;
				
				if(TCliente.getClass() == TransferClienteVip.class){
					
					statementPrepared = connection.prepareStatement(
							"Select * From ClienteVip WHERE ? = ID_Cliente");
					
					statementPrepared.setInt(1, TCliente.getID_Cliente());
					
					statementPrepared.execute();
					
					ResultSet rs = statementPrepared.getResultSet();
					
					if(rs != null){
						boolean resultadoConsulta = rs.next();
						
						statementPrepared = null;
						
						if(resultadoConsulta){
							//Si hay algo, se hace un update
							
							statementPrepared = connection.prepareStatement(
									"UPDATE ClienteVip SET Descuento = ? WHERE ? = ID_Cliente");
							
							statementPrepared.setInt(1, ((TransferClienteVip)TCliente).getDescuento());
							
							statementPrepared.setInt(2, ((TransferClienteVip)TCliente).getID_Cliente());
							
							statementPrepared.executeUpdate();
						}
						else{
							//Sino, se borra de la otra y se hace un insert (borrado físico)
							
							statementPrepared = connection.prepareStatement(
									"DELETE FROM ClienteEstandar WHERE ? = ID_Cliente");
							
							statementPrepared.setInt(1, TCliente.getID_Cliente());
							
							statementPrepared.executeUpdate();
							
							statementPrepared = null;
							
							statementPrepared = connection.prepareStatement(
									"INSERT INTO ClienteVip (ID_Cliente, Descuento) VALUES (?,?)");
							
							statementPrepared.setInt(1, TCliente.getID_Cliente());
							
							statementPrepared.setInt(2, ((TransferClienteVip)TCliente).getDescuento());
							
							statementPrepared.executeUpdate();
						}
					}
				}
				else if (TCliente.getClass() == TransferClienteStandar.class){
					//Comprobamos si está en la tabla de Residentes no estudiantes
					statementPrepared = connection.prepareStatement(
							"Select * From ClienteEstandar WHERE ? = ID_Cliente");
					
					statementPrepared.setInt(1, TCliente.getID_Cliente());
					
					statementPrepared.execute();
					
					ResultSet rs = statementPrepared.getResultSet();
					
					if(rs != null){
						boolean resultadoConsulta = rs.next();
						
						statementPrepared = null;
						
						if(resultadoConsulta){
							//Si hay algo, se hace un update
							
							statementPrepared = connection.prepareStatement(
									"UPDATE ClienteEstandar SET PuntosAcumulados = ?  WHERE ? = ID_Cliente");
							
							statementPrepared.setInt(1, ((TransferClienteStandar)TCliente).getPuntosAcumulados());
							
							statementPrepared.setInt(3, TCliente.getID_Cliente());
							
							statementPrepared.executeUpdate();
						}
						else{
							//Sino, se borra de la otra y se hace un insert (borrado físico)
							
							statementPrepared = connection.prepareStatement(
									"DELETE FROM ClienteVip WHERE ? = ID_Cliente");
							
							statementPrepared.setInt(1, TCliente.getID_Cliente());
							
							statementPrepared.executeUpdate();
							
							statementPrepared = null;
							
							statementPrepared = connection.prepareStatement(
									"INSERT INTO ClienteEstandar (ID_Cliente, PuntosAcumulados) VALUES (?,?)");
							
							statementPrepared.setInt(1, TCliente.getID_Cliente());
							
							statementPrepared.setInt(2, ((TransferClienteStandar)TCliente).getPuntosAcumulados());
			
							
							statementPrepared.executeUpdate();
						}
					}	
				}
				
				valorDevuelto = true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				valorDevuelto = false;
				e.printStackTrace();
		}
		
		return valorDevuelto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public TransferCliente mostrarCliente(int id) {
		TransferCliente TCliente = null;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		

		try {
			
			//Comprobamos si es Vip
			PreparedStatement statementPrepared = connection.prepareStatement(
					"SELECT * FROM ClienteVip WHERE ID_Cliente = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs3 = statementPrepared.getResultSet();
			
			boolean resultadoConsulta3 = rs3.next();
			
			if(rs3 != null){
				
				//Si devuelve algo es VIP, sino no lo es
				if(resultadoConsulta3){
					TCliente = new TransferClienteVip();
					
					((TransferClienteVip)TCliente).setDescuento(rs3.getInt("Descuento"));
				}
				else{
					//Si no ya sabemos que es estándar.
					TCliente = new TransferClienteStandar();
					
					statementPrepared = null;
					
					statementPrepared = connection.prepareStatement(
							"SELECT * FROM ClienteEstandar WHERE ID_Cliente = ? FOR UPDATE");
					
					statementPrepared.setInt(1, id);
					
					statementPrepared.execute();
					
					ResultSet rs4 = statementPrepared.getResultSet();
					
					boolean resultadoConsulta4 = rs4.next();
					
					if((rs4 != null)&&(resultadoConsulta4)){
						((TransferClienteStandar)TCliente).setPuntosAcumulados(rs4.getInt("PuntosAcumulados"));
					}
				}
				
				//Introduce el ID en el Transfer en este momento
				TCliente.setID_Cliente(id);
			}
	
			//Datos generales del residente
			statementPrepared = null;
			
			statementPrepared = connection.prepareStatement(
					"SELECT * FROM Cliente WHERE ID_Cliente = ? FOR UPDATE");
			
			statementPrepared.setInt(1, id);
			
			statementPrepared.execute();
			
			ResultSet rs = statementPrepared.getResultSet();
		
			boolean resultadoConsulta = rs.next();
			
			//Comprueba si se ha devuelto algo en la consulta
			if((rs != null)&&(resultadoConsulta)){					
				
				//Aplica los datos que había en la BD al transfer
				TCliente.setDni(rs.getString("DNI"));	
				TCliente.setNombre(rs.getString("Nombre"));
				TCliente.setApellidos(rs.getString("Apellidos"));
				
				if(rs.getInt("flag") == 1){
					TCliente.setActivo(true);
				}
				else{
					TCliente.setActivo(false);
				}
				
				statementPrepared = null;
							
				
				//Obtiene el ID de las reservas del cliente
				statementPrepared = connection.prepareStatement(
						"SELECT * FROM Reservas WHERE ID_Cliente = ? AND Activo = 1 FOR UPDATE");
				
				statementPrepared.setInt(1, id);
				
				statementPrepared.execute();
				
				ResultSet rs2 = statementPrepared.getResultSet();
				
				boolean resultadoConsulta2 = rs2.next();
				
				if((rs2 != null)&&(resultadoConsulta2)){	
					
					//Reajustamos el puntero
					rs2.beforeFirst();
					
					//Recorre las facturas de esa habitación y añade sus id al transfer
					while(rs2.next()){
						TCliente.getId_reservas_cliente().add(rs2.getInt("ID_reserva"));
					}
				}
			}		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Si los datos no son correctos, se devuelve null
		if(TCliente.getID_Cliente() < 0){
			TCliente = null;
		}
		
		return TCliente;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#mostrarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public ArrayList<TransferCliente> mostrarClientes() {
		TransferCliente TCliente = null;
		ArrayList<TransferCliente> ret = new ArrayList<TransferCliente>();
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		ResultSet rs;
		Statement s;
		String query = "SELECT * FROM Cliente;";
		try {
			s = TransactionManager.getInstancia().getTransaccion().getResource().createStatement();
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				//no es necesario dividir en ifs ya que si no es dará null
				PreparedStatement statementPrepared = connection.prepareStatement(
						"SELECT * FROM ClienteVip v, Cliente c WHERE v.ID_Cliente = c.ID_Cliente FOR UPDATE");
				
				 rs = statementPrepared.getResultSet();
				if(rs != null) {	
					((TransferClienteVip)TCliente).setDescuento(rs.getInt("Descuento"));
					 statementPrepared = connection.prepareStatement(
							"SELECT * FROM Cliente c, ClienteVip v WHERE c.ID_Cliente = v.ID_Cliente FOR UPDATE");
					rs = statementPrepared.getResultSet();
					TCliente.setNombre(rs.getString("nombre"));
					TCliente.setApellidos(rs.getString("Apellidos"));
					TCliente.setDni(rs.getString("Dni"));
				}
				 statementPrepared = connection.prepareStatement(
							"SELECT * FROM ClienteEstandar e, Cliente c WHERE e.ID_Cliente = c.ID_Cliente FOR UPDATE");
				 rs = statementPrepared.getResultSet();
				 if(rs != null) {
				 ((TransferClienteStandar)TCliente).setPuntosAcumulados(rs.getInt("PuntosAcumulados"));
				 
				 statementPrepared = connection.prepareStatement(
							"SELECT * FROM Cliente c, ClienteEstandar e WHERE c.ID_Cliente = e.ID_Cliente FOR UPDATE");
				rs = statementPrepared.getResultSet();
				TCliente.setNombre(rs.getString("nombre"));
				TCliente.setApellidos(rs.getString("Apellidos"));
				TCliente.setDni(rs.getString("Dni"));
				 }
				if(TCliente != null)
					ret.add(TCliente);			
				}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;			
	}



	@Override
	public int getId(String dni) {
	int valorDevuelto;
		
		Transaccion transaction = TransactionManager.getInstancia().getTransaccion();

		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement statementPrepared;
		try {
			statementPrepared = connection.prepareStatement("SELECT ID_Cliente FROM Cliente WHERE DNI = ? FOR UPDATE");
		
			statementPrepared.setString(1, dni);
		
			statementPrepared.execute();
		
			ResultSet rs = statementPrepared.getResultSet();
		
			//Obtiene el ID de la fila devuelta
			
			//Avanzar el cursor, sino error
			rs.next();
			valorDevuelto = rs.getInt("ID_Cliente");	
		} catch (SQLException e) {
			valorDevuelto = -1;
			// TODO Auto-generated catch block
			System.err.println("Ese DNI no existe en el sistema");
		}
		
		return valorDevuelto;
	}	
}