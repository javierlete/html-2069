package empresa;

import static bibliotecas.Consola.*;

import java.util.ArrayList;

public class Aplicacion {
	private static final int SALIR = 0;

	private static final ArrayList<String> nombres = new ArrayList<String>();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl();
		pl("MENU");
		pl("----");
		pl();
		pl("1. Listado");
		pl("2. Añadir");
		pl("3. Modificar");
		pl("4. Borrar");
		pl();
		pl("0. Salir");
		pl();
	}

	private static int pedirOpcion() {
		return pedirEntero("Selecciona una opción");
	}

	private static void procesarOpcion(int opcion) {
		pl();
		pl("----------------------------------");

		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			anyadir();
			break;
		case 3:
			modificar();
			break;
		case 4:
			borrar();
			break;
		case 0:
			pl("Gracias por usar nuestra aplicación");
			break;
		default:
			pl("No conozco la opción " + opcion);
		}

		pl("----------------------------------");
		pl();
	}

	private static void listado() {
		pl();
		pl("LISTADO");
		pl("-------");
		pl();

		if (nombres.size() == 0) {
			pl("NO HAY NOMBRES");
		}

		for (String nombre : nombres) {
			pl(nombre);
		}

		pl();
	}

	private static void anyadir() {
		String nombre = pedirNombre("Dime el nombre");

		nombres.add(nombre);
	}

	private static void modificar() {
		String nombre = pedirNombre("Dime el nombre original");

		nombres.remove(nombre);

		String nuevo = pedirNombre("Dime el nombre nuevo");

		nombres.add(nuevo);
	}

	private static void borrar() {
		String nombre = pedirNombre("Dime el nombre");

		nombres.remove(nombre);
	}

	private static String pedirNombre(String mensaje) {
		String texto;

		do {
			texto = pedirTexto(mensaje);

			if (texto.isEmpty()) {
				pl("Debes introducir un texto");
			}
		} while (texto.isEmpty());

		String nombre = formateado(texto);

		return nombre;
	}

	private static String formateado(String texto) {
		char inicial = Character.toUpperCase(texto.charAt(0));
		String resto = texto.substring(1).toLowerCase();

		return inicial + resto;
	}
}
