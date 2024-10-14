package pruebas;

import java.time.LocalDateTime;
import java.util.ArrayList;

import empresa.clases.Registro;

public class RegistroPruebas {
	public static void main(String[] args) {
		Registro javier = new Registro();
		
		javier.setNombre("        Javier ");
		javier.setApellidos("Lete");
		javier.setDni("12345678Z");
		javier.setHoraEntrada(LocalDateTime.of(2024, 10, 14, 8, 0));
		javier.setHoraSalida(LocalDateTime.of(2024, 10, 14, 13, 45));
		
		System.out.println(javier.getNombre());
		System.out.println(javier.getHoraEntrada());

		System.out.println(javier.getDuracion());
		
		Registro pepe = new Registro("Pepe", "Pérez", "87654321A", null, null);
		
		System.out.println(pepe);
		
		ArrayList<Registro> registros = new ArrayList<Registro>();
		
		registros.add(javier);
		registros.add(pepe);
		
		for(Registro r: registros) {
			System.out.println(r);
		}
	}
}
