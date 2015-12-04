package PrimeraEntrega.Presentacion;

public interface Vista {
	
	/**
	 * Permite actualizar la vista en funcion del evento producido
	 * @param id_evento_vista el id del evento de la vista producido
	 * @param datos los datos
	 */
	public void actualizar(int id_evento_vista, Object datos);

}
