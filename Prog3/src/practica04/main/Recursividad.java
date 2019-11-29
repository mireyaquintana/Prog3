package practica04.main;

public class Recursividad {
	
	/** Invierte un string letra a letra
	 * @param frase
	 * @return
	 */
	public static String invertirFrase(String frase) {
		if(frase.length() == 1){
			return frase;
		}
		
		String s1 = frase.substring(0, frase.length()/2); // substring coge un string desde(incluido) hasta(excluido)
		String s2 = frase.substring(frase.length()/2, frase.length());
		
		return invertirFrase(s2) + invertirFrase(s1);
		
	}
	
	public static String invertirPalabras(String frase) {
		String[] palabras = frase.split(" ");
		if(palabras.length == 1) {
			return frase;
		} else {
			return invertirPalabras(frase.split(" ",2)[1]) + " " + frase.split(" ",2)[0];
		}
	}
	
	

}
