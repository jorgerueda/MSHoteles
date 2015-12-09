package PrimeraEntrega.Integracion.query.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Integracion.query.Query;

public class queryHabitacion implements Query {
	public Object execute(int param) {
		// TODO Auto-generated method stub
		ArrayList<TransferHabitacion> ret = new ArrayList<TransferHabitacion>();
		TransferHabitacion transfer = new TransferHabitacion();
		ResultSet rs;
		Statement s;
		String query = "SELECT * FROM Habitacion h WHERE (SELECT COUNT(*) FROM Reserva r, HabitacionesReservadas hr WHERE hr.ID_Habitacion = h.ID_Habitacion AND hr.ID_Reserva = r.ID_Reserva) > " + param;
		try {
			s = TransactionManager.getInstancia().getTransaccion().getResource().createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				transfer.setID_Habitacion(Integer.valueOf(rs.getString("ID_Habitacion")));
				transfer.setNumero(rs.getInt("Numero"));
				transfer.setPiso(rs.getInt("Piso"));
				transfer.setTipo(rs.getString("Tipo"));
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

