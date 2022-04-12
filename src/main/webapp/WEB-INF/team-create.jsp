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
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="style.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="nav-placeholder"></div>
		
		<form method="POST" action="app?action=createTeam">
			<div class="album py-5 bg-light">		   
				<div class="container">
					<label for="team-name" >Nome do time:</label>
					<input id="team-name" name="team-name" type="text" style="background-color:white;margin-bottom: 10px; padding-bottom:10px" 
						value=""/> 					
	        		<div class="row">
	        	
					<%
						ArrayList<Digimon> digimons = (ArrayList) request.getAttribute("digimons");
						for(Digimon digimon : digimons){
					%>
					
					<div class="col-md-4">
			              <div class="card mb-4 box-shadow" onclick="check(this)">
				            <input type="checkbox" id="selected-digimons.<%= digimon.getId() %>"
								 name="selected-digimons" value="<%= digimon.getId() %>">
							<img class="card-img-top" src="<%= digimon.getImage() %>" alt="Card image cap">
		            	    <div class="card-body">
			                  <p class="card-text text-center"> <%= digimon.getName() %> </p>	        
			                </div>
		                 </div>
		            </div>	
					<%}%>
				</div>
				<div class="row justify-content-center">
		      		<div>
		      			<button type="submit" >Criar time</button>
		      		</div>
	      		</div>			
	      	</div>      	
	      </div>		
		
			
		</form>
		
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
		$.get("menu.html", function(data){
		    $("#nav-placeholder").replaceWith(data);
		});
		</script>
	</body>
</html>