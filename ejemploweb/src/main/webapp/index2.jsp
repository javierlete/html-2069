<%@ page import="tienda.modelos.Producto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<Producto> productos = new ArrayList<Producto>();

productos.add(new Producto(1L, "Portátil", 1234.56));
productos.add(new Producto(2L, "Teclado", 34.56));
productos.add(new Producto(3L, "Ratón", 12.56));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tienda</title>
</head>
<body>

	<%
	for (Producto producto : productos) {
	%>
	<article>
		<h2><%=producto.getNombre()%></h2>
		<p><%=producto.getPrecio()%></p>
		<img src="https://picsum.photos/400/300?<%=producto.getId()%>">
	</article>
	<%
	}
	%>
	
</body>
</html>