package PrimeraEntrega.Integracion.query.imp;


import PrimeraEntrega.Integracion.query.Query;
import PrimeraEntrega.Integracion.query.factoriaQuery;
import PrimeraEntrega.Presentacion.Controlador.Evento;

public class factoriaQueryImp extends factoriaQuery {

	@Override
	public Query getQuery(Integer id) {
		Query q = null;
		switch(id){
		case Evento.MOSTRAR_HABITACION_N_RESERVAS:
			q = new queryHabitacion();
			break;
		case Evento.MOSTRAR_CLIENTE_N_RESERVAS:
			q = new queryCliente();
			break;
		}
		return q;
	}
}

