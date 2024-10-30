package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.RestauranteDao;
import iparovo.modelos.Cesta;
import iparovo.modelos.Linea;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cesta")
public class CestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		String sIdRestaurante = request.getParameter("idrestaurante");
		String sIdPlato = request.getParameter("idplato");

		Cesta cesta = (Cesta) sesion.getAttribute("cesta");

		if (cesta == null) {
			Long idRestaurante = Long.parseLong(sIdRestaurante);
			cesta = new Cesta(null, RestauranteDao.obtenerPorId(idRestaurante));
			sesion.setAttribute("cesta", cesta);
		}

		Long idPlato = Long.parseLong(sIdPlato);
		
		cesta.getLineas().add(new Linea(null, RestauranteDao.obtenerPlatoPorId(idPlato), 1));

		request.getRequestDispatcher("cesta.jsp").forward(request, response);
	}
}
