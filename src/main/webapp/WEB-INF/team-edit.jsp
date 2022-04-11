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

<form method="POST" action="app?action=editTeam">
	<%
		Team team = (Team) request.getAttribute("team");
	%>
	
	<label for="team-name" >Nome do time:</label>
	<input id="team-name" name="team-name" type="text" style="margin-bottom: 10px; padding-bottom:10px" 
		value="<%= team.getName() %>"/> 
	<input type="hidden" name="team-id" value="<%= team.getId() %>"/>
	<br/>
			
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
					
					if(team.getDigimons().size() > 0) {
			%>
						<tr>
							<td>
							<input type="checkbox" id="selected-digimons.<%= digimon.getId() %>"
							 name="selected-digimons" value="<%= digimon.getId() %>"
							 <%
							 for(Digimon d : team.getDigimons()) {
							 	if(d.getId() == digimon.getId()) out.print("checked"); 
							 }
							 %>					 
							 >
							</td>
							<td>
								<%=digimon.getName() %>	
							</td>
						</tr>
					<%} else {%>
						<tr>
						<td>
						<input type="checkbox" id="selected-digimons.<%= digimon.getId() %>"
						name="selected-digimons" value="<%= digimon.getId() %>">
						</td>
						<td>
							<%=digimon.getName() %>	
						</td>
						</tr>
					<%}%>
						
				<%}%>
		</tbody>
	</table>

	<button type="submit" >Editar time</button>
</form>
</body>
</html>