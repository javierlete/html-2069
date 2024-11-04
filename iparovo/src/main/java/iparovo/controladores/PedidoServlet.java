package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.RestauranteDao;
import iparovo.modelos.Cesta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pedido")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cesta cesta = (Cesta) request.getSession().getAttribute("cesta");
		
		RestauranteDao.insertarPedido(cesta);
		
		request.getRequestDispatcher("pedido.jsp").forward(request, response);
	}
}
