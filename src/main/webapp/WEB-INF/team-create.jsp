<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.entity.Team"%>
<%@ page import="model.entity.Digimon"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Produtos</title>
</head>
<body>
<h1>Lista de Produtos</h1>
<table border="1">
<thead>
<tr>
<td>Nome</td>

<td colspan="2" style="text-align:center">A��es</td>
</tr>
</thead>
<%
ArrayList<Digimon> digimons = (ArrayList) request.getAttribute("digimons");
for(Digimon digimon : digimons){
%>
<tr>
<td>
<%=digimon.getName() %>
</td>
<td> <a href="app?acao=editar&produto=<%=digimon.getName()%>">Editar</a></td>
<td><a href="app?acao=remover&produto=<%=digimon.getName()%>">Remover</a></td>
</tr>
<%}%>
</tbody>
</table>
</body>
</html>