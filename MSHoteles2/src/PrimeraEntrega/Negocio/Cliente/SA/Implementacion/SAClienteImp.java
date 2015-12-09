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
		
				//Siempre deberia cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transaccion y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente= FactoriaDAO.getInstance().getDAOCliente();
				
					
				int id_cliente = daoCliente.getId(TCliente.getDni());
				
				//Comprobacion de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.mostrarCliente(id_cliente);
			
				if((transferBuscadoCliente!= null)&&(transferBuscadoCliente.getDni().equals(TCliente.getDni()))&&(transferBuscadoCliente.isActivo())){
					
					//Ese Cliente ya existe
					
					//Actualizamos el id del transfer con el que ya tenia
					transferBuscadoCliente.setID_Cliente(id_cliente);
							
					valorDevuelto = -1;
					transaccion.rollback();
					
				}else{
					
					//este if se ejecuta solo si no esta activo el Cliente
					if(transferBuscadoCliente != null){
						
						TCliente.setID_Cliente(transferBuscadoCliente.getID_Cliente());
						
						TCliente.setActivo(true);
					}
					TCliente.setID_Cliente(id_cliente);
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
		//Siempre deberia cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transaccion y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
				
				//para liberar  habitacion
				DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDAOHabitacion();
					
				int id_cliente = daoCliente.getId(dni);
				
				//Comprobacion de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.mostrarCliente(id_cliente);
			
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
							DAOReserva daoReserva = FactoriaDAO.getInstance().getDAOReserva();
							//Se obtiene la ids de las reservas
							for (Integer idReserva:transferBuscadoCliente.getId_reservas_cliente()){
								//Comprobacion de si existe esa reserva con ese id
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
		
		DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
		
		TransferCliente transferBuscado = daoCliente.mostrarCliente(daoCliente.getId(dni));
		
		//Si no esta activa, es como si no la encuentra
		
		if(transferBuscado != null){
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
	
	public int modificarCliente(TransferCliente transferClienteInformacionNueva) {

				//Siempre deberia cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transaccion y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
					
				transaccion.start();
					
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
				
				int id_cliente = daoCliente.getId(transferClienteInformacionNueva.getDni());
				
				//Comprobacion de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.mostrarCliente(id_cliente);
			
				if((transferBuscadoCliente != null)&&(transferBuscadoCliente.getDni().equals(transferClienteInformacionNueva.getDni()))){
					
					//Comprueba si el Cliente esta activo
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
						//El Cliente no esta activo	
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

	public List<TransferCliente> mostrarClientes() {
		//Obtiene una transaccion y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
				
				transaccion.start();
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
				
				//Ejecuta la Query
				List<TransferCliente> lista_Clientes = daoCliente.mostrarClientes();
				
				//En los mostrar para evitar bloqueos
				transaccion.commit();
				
				//Elimina la transaccion
				TransactionManager.getInstancia().eliminarTransaccion();
				
				return lista_Clientes;
	}


	@Override
	public List<TransferCliente> mostrarClienteNReservas(int Reservas) {
		Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		//Ejecuta la Query
		List<TransferCliente> lista_Clientes = (List<TransferCliente>) factoriaQuery.getInstance().getQuery(206).execute(Reservas);
		
		//En los mostrar para evitar bloqueos
		transaccion.commit();
		
		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
		
	
		return lista_Clientes;
	}
}