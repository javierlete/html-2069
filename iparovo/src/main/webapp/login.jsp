<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
String errores = (String) request.getAttribute("errores");
%>

<%
if (errores != null) {
%>
<div class="alert alert-danger alert-dismissible fade show"
	role="alert">
	<%=errores%>
	<button type="button" class="btn-close" data-bs-dismiss="alert"
		aria-label="Close"></button>
</div>
<%
}
%>

<main class="container mt-4 mb-5 pb-5">
	<form action="login" method="post">
		<div class="row mb-3">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="email">
			</div>
		</div>
		<div class="row mb-3">
			<label for="password" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Inicio sesión</button>
		<a class="btn btn-secondary" href="registro">Registro usuario nuevo</a>
	</form>
</main>

<%@ include file="includes/pie.jsp"%>