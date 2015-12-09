/**
 * 
 */
package PrimeraEntrega.Negocio.Transfer;

public class TransferHabitacion {

	protected int ID_Habitacion;

	protected int Piso;

	protected int Numero;

	protected String Tipo;

	protected boolean Ocupado;

	private boolean activo;

	public boolean isOcupado() {
		// begin-user-code
		return Ocupado;
		// end-user-code
	}

	public void setOcupado(boolean Ocupado) {
		// begin-user-code
		this.Ocupado = Ocupado;
		// end-user-code
	}

	public int getID_Habitacion() {
		return this.ID_Habitacion;

	}

	public void setID_Habitacion(int ID_Habitacion) {
		// begin-user-code
		this.ID_Habitacion = ID_Habitacion;
		// end-user-code
	}

	public int getNumero() {
		return Numero;

	}

	public void setNumero(int Numero) {
		// begin-user-code
		this.Numero = Numero;
		// end-user-code
	}

	public int getPiso() {
		return Piso;

	}

	public void setPiso(int Piso) {
		// begin-user-code
		this.Piso = Piso;
		// end-user-code
	}

	public String getTipo() {
		return Tipo;

	}

	public void setTipo(String Tipo) {
		// begin-user-code
		this.Tipo = Tipo;
		// end-user-code
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setId(int id_hab) {

		this.ID_Habitacion = id_hab;

	}

}