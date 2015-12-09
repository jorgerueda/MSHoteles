/**
 * 
 */
package PrimeraEntrega.Negocio.Transfer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransferReserva {

	protected int ID_Reserva;

	protected float Precio;

	protected Date FechaEntrada;

	protected Date FechaSalida;

	private boolean activo;

	private String dniCliente;

	private int numHabitacion;

	private int idCliente;

	private int numOcupantes;

	private List<Integer> id_Habitaciones;

	public TransferReserva() {

		// Crea la lista
		id_Habitaciones = new ArrayList<Integer>();

		activo = true; // Se crea estando activo
	}

	public int getID_Reserva() {
		return ID_Reserva;

	}

	public void setID_Reserva(int ID_Reserva) {
		// begin-user-code
		this.ID_Reserva = ID_Reserva;
		// end-user-code
	}

	public float getPrecio() {
		return Precio;

	}

	public void setPrecio(float Precio) {
		// begin-user-code
		this.Precio = Precio;
		// end-user-code
	}

	public Date getFechaEntrada() {
		return FechaEntrada;

	}

	public void setFechaEntrada(Date FechaEntrada) {
		// begin-user-code
		this.FechaEntrada = FechaEntrada;
		// end-user-code
	}

	public Date getFechaSalida() {
		return FechaSalida;

	}

	public void setFechaSalida(Date FechaSalida) {
		// begin-user-code
		this.FechaSalida = FechaSalida;
		// end-user-code
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public void setId(int idReserva) {
		this.ID_Reserva = idReserva;

	}

	public int getNumOcupantes() {
		return numOcupantes;
	}

	public void setNumOcupantes(int numOcupantes) {
		this.numOcupantes = numOcupantes;
	}

	public List<Integer> getId_Habitaciones() {
		return id_Habitaciones;
	}

	public void setId_Habitaciones(List<Integer> id_Habitaciones) {
		this.id_Habitaciones = id_Habitaciones;
	}

	public void setIdHabitacion(Integer id_Habitacion) {
		this.id_Habitaciones.add(id_Habitacion);
	}

	public void removeIdHabitacion(Integer id_Habitacion) {
		this.id_Habitaciones.remove(id_Habitacion);
	}

}