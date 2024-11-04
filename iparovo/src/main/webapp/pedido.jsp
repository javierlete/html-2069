<%@page import="iparovo.modelos.Linea"%>
<%@page import="iparovo.modelos.Cesta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
Cesta cesta = (Cesta) session.getAttribute("cesta");
%>

<main class="container mt-4 mb-5 pb-5">
	<h2><%=cesta.getRestaurante().getNombre()%></h2>

	<table class="table table-borderless">
		<caption><%=cesta.getRestaurante().getNombre()%></caption>
		<thead class="table-secondary">
			<tr>
				<th>Nombre</th>
				<th class="text-end">Cantidad</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Linea linea : cesta.getLineas()) {
			%>
			<tr>
				<td><%=linea.getPlato().getNombre()%></td>
				<td class="text-end"><%=linea.getCantidad()%></td>
				<td class="text-end" style="width: 8rem"><%=String.format("%.2f", linea.getTotal())%> €</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot class="table-secondary">
			<tr>
				<td colspan="2">Subtotal</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getSubTotal())%> €</td>
			</tr>
			<tr>
				<td colspan="2">Coste de gestión</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getCosteGestion())%> €</td>
			</tr>
			<tr>
				<td colspan="2">Gastos de envío</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getGastosEnvio())%> €</td>
			</tr>
			<tr class="fw-bold">
				<td colspan="2">Total</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getTotal())%> €</td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="includes/pie.jsp"%>