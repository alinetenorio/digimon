<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Meu Perfil</title>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="style.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="nav-placeholder"></div>		
		
		<%
			Player player = (Player) request.getAttribute("player");
		%>
		<div class="container">
			<div class="wrapper">
				<div id="formContent">
					<div class="fadeIn first">
				      <img src="img/digivice.png" alt="User Icon" style="padding-top: 30px;" width="200" 
				      	/>
			    	</div>
					<form method="POST" action="app?action=editPlayer">
					
						<label for="email" >Email:</label>
						<input id="email" name="email" type="text" value="<%= player.getEmail() %>"> <br/>
							 
						<label for="name" >Nome:</label>
						<input id="name" name="name" type="text" value="<%= player.getName() %>"> <br/>
						 
						<label for="password" >Senha:</label>
						<input id="password" name="password" type="password" value="<%= player.getPassword() %>"/>
						
						<button type="submit" style="margin-left: 70px">Editar</button>
						<button formaction="app?action=deletePlayer">Excluir Conta</button>
						
					</form>
			
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