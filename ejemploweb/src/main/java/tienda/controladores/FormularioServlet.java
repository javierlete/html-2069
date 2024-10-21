package tienda.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tienda.modelos.Producto;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		Producto producto = null;

		if (sId != null) {
			Long id = Long.parseLong(sId);

			for (Producto p : Globales.productos) {
				if (p.getId() == id) {
					producto = p;
					break;
				}
			}
		} else {
			producto = new Producto(0L, "", 0.0);
		}

		request.setAttribute("producto", producto);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		
		// 2. Convertir lo que sea necesario
		Long id = Long.parseLong(sId);
		Double precio = Double.parseDouble(sPrecio);
		
		// 3. Empaquetar en modelo
		Producto producto = new Producto(id, nombre, precio);
		
		// 4. Lógica de negocio (hacer con los datos lo que haya que hacer)
		if(id == 0) {
			Globales.productos.add(producto);
		} else {
			for (Producto p : Globales.productos) {
				if (p.getId() == id) {
					Globales.productos.remove(p);
					Globales.productos.add(producto);
					break;
				}
			}
		}
		
		// 5. Preparar información para la nueva vista
		request.setAttribute("productos", Globales.productos);

		// 6. Ir a la nueva vista
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
