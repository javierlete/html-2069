package basico;

public class ConversionStringAPrimitivo {
	public static void main(String[] args) {
		String enteroTexto = "1234";
		
		int entero = Integer.parseInt(enteroTexto);
		
		System.out.println(entero);
		
		String dobleTexto = "12.34";
		
		double doble = Double.parseDouble(dobleTexto);
		
		System.out.println(doble);
		
		String letraTexto = "  	     no             ";
		
		String letraTextoLimpio = letraTexto.trim();
		
		System.out.println(letraTextoLimpio);
		
		char letra = letraTextoLimpio.charAt(0);
		
		System.out.println(letra);
		
		boolean booleano = letraTextoLimpio.charAt(0) == 's';
		
		System.out.println(booleano);
	}
}
