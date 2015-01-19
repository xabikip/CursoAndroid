package Password;

import javax.swing.JOptionPane;

public class PasswordMain {
	
	public static void main (String args[]){
		
		int tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("introduce tamaño del array"));
		Password arrayPass[] = new Password[tamañoArray];
		int longitudPass = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longtud del passwrd"));
		boolean esFuerte[] = new boolean [tamañoArray];
		
		for(int i=0; i<tamañoArray; i++){
			arrayPass[i] = new Password(longitudPass);
			esFuerte[i] = arrayPass[i].esFuerte();
			System.out.println(arrayPass[i].getContraseña() + " : " + esFuerte[i]);
		}
		
		
	}

}
