<%@page import="tienda.modelos.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
Producto producto = (Producto) request.getAttribute("producto");

String errorNombre = (String) request.getAttribute("errorNombre");
String errorPrecio = (String) request.getAttribute("errorPrecio");
%>

<main class="container mt-4 mb-5 pb-5">
	<form action="formulario" method="post" class="needs-validation"
		novalidate>
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm">
				<input readonly class="form-control" id="id" name="id"
					value="<%=producto.getId()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text" class="form-control <%= errorNombre == null ? "" : "is-invalid" %>"
					id="nombre" name="nombre" value="<%=producto.getNombre()%>">
				<div class="invalid-feedback"><%=errorNombre %></div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input type="number" step=".01"
					class="form-control <%= errorPrecio == null ? "" : "is-invalid" %>" id="precio" name="precio"
					value="<%=producto.getPrecio()%>">
				<div class="invalid-feedback"><%= errorPrecio %></div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="offset-sm-2 col-sm">
				<button type="submit" class="btn btn-primary">
					<i class="bi bi-floppy2-fill"></i>
				</button>
				
				<div class="text-danger">
					<p><%=errorNombre == null ? "" : errorNombre %></p>					
					<p><%=errorPrecio == null ? "" : errorPrecio %></p>					
				</div>
			</div>
		</div>
	</form>
</main>

<%@ include file="includes/pie.jsp"%>