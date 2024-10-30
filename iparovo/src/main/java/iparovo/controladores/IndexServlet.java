package iparovo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import iparovo.modelos.Restaurante;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var restaurantes = new ArrayList<Restaurante>();
		
		restaurantes.add(new Restaurante(1L, "IparBurger", "Americana", 4.0, 20, 1.23, 10.0, 5));
		restaurantes.add(new Restaurante(2L, "IparPizza", "Italiana", 3.3, 25, 1.24, 6.0, 0));
		restaurantes.add(new Restaurante(3L, "McIpartek", "Americana", 3.2, 30, 1.23, 10.0, 5));
		
		request.setAttribute("restaurantes", restaurantes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
