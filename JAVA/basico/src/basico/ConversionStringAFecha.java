package basico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversionStringAFecha {
	public static void main(String[] args) {
		String fechaTexto = "2000-01-02";
		
		LocalDate fecha = LocalDate.parse(fechaTexto);
		
		System.out.println(fecha);
		
		
		
		DateTimeFormatter formatoFechaEspanyol = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		String fechaEspanyaTexto = "01/02/2003";
		
		LocalDate fechaEspanya = LocalDate.parse(fechaEspanyaTexto, formatoFechaEspanyol);
		
		System.out.println(fechaEspanya.format(formatoFechaEspanyol));
	}
}
