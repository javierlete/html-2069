<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container mt-4 mb-5 pb-5">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<% for(int i = 1; i <= 20; i++) { %>
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/225?<%=i %>" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><a class="text-dark link-underline-light stretched-link" href="restaurante.jsp">IparBurger</a></h5>
					<p class="card-text"><i class="bi bi-star-fill"></i> <strong>3.4</strong> Americana</p>
					<p class="card-text"><i class="bi bi-clock-history"></i> 20 minutos</p>
					<p class="card-text"><i class="bi bi-bicycle"></i> 1,23€</p>
					<p class="card-text"><i class="bi bi-basket"></i> 10€ mínimo</p>
					<p class="card-text"><i class="bi bi-tag"></i> 10% de descuento</p>
				</div>
			</div>
		</div>
		<% } %>
	</div>
</main>

<%@ include file="includes/pie.jsp"%>