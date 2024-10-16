<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
String sId = request.getParameter("id");
Long id = Long.parseLong(sId);

Producto producto = null;

for(Producto p: productos) {
	if(p.getId() == id) {
		producto = p;
		break;
	}
}
%>

<main class="container mt-4 mb-5 pb-5">
	<form action="admin.html" class="needs-validation" novalidate>
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm">
				<input readonly class="form-control" id="id" value="<%=producto.getId()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text" required minlength="3" class="form-control"
					id="nombre" value="<%=producto.getNombre()%>">
				<div class="invalid-feedback">El nombre es obligatorio y debe
					tener al menos 3 letras</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input type="number" step=".01" required min="0"
					class="form-control" id="precio" value="<%=producto.getPrecio()%>">
				<div class="invalid-feedback">El precio es obligatorio y debe
					ser positivo</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="offset-sm-2 col-sm">
				<button type="submit" class="btn btn-primary">
					<i class="bi bi-floppy2-fill"></i>
				</button>
			</div>
		</div>
	</form>
</main>

<%@ include file="includes/pie.jsp"%>