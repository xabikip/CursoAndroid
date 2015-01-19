package Password;

public class Password {
	
	private int longitud = 8;
	private String contrase�a;
	
	public Password(){
		
	}
	
	public Password(int longitud){
		
		generarPassword(longitud);
	}
	
	public int getLongitud() {
		return longitud;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void generarPassword(int longitud){
		
		String alphaNumerics = "abcdefghijklmn�opqrstuvwyxzABCDEFGHIJKLMN�OPQRSTUVWXYZ1234567890";
		
		for (int i = 0; i < longitud; i++) {
			this.contrase�a += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
		}
	}
	
	public boolean esFuerte(){
		
		int mayus = 0, minus = 0, num = 0;
		for(int i=0; i<this.contrase�a.length();i++){
			
			if(Character.isUpperCase(this.contrase�a.charAt(i)))
				mayus ++;
			else if (Character.isLowerCase(this.contrase�a.charAt(i)))
				minus ++;
			else if (Character.isDigit(this.contrase�a.charAt(i)))
				num ++;		
		}	
		return (mayus>2 && minus>1 && num>5);
	}

}
