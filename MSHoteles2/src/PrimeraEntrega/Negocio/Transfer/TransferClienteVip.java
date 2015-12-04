package PrimeraEntrega.Negocio.Transfer;

public class TransferClienteVip extends TransferCliente{
	
	private int descuento;
	
	public TransferClienteVip(){
		//Constructor de la clase residente estudiante
		super();
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
