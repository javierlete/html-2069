<%@page import="iparovo.modelos.Usuario"%>
<%@page import="iparovo.accesodatos.RestauranteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">Iparovo <i
				class="bi bi-basket2"></i></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
				</ul>
				<form class="me-auto mb-2 mb-sm-0 col">
					<input name="busqueda" class="form-control text-bg-light"
						type="search">
				</form>
				<ul class="navbar-nav mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="cesta">Cesta
							<i class="bi bi-basket"></i>
					</a></li>
					<% if(usuario != null && usuario.isAdmin())  { %>
					<li class="nav-item"><a class="nav-link" href="admin">Administración</a></li>
					<% } %>
					<%
					if (usuario != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="perfil"><%=usuario.getNombre()%></a></li>
					<li class="nav-item"><a class="nav-link" href="logout"><i class="bi bi-box-arrow-right"></i></a></li>
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login"><i class="bi bi-box-arrow-in-right"></i></a></li>
					<%} %>					
				</ul>
			</div>
		</div>
	</nav>

	<ul class="nav d-flex justify-content-around text-bg-dark">
		<%
		for (String tipo : RestauranteDao.obtenerTipos()) {
		%>
		<li class="nav-item"><a class="text-light nav-link"
			href="index?tipo=<%=tipo%>"><%=tipo%></a></li>
		<%
		}
		%>
	</ul>