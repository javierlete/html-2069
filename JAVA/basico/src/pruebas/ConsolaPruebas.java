package pruebas;

import static bibliotecas.Consola.*;

public class ConsolaPruebas {
	public static void main(String[] args) {
		String nombre = pedirTexto("Dime tu nombre");
		
		pl("Hola " + nombre);
		
		Integer numero = pedirEntero("Dime un número entero");
		
		pl("El número es " + numero);
	}
}
