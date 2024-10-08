package basico;

import java.time.LocalDate;

public class ConversionLoQueSeaAString {
	public static void main(String[] args) {
		int i = 5;
		
		String s = String.valueOf(i);
		
		System.out.println(s);
		
		LocalDate fecha = LocalDate.now();
		
		String fechaTexto = fecha.toString();
		
		System.out.println(fechaTexto);
	}
}
