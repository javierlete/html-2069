package tienda.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tienda.accesodatos.ProductosAccesoDatos;
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

			producto = ProductosAccesoDatos.buscarProducto(id);
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
		if (nombre.isBlank() || precio < 0.0) {
			if (nombre.isBlank()) {
				request.setAttribute("errorNombre", "El nombre debe tener contenido");
			}

			if (precio < 0.0) {
				request.setAttribute("errorPrecio", "El precio debe ser positivo");
			}

			request.setAttribute("producto", producto);
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			return;
		}

		if (id == 0) {
			ProductosAccesoDatos.agregarProducto(producto);
		} else {
			ProductosAccesoDatos.modificarProducto(producto);
		}

		// 5. Preparar información para la nueva vista
		request.setAttribute("productos", ProductosAccesoDatos.listadoProductos());

		// 6. Ir a la nueva vista
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
