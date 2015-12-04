package PrimeraEntrega.Negocio.Transfer;

public class TransferClienteStandar extends TransferCliente {

	private int puntosAcumulados;

	public TransferClienteStandar(){
		//Constructor de la clase residente estudiante
		super();
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
}
