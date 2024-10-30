<%@page import="iparovo.modelos.Restaurante"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) request.getAttribute("restaurantes");
%>

<main class="container mt-4 mb-5 pb-5">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<%
		for (Restaurante r: restaurantes) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/225?<%=r.getId()%>"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">
						<a class="text-dark link-underline-light stretched-link"
							href="restaurante.jsp"><%=r.getNombre() %></a>
					</h5>
					<p class="card-text">
						<i class="bi bi-star-fill"></i> <strong><%=r.getEstrellas() %></strong> <%=r.getTipo() %>
					</p>
					<p class="card-text">
						<i class="bi bi-clock-history"></i> <%=r.getMinutosEntrega() %> minutos
					</p>
					<p class="card-text">
						<i class="bi bi-bicycle"></i> <%=r.getPrecioEntrega() %> €
					</p>
					<p class="card-text">
						<i class="bi bi-basket"></i> <%=r.getPrecioMinimo() %> € mínimo
					</p>
					<p class="card-text">
						<i class="bi bi-tag"></i> <%=r.getDescuento()%>% de descuento
					</p>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
</main>

<%@ include file="includes/pie.jsp"%>