package basico;

public class Funciones {
	public static void main(String[] args) {
		int x = 1, y = 2, z = 3;
		
		int resultado = sumar(x, y, z);
		
		System.out.println(resultado);
	}
	
	public static int sumar(int a, int b) {
		return a + b;
	}
	
	public static int sumar(int a, int b, int c) {
		return a + b + c;
	}
	
	public static double sumar(double a, double b) {
		return a + b;
	}
}
