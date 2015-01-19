package Elecrodmestico;

public class Lavadora extends Electrodomestico {
	
	static final int CARGADEFECTO=5;
	
	private int carga=CARGADEFECTO;
	
	public Lavadora() {
		
	}
	
	public Lavadora(int precio, int peso) {
		super(precio,peso);
	}
	
	public Lavadora(int carga, int precio, int peso) {
		super(precio,peso);
		this.carga = carga;
	}

	public int getCarga() {
		return carga;
	}
	
	
	
	@Override
	public String toString() {
		return "Lavadora [carga=" + carga + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico
				+ ", precioBase=" + precioBase + ", peso=" + peso + "]";
	}

	public int precioFinal(){
		int precioFinal;
		
		precioFinal = super.precioFinal();
		
		if(this.carga>30){
			precioFinal+=50;
		}
		
		return precioFinal;
	}
	
	
	

}
