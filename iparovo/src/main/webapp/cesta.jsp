<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container mt-4 mb-5 pb-5">
	<table class="table table-borderless">
		<caption>Cesta</caption>
		<tbody>
			<%
			for (int i = 1; i <= 4; i++) {
			%>
			<tr>
				<td>Plato <%=i%></td>
				<td>
					<div class="input-group mb-3" style="width: 8rem">
						<button class="btn btn-outline-secondary">
							<i class="bi bi-dash-lg"></i>
						</button>
						<input type="text" class="form-control" placeholder=""
							aria-label="Example text with button addon"
							aria-describedby="button-addon1" value="1">
						<button class="btn btn-outline-secondary">
							<i class="bi bi-plus-lg"></i>
						</button>
					</div>
				</td>
				<td class="text-end"><%=i * 1.11%> €</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">Subtotal</td>
				<td class="text-end">5.55 €</td>
			</tr>
			<tr>
				<td colspan="2">Coste de gestión</td>
				<td class="text-end">0.55 €</td>
			</tr>
			<tr>
				<td colspan="2">Gastos de envío</td>
				<td class="text-end">1.55 €</td>
			</tr>
			<tr class="fw-bold">
				<td colspan="2">Total</td>
				<td class="text-end">5.55 €</td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="includes/pie.jsp"%>