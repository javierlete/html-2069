package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.RestauranteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurante")
public class RestauranteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		Long id = Long.parseLong(sId);
		
		request.setAttribute("restaurante", RestauranteDao.obtenerPorId(id));
		request.setAttribute("platos", RestauranteDao.obtenerPlatosPorIdRestaurante(id));
		
		request.getRequestDispatcher("restaurante.jsp").forward(request, response);
	}
}
