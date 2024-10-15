package empresa;

import static bibliotecas.Consola.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import empresa.clases.Registro;

public class AplicacionRegistro {
	private static final int SALIR = 0;

	private static final ArrayList<Registro> registros = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while(opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("MENU");
		pl("====");
		pl();
		pl("1. Listado");
		pl("2. Añadir");
		pl();
		pl("0. SALIR");
	}

	private static int pedirOpcion() {
		return pedirEntero("Dime la opción que quieres");
	}

	private static void procesarOpcion(int opcion) {
		pl("-------------------------------------------");
		pl();
		pl("PROCESAR OPCION " + opcion);
		
		switch(opcion) {
		case 1: listado(); break;
		case 2: anyadir(); break;
		case 0: pl("Gracias por usar esta aplicación"); break;
		default: pl("NO CONOZCO ESA OPCIÓN");
		}
		
		pl();
		pl("-------------------------------------------");
	}

	private static void listado() {
		pl("LISTADO");
		
		for(Registro r: registros) {
			System.out.println(r);
		}
	}

	private static void anyadir() {
		pl("AÑADIR");
		
		// TODO verificar si el nombre es válido
		String nombre = pedirTexto("Nombre");
		String apellidos = pedirTexto("Apellidos");
		// TODO verificar el DNI si es válido
		String dni = pedirTexto("DNI");
		
		LocalDateTime horaEntrada;
		LocalDateTime horaSalida;
		
		do {
			horaEntrada = pedirFecha("Hora entrada");
			horaSalida = pedirFecha("Hora salida");
			
			if (horaEntrada.isAfter(horaSalida)) {
				pl("La hora de entrada no puede ser posterior a la hora de salida");
			} 
		} while (horaEntrada.isAfter(horaSalida));
		
		registros.add(new Registro(nombre, apellidos, dni, horaEntrada, horaSalida));
	}
	
	// TODO modificar
	// TODO borrar
}
