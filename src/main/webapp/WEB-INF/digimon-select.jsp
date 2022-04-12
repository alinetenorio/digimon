<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.entity.Team"%>
<%@ page import="model.entity.TeamDigimon"%>
<%@ page import="model.entity.Digimon"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Crie sua equipe</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="style.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	
	<body>
		<div id="nav-placeholder"></div>
		
		<%
			Team team = (Team) request.getAttribute("team");
		%>
		
		<input type="hidden" name="team-id" value="<%= team.getId() %>"/>
				
		<div class="album py-5 bg-light bg-transparent">
	        <div class="container">
				<h2>Time: <%= team.getName() %></h2></br>
				<h2>Escolha um Digimon do seu time para jogar:</h2>
	        	<div class="row">
		<%
				for(Digimon digimon : team.getDigimons()){
		%>
					<div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		              	<a href="logged/play.jsp?selected-digimon=<%= digimon.getId() %>">	            
			                <img class="card-img-top" src="<%= digimon.getImage() %>" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center"> <%= digimon.getName() %> </p>	        
			                </div>
						</a>
		              </div>
		            </div>
				
		<% 		} %>
				</div>			
	      	</div>
	    </div>
	    
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
		$.get("menu.html", function(data){
		    $("#nav-placeholder").replaceWith(data);
		});
		</script>
	</body>
</html>