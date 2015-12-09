package PrimeraEntrega.Presentacion.Comandos.ComandosCliente;

import java.util.List;

import PrimeraEntrega.Negocio.Cliente.SA.SACliente;
import PrimeraEntrega.Negocio.FactoriaSA.FactoriaSA;
import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Presentacion.Comandos.Comando;
import PrimeraEntrega.Presentacion.Comandos.RetornoComando;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class comandoMostrarClientesNReservas extends Comando {
	@Override
	public RetornoComando execute() {
		SACliente saCliente = FactoriaSA.getInstancia().generaSACliente();
		
		List<TransferCliente> lista_clientesNReservas = saCliente.mostrarClienteNReservas((int) datos);
		
		RetornoComando retornoComando;
		
		if(lista_clientesNReservas.size()>0){
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTE_N_RESERVAS_EXITO,lista_clientesNReservas); //crea la respuesta de comando
		}
		else{
			retornoComando = new RetornoComando(EventoVista.MOSTRAR_CLIENTE_N_RESERVAS_FALLO,lista_clientesNReservas); //crea la respuesta de comando
		}
		
		return retornoComando;
	}
}



