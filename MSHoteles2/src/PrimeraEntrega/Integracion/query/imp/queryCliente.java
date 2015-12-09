package PrimeraEntrega.Integracion.query.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import PrimeraEntrega.Integracion.TransactionManager.TransactionManager;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Integracion.query.Query;

public class queryCliente implements Query {

	public Object execute(int param) {
		// TODO Auto-generated method stub
		ArrayList<TransferCliente> ret = new ArrayList<TransferCliente>();
		ResultSet rs;
		Statement s;
		String query = "SELECT * FROM Cliente c WHERE (SELECT COUNT(*) FROM Reserva r  WHERE r.ID_Cliente = c.ID_Cliente) > " + param;
		try {
			s = TransactionManager.getInstancia().getTransaccion().getResource().createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				TransferCliente transfer = new TransferCliente();
				transfer.setID_Cliente(Integer.valueOf(rs.getString("ID_Cliente")));
				transfer.setNombre(rs.getString("Nombre"));
				transfer.setApellidos(rs.getString("Apellidos"));
				transfer.setDni(rs.getString("DNI"));
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
