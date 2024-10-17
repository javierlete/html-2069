<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container mt-4 mb-5 pb-5">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<%
		for (Producto producto : productos) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?<%=producto.getId()%>" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title"><%=producto.getNombre()%></h5>
				</div>
				<div class="card-footer text-end">
					<small class="text-body-secondary fw-bold"><%=producto.getPrecio()%></small>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
</main>

<%@ include file="includes/pie.jsp"%>