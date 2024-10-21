package tienda.accesodatos;

import java.util.ArrayList;

import tienda.modelos.Producto;

public class ProductosAccesoDatos {
	private static final ArrayList<Producto> productos = new ArrayList<Producto>();

	static {
		productos.add(new Producto(1L, "Portátil", 1234.56));
		productos.add(new Producto(2L, "Teclado", 34.56));
		productos.add(new Producto(3L, "Ratón", 12.56));
	}
	
	public static ArrayList<Producto> listadoProductos() {
		return productos;
	}
	
	public static Producto buscarProducto(Long id) {
		for (Producto p : productos) {
			if (p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}

	public static void agregarProducto(Producto producto) {
		Long idUltimo = 0L;
		
		for(Producto p: productos) {
			if(idUltimo < p.getId()) {
				idUltimo = p.getId();
			}
		}
		
		producto.setId(idUltimo + 1L);
		
		productos.add(producto);
	}

	public static void modificarProducto(Producto producto) {
		for (Producto p : productos) {
			if (p.getId() == producto.getId()) {
				productos.remove(p);
				productos.add(producto);
				break;
			}
		}
	}

	public static void borrarProducto(Long id) {
		for (Producto p : productos) {
			if (p.getId() == id) {
				productos.remove(p);
				break;
			}
		}

	}
}
