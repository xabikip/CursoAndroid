package Password;

import javax.swing.JOptionPane;

public class PasswordMain {
	
	public static void main (String args[]){
		
		int tama�oArray = Integer.parseInt(JOptionPane.showInputDialog("introduce tama�o del array"));
		Password arrayPass[] = new Password[tama�oArray];
		int longitudPass = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longtud del passwrd"));
		boolean esFuerte[] = new boolean [tama�oArray];
		
		for(int i=0; i<tama�oArray; i++){
			arrayPass[i] = new Password(longitudPass);
			esFuerte[i] = arrayPass[i].esFuerte();
			System.out.println(arrayPass[i].getContrase�a() + " : " + esFuerte[i]);
		}
		
		
	}

}
