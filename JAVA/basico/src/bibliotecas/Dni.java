package bibliotecas;

public class Dni {
	public static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static boolean esValidoDni(String dni) {
		if(!dni.matches("^\\d{8}[A-Z]$")) {
			return false;
		}
		
		String sNumero = dni.substring(0, 8);
		
		int numero = Integer.parseInt(sNumero);
		char letra = dni.charAt(8);
		
		return letra == LETRAS_DNI.charAt(numero % 23);
	}
}
