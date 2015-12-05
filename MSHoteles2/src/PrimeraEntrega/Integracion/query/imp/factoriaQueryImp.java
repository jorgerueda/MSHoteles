package PrimeraEntrega.Integracion.query.imp;

import javax.management.Query;

import PrimeraEntrega.Integracion.query.factoriaQuery;
import PrimeraEntrega.Presentacion.Controlador.Evento;

public class factoriaQueryImp extends factoriaQuery {

	@Override
	public Query getQuery(Integer id) {
		Query q = null;
		switch(id){
		case Evento.QUERY_HABITACIONES:
			q = new queryHabitacion();
			break;
		case Evento.QUERY_CLIENTE:
			q = new queryCliente();
			break;
		}
		return q;
	}
}

