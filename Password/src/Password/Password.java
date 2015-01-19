package Password;

public class Password {
	
	private int longitud = 8;
	private String contraseña;
	
	public Password(){
		
	}
	
	public Password(int longitud){
		
		generarPassword(longitud);
	}
	
	public int getLongitud() {
		return longitud;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void generarPassword(int longitud){
		
		String alphaNumerics = "abcdefghijklmnñopqrstuvwyxzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890";
		
		for (int i = 0; i < longitud; i++) {
			this.contraseña += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
		}
	}
	
	public boolean esFuerte(){
		
		int mayus = 0, minus = 0, num = 0;
		for(int i=0; i<this.contraseña.length();i++){
			
			if(Character.isUpperCase(this.contraseña.charAt(i)))
				mayus ++;
			else if (Character.isLowerCase(this.contraseña.charAt(i)))
				minus ++;
			else if (Character.isDigit(this.contraseña.charAt(i)))
				num ++;		
		}	
		return (mayus>2 && minus>1 && num>5);
	}

}
