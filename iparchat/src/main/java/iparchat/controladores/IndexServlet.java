package iparchat.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import iparchat.accesodatos.MensajesAccesoDatos;
import iparchat.modelos.Mensaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("mensajes", MensajesAccesoDatos.getMensajes());

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emisor = request.getParameter("emisor");
		String texto = request.getParameter("texto");

		Mensaje mensaje = new Mensaje(null, emisor, texto, LocalDateTime.now());

		MensajesAccesoDatos.mandarMensaje(mensaje);

		HttpSession session = request.getSession();

		session.setAttribute("emisor", emisor);

		response.sendRedirect("index#formulario");
	}

}
