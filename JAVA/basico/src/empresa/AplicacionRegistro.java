package empresa;

import static bibliotecas.Consola.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import empresa.clases.Registro;

public class AplicacionRegistro {
	private static final int SALIR = 0;

	private static final ArrayList<Registro> registros = new ArrayList<>();

	private static final DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
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
		pl("3. Modificar");
		pl("4. Borrar");
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
		case 3: modificar(); break;
		case 4: borrar(); break;
		case 0: pl("Gracias por usar esta aplicación"); break;
		default: pl("NO CONOZCO ESA OPCIÓN");
		}
		
		pl();
		pl("-------------------------------------------");
	}

	private static void listado() {
		for(Registro r: registros) {
			System.out.println(r);
		}
	}

	private static void anyadir() {
		Registro registro = new Registro();
		
		do {
			try {
				String nombre = pedirTexto("Nombre");

				registro.setNombre(nombre);
			} catch (Exception e) {
				pl("Error en el nombre");
			} 
		} while (registro.getNombre() == null);
		
		String apellidos = pedirTexto("Apellidos");
		
		registro.setApellidos(apellidos);
		
		// TODO verificar el DNI si es válido
		String dni = pedirTexto("DNI");
		
		registro.setDni(dni);
		
		LocalDateTime horaEntrada;
		LocalDateTime horaSalida;
		
		do {
			horaEntrada = pedirFecha("Hora entrada", formateador);
			horaSalida = pedirFecha("Hora salida", formateador);
			
			if (horaEntrada.isAfter(horaSalida)) {
				pl("La hora de entrada no puede ser posterior a la hora de salida");
			} 
		} while (horaEntrada.isAfter(horaSalida));
		
		registro.setHoraEntrada(horaEntrada);
		registro.setHoraSalida(horaSalida);
		
		registros.add(registro);
	}

	private static void modificar() {
		borrar();
		anyadir();
	}
	
	private static void borrar() {
		String dni = pedirTexto("Dime el DNI a borrar");

		for(int i = 0; i < registros.size(); i++) {
			Registro registro = registros.get(i);
			
			if(registro.getDni().equals(dni)) {
				registros.remove(i);
				break;
			}
		}
	}

}
