package basico;

import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double numeroConDecimales = Math.random() * 100.0 + 1.0;
		int numeroAdivinar = (int) numeroConDecimales;

//		System.out.println(numeroConDecimales);
//		System.out.println(numeroAdivinar);

		boolean seguir = true;
		
		while (seguir) {
			System.out.println("Dime un número:");

			int numero = sc.nextInt();

			if (numero == numeroAdivinar) {
				System.out.println("Felicidades. Has acertado");
				System.out.println("Eres un hacha");
				
				seguir = false;
			} else if (numeroAdivinar > numero) {
				System.out.println("ES MAYOR");
			} else {
				System.out.println("es menor");
			}
		}
		
		sc.close();
	}
}
