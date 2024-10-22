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

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		
		mensajes.add(new Mensaje(1L, "Pepe", "Ola ke ase", LocalDateTime.now().minusDays(1)));
		mensajes.add(new Mensaje(2L, "Javier", "Pues nada, aquí dando clase", LocalDateTime.now()));
		
		request.setAttribute("mensajes", mensajes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
