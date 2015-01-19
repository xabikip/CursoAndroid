package Elecrodmestico;

public class Television extends Electrodomestico{
	
	private int resolucion=20;
	private boolean sintotizadorTDT=false;

	public Television() {
		
	}
	
	public Television(int precio, int peso) {
		super(precio, peso);
	}
	
	public Television(int resolucion, boolean sintotizadorTDT) {
		this.resolucion = resolucion;
		this.sintotizadorTDT = sintotizadorTDT;
	}

	public int getResolucion() {
		return resolucion;
	}

	public boolean isSintotizadorTDT() {
		return sintotizadorTDT;
	}
	
	
	
	@Override
	public String toString() {
		return "Television [resolucion=" + resolucion + ", sintotizadorTDT=" + sintotizadorTDT + ", color=" + color
				+ ", consumoEnergetico=" + consumoEnergetico + ", precioBase=" + precioBase + ", peso=" + peso + "]";
	}

	public int precioFinal() {
		int precioFinal;
		precioFinal = super.precioFinal();
		
		if(this.resolucion > 40){
			precioFinal*=1.3;
		}
		if(this.sintotizadorTDT){
			precioFinal+=50;
		}
		
		return precioFinal;
	}

}
