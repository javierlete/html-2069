package basico;

import java.util.Arrays;

public class ArrayBidimensional {
	public static void main(String[] args) {
		char[][] tablero = new char[8][8];
		
		for(int fila = 0; fila < tablero.length; fila++) {
			Arrays.fill(tablero[fila], '.');
		}
		
		tablero[0][0] = 'T';
		tablero[0][1] = 'C';
		tablero[7][7] = 't';
		
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int columna = 0; columna < tablero[fila].length; columna++) {
				System.out.print(tablero[fila][columna] + " ");
			}
			
			System.out.println();
		}
	}
}
