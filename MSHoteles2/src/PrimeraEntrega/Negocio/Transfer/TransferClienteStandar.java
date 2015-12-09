package PrimeraEntrega.Negocio.Transfer;

public class TransferClienteStandar extends TransferCliente {

	private int puntosAcumulados;

	public TransferClienteStandar(){
		super();
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
}
