/**
 * 
 */
package PrimeraEntrega.Integracion.FactoriaTransaccion.Implementacion;

import PrimeraEntrega.Integracion.FactoriaTransaccion.FactoriaTransaccion;
import PrimeraEntrega.Integracion.Transaccion.TransaccionMYSQL.TransaccionMYSQL;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaTransaccionImp extends FactoriaTransaccion {

	@Override
	public TransaccionMYSQL nuevaTransaccionMySQL() {

		return new TransaccionMYSQL();
	}
}