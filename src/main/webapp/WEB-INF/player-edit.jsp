<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Inicio</title>
	</head>
	<body>
		<h1 style="margin-left: 60px">Página de Cadastro de Produtos</h1>
		<div style="margin-left: 100px">
		
		<%
			Player player = (Player) request.getAttribute("player");
		%>
	
		<form method="POST" action="app?action=editPlayer">
		
			<label for="email" >Email:</label>
			<input id="email" name="email" type="text" style="margin-bottom: 10px; padding-bottom:10px"
				 value="<%= player.getEmail() %>"> <br/>
				 
			<label for="name" >Nome:</label>
			<input id="name" name="name" type="text" style="margin-bottom: 10px; padding-bottom:10px"
			 value="<%= player.getName() %>"> <br/>
			 
			<label for="password" >Senha:</label>
			<input id="password" name="password" type="password" value="<%= player.getPassword() %>"/>
			
			<button type="submit" style="margin-left: 100px">Editar</button>
			<button formaction="app?action=deletePlayer">Excluir Conta</button>
		</form>
		
		
		</div>
	</body>
</html>