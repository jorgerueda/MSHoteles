/**
 * 
 */
package PrimeraEntrega.Presentacion.FactoriaComando.Implementacion;

import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoAltaCliente;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoBajaCliente;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoModificarCliente;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoMostrarCliente;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoMostrarClientes;
import PrimeraEntrega.Presentacion.Comandos.ComandosCliente.comandoMostrarClientesNReservas;
import PrimeraEntrega.Presentacion.Comandos.ComandosHabitacion.comandoAltaHabitacion;
import PrimeraEntrega.Presentacion.Comandos.ComandosHabitacion.comandoMostrarHabitacion;
import PrimeraEntrega.Presentacion.Comandos.ComandosHabitacion.comandoMostrarHabitacionesNReservas;
import PrimeraEntrega.Presentacion.Comandos.ComandosReserva.comandoMostrarReserva;
import PrimeraEntrega.Presentacion.Comandos.ComandosReserva.comandoNuevaReserva;
import PrimeraEntrega.Presentacion.Comandos.ComandosReserva.comandoQuitarHabitacion;
import PrimeraEntrega.Presentacion.Comandos.ComandosReserva.comandoAnadirHabitacion;


import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.FactoriaComando.FactoriaComando;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Andrea
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

public class FactoriaComandoImp extends FactoriaComando {
	

	@Override
	public Comando getComando(int id_comando, Object datos) {
		Comando comando = null;
		
		switch (id_comando){

		//Primera Entrega
		case Evento.ALTA_HABITACION: comando = new comandoAltaHabitacion(); break;
		case Evento.MOSTRAR_HABITACION: comando = new comandoMostrarHabitacion(); break;
		case Evento.MOSTRAR_HABITACION_N_RESERVAS: comando = new comandoMostrarHabitacionesNReservas(); break;

		
		case Evento.ALTA_CLIENTE: comando = new comandoAltaCliente(); break;
		case Evento.BAJA_CLIENTE: comando = new comandoBajaCliente(); break;
		case Evento.MODIFICAR_CLIENTE: comando = new comandoModificarCliente(); break;
		case Evento.MOSTRAR_CLIENTE: comando = new comandoMostrarCliente(); break;
		case Evento.MOSTRAR_CLIENTES: comando = new comandoMostrarClientes(); break;
		case Evento.MOSTRAR_CLIENTE_N_RESERVAS: comando = new comandoMostrarClientesNReservas(); break;

		
		case Evento.ALTA_RESERVA: comando = new comandoNuevaReserva(); break;
		case Evento.MOSTRAR_RESERVA: comando = new comandoMostrarReserva(); break;
		case Evento.ANADIR_HABITACION: comando = new comandoAnadirHabitacion(); break;
		case Evento.QUITAR_HABITACION: comando = new comandoQuitarHabitacion(); break;
		//case Evento.MOSTRAR_HABITACION_N_RESERVAS: comando = new comandoMostrarHabitacionNReservas(); break;

		

		}
		
		return comando;
	}

}