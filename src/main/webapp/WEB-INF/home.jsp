<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>
<%@ page import="model.entity.Team"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="style.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="nav-placeholder"></div>
		<%
			String userName = null;
			String sessionID = null;
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("userName")) userName = cookie.getValue();
					if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
				}
			}
			
			Player player = (Player) request.getAttribute("player");
			Team team = (Team) request.getAttribute("team");
		%>
		
		<%
			if(team != null) {
		%>	
			
			
			<div class="album py-5 bg-light">
	        <div class="container">	
	        <h2>Olá <%= userName != null ? userName : "" %> !</h2></br>
	        <h2>Pontos: <%= player.getPoints() %></h2>
	        <h2>Time: <%= team.getName() %></h2>
	        	<div class="row">
		<%
				for(int i = 0; i < team.getDigimons().size(); i++) {
		%>
					<div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" src="<%= team.getDigimons().get(i).getImage() %>" alt="Card image cap">
		                <div class="card-body">
		                  <p class="card-text text-center"> <%= team.getDigimons().get(i).getName() %> </p>	        
		                </div>
		              </div>
		            </div>
				
		<% 		} %>
				</div>			
	      	</div>
		<% 	} %>
		
		<div class="container">
	        <div class="row">
	        	<div class="col-md-3">
	        		<a href="app?action=selectTeam" class="button">Jogar</a>
	        	</div>
	        	<div class="col-md-3">
	        		<a href="app?action=editteam" class="button">Time</a>
	        	</div>
	        	<div class="col-md-3">
	        		<a href="app?action=editplayer" class="button">Perfil</a>
	        	</div>
	        	<div class="col-md-3">        		
	        		<a href="app?action=logout" class="button">Logout</a>
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