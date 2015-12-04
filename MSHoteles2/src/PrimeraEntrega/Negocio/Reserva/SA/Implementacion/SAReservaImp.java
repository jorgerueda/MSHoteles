/**
 * 
 */
package PrimeraEntrega.Negocio.Reserva.SA.Implementacion;

import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Reserva.DAOReserva;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Reserva.SA.SAReserva;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAReservaImp implements SAReserva {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int nuevaReserva(TransferReserva TReserva) {
		//Siempre debería cambiarse este valor
				int valorDevuelto = 0;
				
				//Obtiene una transacción y la empieza
				Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
				
				transaccion.start();
				
				DAOReserva daoReserva = FactoriaDAO.getInstance().getDaoReserva();
				
				//Comprobación del Cliente
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
				
				//Comprobación de la Habitación
				DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
				
				int id_cliente = daoCliente.getId(TReserva.getDniCliente());
				
				//Comprobación de si existe ese Cliente con ese id
				TransferCliente transferBuscadoCliente = daoCliente.buscarCliente(id_cliente);
			
				if((transferBuscadoCliente != null)&&(transferBuscadoCliente.getDni().equals(TReserva.getDniCliente()))){
					
					//Actualizamos el id del transfer con el que ya tenía
					transferBuscadoCliente.setId(id_cliente);
					
					//Si esta activo
					if(transferBuscadoCliente.isActivo()){
						//En el campo id, ponemos el ID del Cliente
						TReserva.setIdCliente(id_cliente);
						//Comprueba la habitación
						
						int id_habitacion = daoHabitacion.getId(TReserva.getNumHabitacion());
						
						//Comprobación de si existe ese Cliente con ese id
						TransferHabitacion transferBuscadoHabitacion = daoHabitacion.buscarHabitacion(id_habitacion);
						
						if((transferBuscadoHabitacion != null)&&(transferBuscadoHabitacion.getNumero()==(TReserva.getNumHabitacion()))){
						
							if(transferBuscadoHabitacion.isActivo()){
								
									TReserva.setIdHabitacion(id_habitacion);
								
									int valorCreacion = daoReserva.nuevaReserva(TReserva);
						
									//Si devuelve un id correcto
									if(valorCreacion != 0){
										valorDevuelto = valorCreacion;
										transaccion.commit();
									}
									else{
										valorDevuelto = -2;
										transaccion.rollback();
									}
							}
							
						}else{
							//No existe Habitacion o no está activo
							valorDevuelto = -1;
							transaccion.rollback();
							}
					}
					else{
					//No existe Cliente o no está activo
					valorDevuelto = -1;
					transaccion.rollback();
					}
				}
				else{
					//No existe Cliente o no está activo
					valorDevuelto = -1;
					transaccion.rollback();
				}
			
			
				//Elimina la transaccion
				TransactionManager.getInstancia().eliminarTransaccion();
				
				return valorDevuelto;
	}

	public TransferReserva mostrarReserva(int id) {
		
		Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOReserva daoReserva = FactoriaDAO.getInstance().getDaoReserva();
		
		TransferReserva transferBuscado = daoReserva.mostrarReserva(id);
		
		//Si no está activa, es como si no la encuentra
		
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

	@Override
	public int anadirHabitacion(TransferReserva TReserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int quitarHabitacion(TransferReserva TReserva) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}