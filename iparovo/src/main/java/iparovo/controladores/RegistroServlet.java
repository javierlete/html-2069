package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.UsuarioDao;
import iparovo.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String rol = "USER";
		
		Usuario usuario = new Usuario(null, nombre, email, password, rol);
		
		UsuarioDao.insertar(usuario);
		
		response.sendRedirect("index");
	}

}
