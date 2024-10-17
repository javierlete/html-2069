<%@ page import="tienda.clases.Producto"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tienda</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="container">

	<div class="row row-cols-1 row-cols-md-3 g-4">
		<%
		for (Producto producto : productos) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?<%=producto.getId()%>"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><%=producto.getNombre()%></h5>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"><%=producto.getPrecio()%></small>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>