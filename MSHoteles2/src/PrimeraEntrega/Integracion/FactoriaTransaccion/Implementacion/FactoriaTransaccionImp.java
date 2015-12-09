/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion.Implementacion;

import PrimeraEntrega.Integracion.FactoriaTransaccion.FactoriaTransaccion;
import PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL.TransaccionMYSQL;

public class FactoriaTransaccionImp extends FactoriaTransaccion {

	@Override
	public TransaccionMYSQL nuevaTransaccionMySQL() {

		return new TransaccionMYSQL();
	}
}