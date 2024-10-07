package basico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Fechas {
	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
		
		System.out.println(hoy);
		
		LocalDate finModulo = LocalDate.of(2024, 10, 31);
		
		System.out.println(finModulo);
		
		System.out.println(finModulo.plusMonths(1));
		
		LocalTime ahora = LocalTime.now();
		
		System.out.println(ahora);
		
		LocalTime salida = LocalTime.of(20, 0);
		
		System.out.println(salida);
		
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ldt);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eeee dd' de 'MMMM' de 'yyyy' a las 'HH:mm");
		
		System.out.println(dtf.format(ldt));
	}
}
