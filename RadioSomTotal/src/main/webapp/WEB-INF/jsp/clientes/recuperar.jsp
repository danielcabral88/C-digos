<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recuperar Todos os Clientes</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Telefone 1</th>
				<th>Telefone 2</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clienteList}" var="cliente">
				<tr>
					<td>${cliente.nome }</td>
					<td>${cliente.telContato1 }</td>
					<td>${cliente.telContato2 }</td>
					<td>${cliente.emailContato }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>