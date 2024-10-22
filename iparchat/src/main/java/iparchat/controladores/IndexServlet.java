package iparchat.controladores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	private static final ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	static {
		mensajes.add(new Mensaje(1L, "Pepe", "Ola ke ase", LocalDateTime.now().minusDays(1)));
		mensajes.add(new Mensaje(2L, "Javier", "Pues nada, aquí dando clase", LocalDateTime.now()));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mensajes", mensajes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emisor = request.getParameter("emisor");
		String texto = request.getParameter("texto");
		
		Mensaje mensaje = new Mensaje(null, emisor, texto, LocalDateTime.now());
		
		mensajes.add(mensaje);
		
		HttpSession session  = request.getSession();
		
		session.setAttribute("emisor", emisor);
		
		response.sendRedirect("index#formulario");
	}

}
