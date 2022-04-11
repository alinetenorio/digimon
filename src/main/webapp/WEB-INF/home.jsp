<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>
<%@ page import="model.entity.Team"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
</head>
<body>

	<%
		String message = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("message")) message = cookie.getValue();
				if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
		}
		
		Player player = (Player) request.getAttribute("player");
		Team team = (Team) request.getAttribute("team");
	%>
	
	<h1>Home</h1>
	<h3>Login Success</h3>
	
	<span>Pontos: <%= player.getPoints() %></span>
	
	<%
		if(team != null) {
	%>	
			<img src="<%= team.getImage() == null ? "https://i.pinimg.com/564x/59/b2/43/59b243e179f083e8d6420bd4b8816498.jpg" : team.getImage() %>" alt="Imagem do time" ></img>
			<span>Time: <%= team.getName() %></span>
	<%
			for(int i = 0; i < team.getDigimons().size(); i++) {
	%>
				<span>Digimon <%= i %>: <%= team.getDigimons().get(i).getName() %></span>
	<% 		} %>
	<% 	} %>
	
	<button><a href="logged/play.html">Jogar</a></button>
	<button><a href="app?action=logout">Logout</a></button>
	<button><a href="app?action=editteam">Editar</button>
	<button><a href="app?action=editplayer">Perfil</button>
		
</body>
</html>