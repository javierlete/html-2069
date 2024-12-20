<%@page import="iparovo.modelos.Plato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iparovo.modelos.Restaurante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
Restaurante restaurante = (Restaurante) request.getAttribute("restaurante");

@SuppressWarnings("unchecked")
ArrayList<Plato> platos = (ArrayList<Plato>) request.getAttribute("platos");
%>

<main class="container mt-4 mb-5 pb-5">
	<div class="card h-100">
		<img src="https://picsum.photos/400/225" class="card-img-top"
			alt="...">
		<div class="card-body">
			<h5 class="card-title">
				<%=restaurante.getNombre() %>
			</h5>
			<p class="card-text">
				<i class="bi bi-star-fill"></i> <strong><%=restaurante.getEstrellas() %></strong> <%=restaurante.getTipo() %> <i
					class="bi bi-clock-history"></i> <%=restaurante.getMinutosEntrega() %> minutos <i
					class="bi bi-bicycle"></i> <%=restaurante.getPrecioEntrega() %>€ <i class="bi bi-basket"></i> <%=restaurante.getPrecioMinimo() %> €
				mínimo <i class="bi bi-tag"></i> <%=restaurante.getDescuento()%>% de descuento
			</p>
		</div>
	</div>


	<div
		class="mt-4 row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5 g-4">
		<%
		for (Plato p: platos) {
		%>
		<div class="col">
			<div class="card mb-3" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="https://picsum.photos/300/400?<%=p.getId() %>" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><a class="stretched-link text-dark link-underline-light" href="cesta?idrestaurante=<%=restaurante.getId()%>&idplato=<%=p.getId()%>"><%=p.getNombre() %></a></h5>
							<p class="card-text"><%=String.format("%.2f", p.getPrecio()) %>€</p>
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