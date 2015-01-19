package Elecrodmestico;

public class ElectrodomesticoMain {
	
	public static void main(String[] args) {
		
		int totalLavadora=0;
		int totalTelevision=0;
		int total=0;
		
		Electrodomestico arrayElectrodomestico[] = new Electrodomestico[10];
		
		arrayElectrodomestico[0] = new Lavadora(100, 40);
		arrayElectrodomestico[1] = new Television();
		arrayElectrodomestico[2] = new Lavadora(40, 100, 90);
		arrayElectrodomestico[3] = new Television(60, true);
		arrayElectrodomestico[4] = new Electrodomestico();
		arrayElectrodomestico[5] = new Lavadora();
		arrayElectrodomestico[6] = new Television();
		arrayElectrodomestico[7] = new Lavadora();
		arrayElectrodomestico[8] = new Television();
		arrayElectrodomestico[9] = new Electrodomestico();
		
		
		
		for(int i=0;i<=9;i++){
			if(arrayElectrodomestico[i] instanceof Lavadora)
			{
				totalLavadora+=arrayElectrodomestico[i].precioFinal();
				total+=arrayElectrodomestico[i].precioFinal();
			}else if(arrayElectrodomestico[i] instanceof Television)
			{
				totalTelevision+=arrayElectrodomestico[i].precioFinal();
				total+=arrayElectrodomestico[i].precioFinal();
			}else if(arrayElectrodomestico[i] instanceof Electrodomestico)
			{
				total+=arrayElectrodomestico[i].precioFinal();
			}
			
		}
		
		for(int i=0;i<=9;i++){
			System.out.println(i  + arrayElectrodomestico[i].getClass().getName() + "=" + arrayElectrodomestico[i].precioFinal());
		}
		
		System.out.println("Total de lavadora: " + totalLavadora);
		System.out.println("Total de TV: " + totalTelevision);
		System.out.println("Total total: " + total);
	}
}
