<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container mt-4 mb-5 pb-5">
	<div class="card h-100">
		<img src="https://picsum.photos/400/225" class="card-img-top"
			alt="...">
		<div class="card-body">
			<h5 class="card-title">
				<a class="text-dark link-underline-light stretched-link"
					href="restaurante.jsp">IparBurger</a>
			</h5>
			<p class="card-text">
				<i class="bi bi-star-fill"></i> <strong>3.4</strong> Americana <i
					class="bi bi-clock-history"></i> 20 minutos <i
					class="bi bi-bicycle"></i> 1,23€ <i class="bi bi-basket"></i> 10€
				mínimo <i class="bi bi-tag"></i> 10% de descuento
			</p>
		</div>
	</div>


	<div
		class="mt-4 row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5 g-4">
		<%
		for (int i = 1; i <= 20; i++) {
		%>
		<div class="col">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="https://picsum.photos/300/400?<%=i %>" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><a class="stretched-link text-dark link-underline-light" href="cesta.jsp">IparBurger gigante</a></h5>
							<p class="card-text">19,99€</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>

</main>

<%@ include file="includes/pie.jsp"%>