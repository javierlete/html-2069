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

		Long idRestaurante = sIdRestaurante == null ? null : Long.parseLong(sIdRestaurante);
		Long idPlato = sIdPlato == null ? null : Long.parseLong(sIdPlato);
		
		Cesta cesta = (Cesta) sesion.getAttribute("cesta");

		if (cesta == null) {
			if (idRestaurante != null) {
				cesta = new Cesta(null, RestauranteDao.obtenerPorId(idRestaurante));
				sesion.setAttribute("cesta", cesta);
			} else {
				request.getRequestDispatcher("nohaycesta.jsp").forward(request, response);
				return;
			}
		}
		
		if(idRestaurante != null && idPlato != null) {
			if (idRestaurante == cesta.getRestaurante().getId()) {
				cesta.getLineas().add(new Linea(null, RestauranteDao.obtenerPlatoPorId(idPlato), 1));
			} else {
				request.getRequestDispatcher("noeselmismorestaurante.jsp").forward(request, response);
				return;
			}
		}
		
		request.getRequestDispatcher("cesta.jsp").forward(request, response);
	}
}
