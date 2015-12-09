/**
 * 
 */
package PrimeraEntrega.Integracion.Cliente;

import java.util.ArrayList;
import java.util.List;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;


public interface DAOCliente {

	public int altaCliente(TransferCliente TCliente);

	public boolean bajaCliente(int id);

	
	public TransferCliente mostrarCliente(int id);

	public boolean modificarCliente(TransferCliente TCliente);


	public ArrayList<TransferCliente> mostrarClientes();

	public int getId(String dni);

	public List<TransferCliente> mostrarClientesNReservas();



}
