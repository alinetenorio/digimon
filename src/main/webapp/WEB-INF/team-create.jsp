<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.entity.Team"%>
<%@ page import="model.entity.Digimon"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crie sua equipe</title>
</head>
<body>
<h1>Lista de Produtos</h1>

<form method="POST" action="app?action=createTeam">
	<label for="team-name" >Nome do time:</label>
	<input id="team-name" name="team-name" type="text" style="margin-bottom: 10px; padding-bottom:10px" value=""> <br/>
	<table border="1">
		<thead>
			<tr>
			
			<td></td>
			<td>Nome</td>
			
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Digimon> digimons = (ArrayList) request.getAttribute("digimons");
				for(Digimon digimon : digimons){
			%>
				<tr>
				<td>
					<input type="checkbox" id="selected-digimons.<%= digimon.getId() %>" name="selected-digimons" value="<%= digimon.getId() %>">
				</td>
				<td>
			<%=digimon.getName() %>
				</td>
				</tr>
			<%}%>
		</tbody>
	</table>

	<button type="submit" >Criar time</button>
</form>
</body>
</html>