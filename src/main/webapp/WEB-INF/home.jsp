<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Home</h1>
<table border="1">
<thead>
<tr>
<td>Nome</td>
<%
Player player = (Player)request.getAttribute("player");
%>
<td colspan="2" style="text-align:center"><%= player != null ? player.getName() : "" %></td>
</tr>
</thead>

<tr>
<td>
<%= player != null ? player.getName() : "" %>
</td>
<td> <a href="app?acao=editar&produto=<%= player != null ? player.getName() : "vazio" %>">Editar</a></td>
<td><a href="app?acao=remover&produto=<%= player != null ? player.getName() : "vazio" %>">Remover</a></td>
</tr>

</tbody>
</table>
</body>
</html>