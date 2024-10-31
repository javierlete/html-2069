<%@page import="iparovo.modelos.Linea"%>
<%@page import="iparovo.modelos.Cesta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
Cesta cesta = (Cesta) session.getAttribute("cesta");
%>

<main class="container mt-4 mb-5 pb-5">
	<h2><%=cesta.getRestaurante().getNombre() %></h2>

	<table class="table table-borderless">
		<caption><%=cesta.getRestaurante().getNombre() %></caption>
		<tbody>
			<%
			for (Linea linea: cesta.getLineas()) {
			%>
			<tr>
				<td><%=linea.getPlato().getNombre()%></td>
				<td>
					<div class="input-group mb-3" style="width: 8rem">
						<button class="btn btn-outline-secondary">
							<i class="bi bi-dash-lg"></i>
						</button>
						<input type="text" class="form-control" placeholder=""
							aria-label="Example text with button addon"
							aria-describedby="button-addon1" value="<%=linea.getCantidad()%>">
						<button class="btn btn-outline-secondary">
							<i class="bi bi-plus-lg"></i>
						</button>
					</div>
				</td>
				<td class="text-end"><%=linea.getTotal()%> €</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">Subtotal</td>
				<td class="text-end"><%=cesta.getSubTotal() %> €</td>
			</tr>
			<tr>
				<td colspan="2">Coste de gestión</td>
				<td class="text-end"><%=cesta.getCosteGestion() %> €</td>
			</tr>
			<tr>
				<td colspan="2">Gastos de envío</td>
				<td class="text-end"><%=cesta.getGastosEnvio() %> €</td>
			</tr>
			<tr class="fw-bold">
				<td colspan="2">Total</td>
				<td class="text-end"><%=cesta.getTotal() %> €</td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="includes/pie.jsp"%>