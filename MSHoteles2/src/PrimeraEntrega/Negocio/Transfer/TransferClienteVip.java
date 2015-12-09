package PrimeraEntrega.Negocio.Transfer;

public class TransferClienteVip extends TransferCliente{
	
	private int descuento;
	
	public TransferClienteVip(){
		super();
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
