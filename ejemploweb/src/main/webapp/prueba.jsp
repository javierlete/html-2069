<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo JSP</title>
</head>
<body>
	<ul>
		<% for (int i = 1; i <= 6; i++) { %>
			<li><%=i%></li>
		<% } %>
	</ul>

</body>
</html>