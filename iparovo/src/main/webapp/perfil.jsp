<%@page import="iparovo.modelos.Cesta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Cesta> pedidos = (ArrayList<Cesta>) request.getAttribute("pedidos");
%>

<main class="container mt-4 mb-5 pb-5">

	<h2>
		Perfil de
		<%=usuario.getNombre()%></h2>

	<dl>
		<dt>Email</dt>
		<dd><%=usuario.getEmail()%></dd>
		<dt>Rol</dt>
		<dd><%=usuario.getRol()%></dd>
	</dl>

	<h3>Pedidos</h3>

	<table class="table">
		<thead>
			<tr>
				<th>Restaurante</th>
				<th>Fecha</th>
				<th>Ver pedido</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Cesta pedido : pedidos) {
			%>
			<tr>
				<td><%=pedido.getRestaurante().getNombre()%></td>
				<td><%=pedido.getFecha()%></td>
				<td><a class="btn btn-primary btn-sm" href="#">Ver pedido</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</main>

<%@ include file="includes/pie.jsp"%>