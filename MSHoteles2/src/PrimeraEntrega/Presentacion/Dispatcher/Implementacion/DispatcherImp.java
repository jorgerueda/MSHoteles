/**
 * 
 */
package PrimeraEntrega.Presentacion.Dispatcher.Implementacion;

import PrimeraEntrega.Presentacion.Cliente.GUIAltaCliente;
import PrimeraEntrega.Presentacion.Cliente.GUIBajaCliente;
import PrimeraEntrega.Presentacion.Cliente.GUIModificarCliente;
import PrimeraEntrega.Presentacion.Cliente.GUIMostrarCliente;
import PrimeraEntrega.Presentacion.Cliente.GUIMostrarClientes;
import PrimeraEntrega.Presentacion.Cliente.GUIMostrarClientesNReservas;
import PrimeraEntrega.Presentacion.Dispatcher.Dispatcher;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;
import PrimeraEntrega.Presentacion.Habitacion.GUIAltaHabitacion;
import PrimeraEntrega.Presentacion.Habitacion.GUIMostrarHabitacion;
import PrimeraEntrega.Presentacion.Habitacion.GUIMostrarHabitacionesNReservas;
import PrimeraEntrega.Presentacion.Reserva.GUIAnadirHabitacion;
import PrimeraEntrega.Presentacion.Reserva.GUIMostrarReserva;
import PrimeraEntrega.Presentacion.Reserva.GUINuevaReserva;


public class DispatcherImp extends Dispatcher {

	@Override
	public void dispatch(int id_evento_vista, Object datos) {
	
		switch(id_evento_vista){
		
							//HABITACIONES
		
			case EventoVista.ALTA_HABITACION_EXITO: GUIAltaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_HABITACION_CAPACIDAD_NO_VALIDA: GUIAltaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_HABITACION_NUMERO_YA_EXISTE: GUIAltaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_HABITACION_FALLO: GUIAltaHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_HABITACION_EXITO: GUIMostrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_HABITACION_FALLO: GUIMostrarHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_HABITACION_N_RESERVAS_EXITO: GUIMostrarHabitacionesNReservas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_HABITACION_N_RESERVAS_FALLO: GUIMostrarHabitacionesNReservas.obtenerInstancia().actualizar(id_evento_vista, datos); break;

			
							//CLIENTES
			
			case EventoVista.ALTA_CLIENTE_EXITO: GUIAltaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_CLIENTE_DNI_YA_EXISTE: GUIAltaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_CLIENTE_HABITACION_NO_EXISTE: GUIAltaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_CLIENTE_HABITACION_LLENA: GUIAltaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_CLIENTE_FALLO: GUIAltaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.BAJA_CLIENTE_EXITO: GUIBajaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_CLIENTE_NO_EXISTE: GUIBajaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_CLIENTES_RESERVAS_ASOCIADAS: GUIBajaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.BAJA_CLIENTE_FALLO: GUIBajaCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MODIFICAR_CLIENTE_EXITO: GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_CLIENTE_NO_EXISTE: GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MODIFICAR_CLIENTE_FALLO: GUIModificarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			case EventoVista.MOSTRAR_CLIENTE_EXITO: GUIMostrarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_CLIENTE_FALLO: GUIMostrarCliente.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_CLIENTE_N_RESERVAS_EXITO: GUIMostrarClientesNReservas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_CLIENTE_N_RESERVAS_FALLO: GUIMostrarClientesNReservas.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			
			case EventoVista.MOSTRAR_CLIENTES_EXITO: GUIMostrarClientes.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_CLIENTES_FALLO: GUIMostrarClientes.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			
							//RESERVAS
			
			case EventoVista.ALTA_RESERVA_EXITO: GUINuevaReserva.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_RESERVA_CLIENTE_NO_EXISTE: GUINuevaReserva.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ALTA_RESERVA_FALLO: GUINuevaReserva.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ADD_HABITACION_EXITO: GUIAnadirHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.ADD_HABITACION_FALLO: GUIAnadirHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.QUITAR_HABITACION_EXITO: GUIAnadirHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.QUITAR_HABITACION_FALLO: GUIAnadirHabitacion.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_RESERVA_EXITO: GUIMostrarReserva.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			case EventoVista.MOSTRAR_RESERVA_FALLO: GUIMostrarReserva.obtenerInstancia().actualizar(id_evento_vista, datos); break;
			
			
				
					
		}	
	}

}
