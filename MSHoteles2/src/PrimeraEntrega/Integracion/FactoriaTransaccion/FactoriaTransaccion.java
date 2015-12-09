/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion;

import PrimeraEntrega.Integracion.FactoriaTransaccion.Implementacion.FactoriaTransaccionImp;
import PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL.TransaccionMYSQL;

public abstract class FactoriaTransaccion {

	private static FactoriaTransaccion instancia;


	public static FactoriaTransaccion getInstancia() {
		if (instancia == null) 
			instancia = new FactoriaTransaccionImp();
		return instancia;
	}
	
	public abstract TransaccionMYSQL nuevaTransaccionMySQL();

}