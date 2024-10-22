<%@page import="iparchat.modelos.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");

String emisor = (String) session.getAttribute("emisor");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IparChat</title>
</head>
<body>
	<main>
		<a href="#formulario">Abajo</a>
		<section id="chat">
			<%
			for (Mensaje m : mensajes) {
			%>
			<article>
				<h2><%=m.getEmisor()%></h2>
				<p><%=m.getTexto()%></p>
				<p><%=m.getFechaHoraFormateado()%></p>
			</article>
			<%
			}
			%>
		</section>

		<form id="formulario" action="index#formulario" method="post">
			<input name="emisor" value="<%=emisor == null ? "" : emisor%>" placeholder="Pon tu nombre">
			<input name="texto" value="" placeholder="Escribe tu mensaje">
			<button>Enviar</button>
		</form>
	</main>
</body>
</html>