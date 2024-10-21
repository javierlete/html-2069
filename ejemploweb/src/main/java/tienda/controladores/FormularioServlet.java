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
}
