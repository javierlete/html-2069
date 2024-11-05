package iparovo.controladores;

import java.io.IOException;

import iparovo.accesodatos.UsuarioDao;
import iparovo.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = UsuarioDao.buscarPorEmail(email);
		
		if(usuario != null && password.equals(usuario.getPassword())) {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect("index");
		} else {
			request.setAttribute("errores", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
