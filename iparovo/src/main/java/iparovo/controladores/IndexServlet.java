package iparovo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import iparovo.accesodatos.RestauranteDao;
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
		String tipo = request.getParameter("tipo");
		
		ArrayList<Restaurante> restaurantes;
		
		if(tipo == null) {
			restaurantes = RestauranteDao.obtenerTodos();
		} else {
			restaurantes = RestauranteDao.obtenerPorTipo(tipo);
		}
		
		request.setAttribute("restaurantes", restaurantes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
