/**
 * Un paquete es una agrupación de varias clases bajo un mismo nombre
 */
package basico;

import java.util.Scanner;

/**
 * Clase: La unidad con la que trabajamos en Java
 */
public class HolaMundo {
	/**
	 * Método main es el que se ejecuta al arrancar un programa Java
	 * @param args
	 */
	public static void main(String[] args) { // Creado con main y CTRL+ESPACIO
		/*
		 * Este es un programa de ejemplo para ver cómo se escribe
		 * algo por consola
		 */
		System.out.println("Hola a todos"); // Creado con syso y CTRL+ESPACIO
		
		float d1, d2, suma;
		
		d1 = 0.1f;
		d2 = 0.2f;
		
		suma = d1 + d2;
		
		System.out.println(suma);
		
		d1 = 100.0f;
		d2 = 3.0f;
		
		System.out.println(d1 / d2);
		
		String nombre;
		
		nombre = "Javier";
		
		System.out.println("Hola " + nombre);

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime tu nombre:");
		
		nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		sc.close();
	}
}
