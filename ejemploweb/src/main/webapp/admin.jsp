<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<main class="container mt-4 mb-5 pb-5">
	<table class="table table-bordered table-striped table-hover">
		<caption>Mantenimiento de Productos</caption>
		<thead class="table-dark">
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Producto producto : productos) {
			%>
			<tr>
				<th class="text-end"><%=producto.getId() %></th>
				<td><%=producto.getNombre() %></td>
				<td class="text-end"><%=producto.getPrecio() %></td>
				<td><a class="btn btn-sm btn-primary" href="formulario.jsp?id=<%=producto.getId()%>"><i
						class="bi bi-pencil-fill"></i></a> <a class="btn btn-sm btn-danger"
					href="#"><i class="bi bi-trash-fill"></i></a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="formulario.html" class="btn btn-sm btn-primary"><i
						class="bi bi-plus-lg"></i></a></td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="includes/pie.jsp"%>