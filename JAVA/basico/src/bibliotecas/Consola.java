package bibliotecas;

import java.util.Scanner;

public class Consola {
	public static Scanner sc = new Scanner(System.in);
	
	public static void p(String mensaje) {
		System.out.print(mensaje);
	}
	
	public static void pl() {
		System.out.println();
	}
	
	public static void pl(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static String pedirTexto(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine().trim();
	}
	
	public static Integer pedirEntero(String mensaje) {
		Integer resultado = null;
		String texto;
		boolean esNumero = false;
		
		do {
			texto = pedirTexto(mensaje);
			
			try {
				resultado = Integer.parseInt(texto);
				esNumero = true;
			} catch (NumberFormatException e) {
				pl("El formato no es correcto");
			} 
		} while (!esNumero);
		
		return resultado;
	}
}
