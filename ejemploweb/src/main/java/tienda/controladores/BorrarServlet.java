package tienda.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tienda.accesodatos.ProductosAccesoDatos;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");

		// 2. Convertir lo que sea necesario
		Long id = Long.parseLong(sId);

		// 3. Empaquetar en modelo
		// NO HACE FALTA

		// 4. Lógica de negocio (hacer con los datos lo que haya que hacer)
		ProductosAccesoDatos.borrarProducto(id);
		
		// 5. Preparar información para la nueva vista
		request.setAttribute("productos", ProductosAccesoDatos.listadoProductos());

		// 6. Ir a la nueva vista
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
