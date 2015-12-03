package PrimeraEntrega.Integracion.query.imp;

import javax.management.Query;

import PrimeraEntrega.Integracion.query.factoriaQuery;

public class factoriaQueryImp extends factoriaQuery {

	@Override
	public Query getQuery(Integer id) {
		Query q = null;
		switch(id){
		case Eventos.QUERY_HABITACIONES:
			q = new queryHabitacion();
			break;
		case Eventos.QUERY_CLIENTE:
			q = new queryCliente();
			break;
		}
		return q;
	}

