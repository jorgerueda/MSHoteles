/**
 * 
 */
package PrimeraEntrega.Presentacion.Comandos;



public abstract class Comando {

	protected Object datos;

	public abstract RetornoComando execute();
	

	public void setDatos(Object datos){
		this.datos = datos;
	}
	

	public Object getDatos(){
		return this.datos;
	}
}
