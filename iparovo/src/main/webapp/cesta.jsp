<%@page import="iparovo.modelos.Linea"%>
<%@page import="iparovo.modelos.Cesta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<%
Cesta cesta = (Cesta) session.getAttribute("cesta");
%>

<main class="container mt-4 mb-5 pb-5">
	<h2>
		Cesta para el restaurante
		<%=cesta.getRestaurante().getNombre()%>
		<%
		if (cesta.getUsuario() != null) {
		%>
		del usuario
		<%=cesta.getUsuario().getNombre()%>
		<%
		}
		%>
	</h2>

	<table class="table table-borderless">
		<caption><%=cesta.getRestaurante().getNombre()%></caption>
		<tbody>
			<%
			for (Linea linea : cesta.getLineas()) {
			%>
			<tr>
				<td><%=linea.getPlato().getNombre()%></td>
				<td>
					<form action="cesta" method="post" class="input-group mb-3"
						style="width: 8rem">
						<button name="menos" value="<%=linea.getPlato().getId()%>"
							class="btn btn-outline-secondary">
							<i class="bi bi-dash-lg"></i>
						</button>
						<input type="text" class="form-control" readonly
							value="<%=linea.getCantidad()%>">
						<button name="mas" value="<%=linea.getPlato().getId()%>"
							class="btn btn-outline-secondary">
							<i class="bi bi-plus-lg"></i>
						</button>
					</form>
				</td>
				<td class="text-end" style="width: 8rem"><%=String.format("%.2f", linea.getTotal())%>
					€</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">Subtotal</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getSubTotal())%>
					€</td>
			</tr>
			<tr>
				<td colspan="2">Coste de gestión</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getCosteGestion())%>
					€</td>
			</tr>
			<tr>
				<td colspan="2">Gastos de envío</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getGastosEnvio())%>
					€</td>
			</tr>
			<tr class="fw-bold">
				<td colspan="2">Total</td>
				<td class="text-end"><%=String.format("%.2f", cesta.getTotal())%>
					€</td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td class="text-end"><a href="pedido" class="btn btn-primary">Pedido</a></td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="includes/pie.jsp"%>