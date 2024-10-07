package basico;

import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String respuesta = "s";

		while (respuesta.equals("s")) {
			double numeroConDecimales = Math.random() * 100.0 + 1.0;
			int numeroAdivinar = (int) numeroConDecimales;

			int intentos = 0;

			boolean seguir = true;

			while (seguir) {
				System.out.println("Dime un número:");

				int numero = sc.nextInt();

				intentos++; // intentos += 1; intentos = intentos + 1;

				System.out.println("Llevas " + intentos + " intentos");

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

			System.out.println("¿Quieres jugar otra partida? (s/N)");

			sc.nextLine();
			respuesta = sc.nextLine();
		}

		System.out.println("¡Gracias por jugar!");
		
		sc.close();
	}
}
