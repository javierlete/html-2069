package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.RestauranteDao;
import iparovo.modelos.Cesta;
import iparovo.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cesta cesta = (Cesta) session.getAttribute("cesta");

		if(cesta == null) {
			response.sendRedirect("index");
			return;
		}
		
		if(cesta.getUsuario() == null) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if(usuario == null) {
				response.sendRedirect("login");
				return;
			}
			
			cesta.setUsuario(usuario);
		}
		
		RestauranteDao.insertarPedido(cesta);
		
		request.setAttribute("cesta", cesta);
		
		session.removeAttribute("cesta");
		
		request.getRequestDispatcher("pedido.jsp").forward(request, response);
	}
}
