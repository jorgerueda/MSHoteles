/**
 * 
 */
package PrimeraEntrega.Negocio.Cliente.SA.Implementacion;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Integracion.Cliente.DAOCliente;
import PrimeraEntrega.Integracion.FactoriaDAO.FactoriaDAO;
import PrimeraEntrega.Integracion.Transaccion.Transaccion;
import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClienteImp implements SACliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean altaCliente(TransferCliente TCliente) {
		
		Boolean esta = false;
		Boolean correcto = false;
		
		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
		
		transaction.start();
		
		DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
		
		// buscamos al cliente
		esta = daoCliente.buscarClienteNombre(TCliente);

		if (!esta){
			correcto = daoCliente.altaCliente(TCliente);
			transaction.commit();
		}else if (esta){ // esta
			// Si no esta activo
			if (!TCliente.isActivo()){
				TCliente.setActivo(true);
				correcto = daoCliente.modificarCliente(TCliente);
				transaction.commit();
			} else {
				transaction.rollback();
			}
		}
		
		TransactionManager.getInstancia().eliminarTransaccion();
		
		return correcto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean bajaCliente(TransferCliente TCliente) {
		
		Boolean correcto = true;
		Boolean esta = false;
		
		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
		
		transaction.start();
		
		DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
		
		// Buscamos al cliente
		esta = daoCliente.buscarClienteNombre(TCliente);
			
		// !esta
				if(!esta){	
					transaction.rollback();
								
				}   // esta
					else if (esta){
						// Si esta activo
						if(TCliente.isActivo()){
							// Lo activamos
							TCliente.setActivo(false);
							correcto = daoCliente.bajaCliente(TCliente);
							transaction.commit();
							
						} else {// Si no esta activo
							transaction.rollback();
						}
					
				}
		
		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
			
		return correcto;
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente mostrarCliente(TransferCliente TCliente) {
		
		Boolean esta = false;
		TransferCliente clienteEncontrado = new TransferCliente();

		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
						
		transaction.start();

		DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
					
				// Leemos cliente
		esta = daoCliente.buscarClienteNombre(TCliente);
		
		// esta
		if(esta){	
					
			if(!TCliente.isActivo()){
				clienteEncontrado = null;
				transaction.rollback();
						
			} else {// Si esta activo
				clienteEncontrado = daoCliente.mostrarCliente(TCliente);
				transaction.commit();
				
			}		
		}   else if (!esta){ // !esta
			// Si no esta activo
			clienteEncontrado = null;
			transaction.rollback();			
		}

		//Elimina la transaccion
		TransactionManager.getInstancia().eliminarTransaccion();
			
		return clienteEncontrado;	
	}
	

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void modificarCliente(TransferCliente TCliente) {

		Boolean esta = false;
		Boolean correcto = false;
		
		// Iniciamos la transaction
		Transaccion transaction = TransactionManager.getInstancia().crearTransaccion();
		
		transaction.start();
		
		DAOCliente daoCliente = FactoriaDAO.getInstance().getDaoCliente();
		
		// Leemos terminal
		esta = daoCliente.buscarClienteNombre(TCliente);
		
		// esta
		if(esta){
			
			// Si no esta activo
			if(TCliente.isActivo()){
			
				correcto = daoCliente.modificarCliente(TCliente);
				transaction.commit();
								
			} else {// Si esta activo
			transaction.rollback();	
			}
		}// !esta
		else if (!esta){
			transaction.rollback();
		}
	
		return correcto;
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#mostrarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void mostrarClientes() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}