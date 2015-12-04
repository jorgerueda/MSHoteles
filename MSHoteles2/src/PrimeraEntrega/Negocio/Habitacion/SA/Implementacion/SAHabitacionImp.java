/**
 * 
 */
package PrimeraEntrega.Negocio.Habitacion.SA.Implementacion;

import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Habitacion.DAOHabitacion;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Habitacion.SA.SAHabitacion;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAHabitacionImp implements SAHabitacion {

	public int altaHabitacion(TransferHabitacion THabitacion) {
		

		//Siempre debería cambiarse este valor
		int valorDevuelto = 0;
		
	
			//Obtiene una transacción y la empieza
			Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
			
			transaccion.start();
			
			DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
			
			int id_hab = daoHabitacion.getId(THabitacion.getNumero());
			
			//Comprobación de si existe esa habitación con ese id
			TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(id_hab);
		
			if((transferBuscado != null)&&(transferBuscado.getNumero() == THabitacion.getNumero())){
				
				//Actualizamos el id del transfer con el que ya tenía
				transferBuscado.setId(id_hab);
				
				//Si no esta activo, lo activa
				if(!transferBuscado.isActivo()){
					//Se le pasa el transfer buscado porque ya existe, solo tiene que activarlo usando esa info
					int valorCreacion = daoHabitacion.altaHabitacion(transferBuscado);
					
					//Si devuelve un id correcto
					if(valorCreacion != 0){
						valorDevuelto = THabitacion.getNumero();
						transaccion.commit();
					}
				}
				else{
					//Existe y está activo 
					valorDevuelto = -1;
					transaccion.rollback();
				}
			}
			else{
				int valorCreacion = daoHabitacion.altaHabitacion(THabitacion);
				
				//Si devuelve un id correcto
				if(valorCreacion != 0){
					valorDevuelto = THabitacion.getNumero();
					transaccion.commit();
				}
				else{
					transaccion.rollback();
				}
			}
		
	
		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
		
		return valorDevuelto;
	}

	
	public TransferHabitacion  mostrarHabitacion(int num_habitacion) {
		Transaccion transaccion = TransactionManager.getInstancia().nuevaTransaccion();
		
		transaccion.start();
		
		DAOHabitacion daoHabitacion = FactoriaDAO.getInstance().getDaoHabitacion();
		
		TransferHabitacion transferBuscado = daoHabitacion.buscarHabitacion(daoHabitacion.getId(num_habitacion));
		
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

	

	
}