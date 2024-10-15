package empresa.clases;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
	// VARIABLES DE INSTANCIA
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSalida;

	// CONSTRUCTORES
	public Registro(String nombre, String apellidos, String dni, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
		setHoraEntrada(horaEntrada);
		setHoraSalida(horaSalida);
	}

	// Constructor por defecto
	public Registro() {

	}

	// GETTER Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("El nombre no puede ser null");
		}

		if (nombre.isBlank()) {
			throw new RuntimeException("El nombre no puede estar vacío");
		}

		this.nombre = nombre.trim();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	// Getter extra hecho a mano en base a un cálculo
	public Duration getDuracion() {
		return Duration.between(horaEntrada, horaSalida);
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Registro [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", horaEntrada="
				+ horaEntrada + ", horaSalida=" + horaSalida + "]";
	}
}
