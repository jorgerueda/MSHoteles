/**
 * 
 */
package PrimeraEntrega.Integracion.Transaccion;

import java.sql.Connection;


public interface Transaccion {

	Object recurso = null;

	public void start();

	public void commit();


	public void rollback();

	public Connection getResource();
}