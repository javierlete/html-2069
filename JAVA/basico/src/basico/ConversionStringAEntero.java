package basico;

import java.util.Scanner;

public class ConversionStringAEntero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean esUnNumero = false;
		
		do {
			System.out.print("Dime un número: ");
			String textoNumero = sc.nextLine();
			
			int numero;
			
			try {
				numero = Integer.parseInt(textoNumero);
				System.out.println("El resultado de " + numero + " x 2 = " + numero * 2);
				esUnNumero = true;
			} catch (NumberFormatException e) {
				System.out.println("La próxima vez mejor un número");
			} 
		} while (!esUnNumero);
		
		sc.close();
	}

}