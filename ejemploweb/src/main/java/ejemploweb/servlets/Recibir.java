package ejemploweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recibir")
public class Recibir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String sVeces = request.getParameter("veces");
		
		int veces = Integer.parseInt(sVeces);
		
		out.println("<ul>");

		for (int i = 1; i <= veces; i++) {
			out.println("<li>" + i + "</li>");
		}

		out.println("</ul>");
	}
}
