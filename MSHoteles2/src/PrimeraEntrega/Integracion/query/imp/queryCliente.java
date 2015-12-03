package PrimeraEntrega.Integracion.query.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.Query;

import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;

public class queryCliente extends Query {

	public Object execute(Object param) {
		// TODO Auto-generated method stub
		ArrayList<TransferCliente> ret = new ArrayList<TransferCliente>();
		TransferCliente transfer = new TransferCliente();
		ResultSet rs;
		Statement s;
		String query = "SELECT * FROM Cliente c WHERE (SELECT COUNT(*) FROM Reserva r,  WHERE r.IdCliente = c.Id) > " + param;
		try {
			s = TransactionManager.getInstancia().getTransaccion().getResource().createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				transfer.setID(Integer.valueOf(rs.getString("ID")));
				transfer.setNombre(rs.getString("nombre"));
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
