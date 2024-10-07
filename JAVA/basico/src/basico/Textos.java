package basico;

public class Textos {
	public static void main(String[] args) {
		String nombre = "Javier Lete";
		
		System.out.println(nombre);
		System.out.println("Longitud: " + nombre.length());
		System.out.println(nombre.toLowerCase());
		System.out.println(nombre.toUpperCase());
		System.out.println("¿Es \"Javier Lete\"? " + nombre.equals("Javier Lete"));
		System.out.println(nombre.substring(7, 11));
		System.out.println(nombre.indexOf("Lete"));
	}
}
