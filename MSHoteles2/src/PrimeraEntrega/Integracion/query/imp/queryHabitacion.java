package PrimeraEntrega.Integracion.query.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.Query;

import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;

public class queryHabitacion extends Query {
	public Object execute(Object param) {
		// TODO Auto-generated method stub
		ArrayList<TransferHabitacion> ret = new ArrayList<TransferHabitacion>();
		TransferHabitacion transfer = new TransferHabitacion();
		ResultSet rs;
		Statement s;
		String query = "SELECT * FROM Habitaciones h WHERE (SELECT COUNT(*) FROM Reservas r WHERE h.Id = r.IdHabitacion) > " + param;
		try {
			s = TransactionManager.getInstancia().getTransaccion().getResource().createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				transfer.setID(Integer.valueOf(rs.getString("ID")));
				transfer.setNumero(rs.getString("numero"));
				ret.add(transfer);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// end-user-code
		return ret;
	}

}

