package tienda.controladores;

import java.util.ArrayList;

import tienda.modelos.Producto;

public class Globales {
	public static final ArrayList<Producto> productos = new ArrayList<Producto>();

	static {
		productos.add(new Producto(1L, "Portátil", 1234.56));
		productos.add(new Producto(2L, "Teclado", 34.56));
		productos.add(new Producto(3L, "Ratón", 12.56));
	}
}
