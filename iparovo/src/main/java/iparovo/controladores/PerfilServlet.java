package iparovo.controladores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import iparovo.modelos.Cesta;
import iparovo.modelos.Restaurante;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var pedidos = new ArrayList<Cesta>();
		
		pedidos.add(new Cesta(null, null, new Restaurante(null, "Restaurante 1", null, null, null, null, null, null), LocalDateTime.now()));
		pedidos.add(new Cesta(null, null, new Restaurante(null, "Restaurante 2", null, null, null, null, null, null), LocalDateTime.now()));
		
		request.setAttribute("pedidos", pedidos);
		
		request.getRequestDispatcher("perfil.jsp").forward(request, response);
	}
}
