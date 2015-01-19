package Elecrodmestico;

public class Electrodomestico {
	
	static final String COLORDEFECTO="blanco";
	
	protected String color=COLORDEFECTO;
	protected char consumoEnergetico='F';
	protected int precioBase=100;
	protected int peso=5;
	
	
	
	public Electrodomestico(){
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
	}
	
	public Electrodomestico(int precioBase, int peso){
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		this.precioBase=precioBase;
		this.peso=peso;
	}
	
	public Electrodomestico(String color, char consumoEnergetico, int precioBase, int peso){
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		this.precioBase=precioBase;
		this.peso=peso;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public int getPeso() {
		return peso;
	}
	
	
	
	@Override
	public String toString() {
		return "Electrodomestico [color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", precioBase="
				+ precioBase + ", peso=" + peso + "]";
	}

	private void comprobarConsumoEnergetico(char letra){
		if(letra!='A' || letra!='B' || letra!='C' || letra!='D' || letra!='E' || letra!='F')
			this.consumoEnergetico='F';

	}
	
	private void comprobarColor(String color){
		if(color.equals("blanco") || color.equals("negro") || color.equals("rojo") || color.equals("azul") || color.equals("gris")){
			this.color=color;
		}else{
			this.color=COLORDEFECTO;
		}
	}
	
	public int precioFinal(){
		int precioTotal=0;
		switch(this.consumoEnergetico)
		{
		case 'A': precioTotal = this.precioBase + 100;break;
		case 'B': precioTotal = this.precioBase + 80; break;
		case 'C': precioTotal = this.precioBase + 60; break;
		case 'D': precioTotal = this.precioBase + 50; break;
		case 'E': precioTotal = this.precioBase + 30; break;
		case 'F': precioTotal = this.precioBase + 10; break;
		default: break;
		}
		
		if(this.peso >= 0 && this.peso <= 19){
			precioTotal+= 10;
		}else if(this.peso >= 20 && this.peso <= 49){
			precioTotal+=  50;
		}else if(this.peso >= 50 && this.peso <= 79){
			precioTotal+=  80;
		}else if(this.peso >= 80){
			precioTotal+=  100;
		}
		
		return precioTotal;
	}
	

}
