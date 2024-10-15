package bibliotecas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public static final Scanner sc = new Scanner(System.in);
	
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

	public static LocalDateTime pedirFecha(String mensaje) {
		return pedirFecha(mensaje, FORMATO_FECHA);
	}
	
	public static LocalDateTime pedirFecha(String mensaje, DateTimeFormatter formateador) {
		LocalDateTime resultado = null;
		String texto;
		boolean esFecha = false;
		
		do {
			texto = pedirTexto(mensaje);
			
			try {
				resultado = LocalDateTime.parse(texto, formateador);
				esFecha = true;
			} catch (DateTimeParseException e) {
				pl("El formato no es correcto");
			} 
		} while (!esFecha);
		
		return resultado;
	}
}
