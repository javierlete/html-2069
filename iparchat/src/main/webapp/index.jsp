<%@page import="iparchat.modelos.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IparChat</title>
</head>
<body>
	<main>
		<section id="chat">
			<%
			for (Mensaje m : mensajes) {
			%>
			<article>
				<h2><%=m.getEmisor() %></h2>
				<p><%=m.getMensaje() %></p>
				<p><%=m.getFechaHoraFormateado() %></p>
			</article>
			<%
			}
			%>
		</section>

		<form>
			<input name="emisor" value="Juan" placeholder="Pon tu nombre">
			<input name="mensaje" value="" placeholder="Escribe tu mensaje">
			<button>Enviar</button>
		</form>
	</main>
</body>
</html>