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
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("userName")) userName = cookie.getValue();
				}
			}
			
			Player player = (Player) request.getAttribute("player");
			Team team = (Team) request.getAttribute("team");
		%>			
			
			<div class="album py-3 bg-light bg-transparent">
	        <div class="container">	
	        <h2>Olá <%= userName != null ? userName : "" %> !</h2></br>
	        <h2>Pontos: <%= player.getPoints() %></h2>
	        <h2>Time: <%= team.getName() %></h2>
	        	<div class="row">
		
					<div class="col-md-3">
		              <div class="card mb-4 box-shadow">
			             <a href="app?action=selectTeam" class="font-white">
			                <img class="card-img-top" src="img/invaders.png" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center"> Jogar </p>	        
			                </div>
		                </a>
		              </div>
		            </div>	
		            
		          	  <div class="col-md-3">
		              <div class="card mb-4 box-shadow">
			             <a href="app?action=editteam" class="font-white">
			                <img class="card-img-top" src="img/digimons.jpg" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center">Time </p>	        
			                </div>
		                </a>
		              </div>
		            </div>	
		            
		            <div class="col-md-3">
		              <div class="card mb-4 box-shadow">
		              	<a href="app?action=editplayer" class="font-white">
			                <img class="card-img-top" src="img/perfil.jpg" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center">Perfil</p>	        
			                </div>
		                </a>
		              </div>
		            </div>	
		            
		            <div class="col-md-3">
		              <div class="card mb-4 box-shadow">
		              	<a href="app?action=logout" class="font-white">
			                <img class="card-img-top" src="img/bye.jpg" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center">Logout</p>	        
			                </div>
		                </a>
		              </div>
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