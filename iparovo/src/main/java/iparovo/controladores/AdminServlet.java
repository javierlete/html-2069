package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		request.setAttribute("pedidos", AdminDao.getPedidos());
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
