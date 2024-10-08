package basico;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		int[] caja = new int[5];

		caja[0] = 10;
		caja[1] = 20;
		caja[3] = 40;
		caja[4] = 50;

		System.out.println(caja);
		System.out.println(Arrays.toString(caja));

		for (int dato : caja) {
			System.out.println(dato);
		}

		for (int i = 0; i < caja.length; i++) {
			System.out.println(i + "->" + caja[i]);
		}

//		int i = 0;
//		while(i < caja.length) {
//			System.out.println(i);
//			i++;
//		}
	}
}
