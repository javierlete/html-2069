package basico;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList<String> textos = new ArrayList<String>();
		
		textos.add("Cero");
		textos.add("Uno");
		textos.add("Dos y medio");
		textos.add("Tres");
		
		System.out.println(textos);
		System.out.println(textos.size());
		
		textos.remove(0);
		textos.set(1, "Dos");
		
		for(String texto: textos) {
			System.out.println(texto.toUpperCase());
		}
		
		System.out.println(textos.size());
	}
}
