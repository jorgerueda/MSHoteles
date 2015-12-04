/**
 * 
 */
package PrimeraEntrega.Negocio.Cliente.SA.Implementacion;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;

import java.util.List;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Integracion.query.factoriaQuery;



public class SAClienteImp implements SACliente {

	public int altaCliente(TransferCliente TCliente) {
		
				//Siempre debería cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transacción y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente= FactoriaDAO.getInstance().getDaoCliente();
				
					
				int id_cliente = daoCliente.getId(TCliente.getDni());
				
				//Comprobación de si existe ese Clientecon ese id
				TransferCliente transferBuscadoCliente = daoCliente.buscarCliente(id_cliente);
			
				if((transferBuscadoCliente!= null)&&(transferBuscadoCliente.getDni().equals(TCliente.getDni()))&&(transferBuscadoCliente.isActivo())){
					
					//Ese Cliente ya existe
					
					//Actualizamos el id del transfer con el que ya tenía
					transferBuscadoCliente.setID_Cliente(id_cliente);
							
					valorDevuelto = -1;
					transaccion.rollback();
					
				}else{
					
					//este if se ejecuta solo si no está activo el Cliente
					if(transferBuscadoCliente != null){
						
						TCliente.setID_Cliente(transferBuscadoCliente.getID_Cliente());
						
						TCliente.setActivo(true);
					}
					
					int valorCreacion = daoCliente.altaCliente(TCliente);
					
					//Si devuelve un id correcto
					if(valorCreacion >= 0){
						valorDevuelto = valorCreacion;
						
						transaccion.commit();
					}
				}
				
				//Elimina la transaccion
				TransactionManager.getInstancia().eliminarTransaccion();
				
				return valorDevuelto;
	}


	public int bajaCliente(String dni) {
		//Siempre debería cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transacción y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
				
				//para liberar  habitación
				DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
					
				int id_cliente = daoCliente.getId(dni);
				
				//Comprobación de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.buscarCliente(id_cliente);
			
				if((transferBuscadoCliente != null)&&(transferBuscadoCliente.getDni().equals(dni))){
					if(transferBuscadoCliente.isActivo()){
						if(transferBuscadoCliente.getId_reservas_cliente().size() == 0){

							//No tiene reservas, se elimina sin hacer nada mas
							boolean valorCreacion =  daoCliente.bajaCliente(transferBuscadoCliente.getID_Cliente());
							
							if(valorCreacion){
								
								valorDevuelto=0;
								transaccion.commit();
								
							}
						
						}else{
							DAOReserva daoReserva = FactoriaDAO.getInstance().getDaoReserva();
							//Se obtiene la ids de las reservas
							for (Integer idReserva:transferBuscadoCliente.getId_reservas_cliente()){
								//Comprobación de si existe esa reserva con ese id
								 daoReserva.eliminarReserva(idReserva);
								
							}
					
									boolean valorCreacion =  daoCliente.bajaCliente(transferBuscadoCliente.getID_Cliente());
									
									//Si devuelve un id correcto
									if(valorCreacion){
										valorDevuelto = transferBuscadoCliente.getID_Cliente();

										transaccion.commit();
									}
								
						}	
						
					}
					else{
						valorDevuelto = -1; //El Cliente no esta existe
						transaccion.rollback();
					}
				}
				else{
					valorDevuelto = -1; //El Cliente no existe
					transaccion.rollback();
				}
				
				return valorDevuelto;
		
	}

	
	public TransferCliente mostrarCliente(String dni) {
		
		Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
		
		TransferCliente transferBuscado = daoCliente.buscarCliente(daoCliente.getId(dni));
		
		//Si no está activa, es como si no la encuentra
		
		if(transferBuscado != null){
			
			//mostrar los id de reservas?
			//transferBuscado.setNum_hab((daoHabitacion.buscarHabitacion(transferBuscado.getNum_hab())).getNumero_hab());
			
			if(!transferBuscado.isActivo()){
				transferBuscado = null;
			}
		}
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
	
		return transferBuscado;
	}
	

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarCliente(TransferCliente transferClienteInformacionNueva) {

				//Siempre debería cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transacción y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
				
				int id_cliente = daoCliente.getId(transferClienteInformacionNueva.getDni());
				
				//Comprobación de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.buscarCliente(id_cliente);
			
				if((transferBuscadoCliente != null)&&(transferBuscadoCliente.getDni().equals(transferClienteInformacionNueva.getDni()))){
					
					//Comprueba si el Cliente está activo
					if(transferBuscadoCliente.isActivo()){
						transferClienteInformacionNueva.setID_Cliente(id_cliente); //se introduce el id al transfer
						
						boolean valorCreacion =daoCliente.modificarCliente(transferClienteInformacionNueva);
						
						//Si devuelve un id correcto
						if(valorCreacion){
							valorDevuelto = transferBuscadoCliente.getID_Cliente();
							
							transaccion.commit();
						}
						else{
							valorDevuelto = -2; //error de BD
							transaccion.rollback();
						}
					}
					else{
						//El Cliente no está activo	
						valorDevuelto = -1; 
						transaccion.rollback();
					}
					
				}
				else{
					//El Cliente no existe
					valorDevuelto = -1; 
					transaccion.rollback();
				}
				return valorDevuelto;
	}

	/** 
	 * (sin Javadoc)
	 * @return 
	 * @see SACliente#mostrarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferCliente> mostrarClientes() {
		//Obtiene una transacción y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
				
				transaccion.start();
				
				//Ejecuta la Query
				List<TransferCliente> lista_Clientes = (List<TransferCliente>) factoriaQuery.getInstance().generateQueryMostrarClientes().execute(null);
				
				//En los mostrar para evitar bloqueos
				transaccion.commit();
				
				//Elimina la transaccion
				TransactionManager.getInstancia().eliminarTransaccion();
				
				return lista_Clientes;
	}
}