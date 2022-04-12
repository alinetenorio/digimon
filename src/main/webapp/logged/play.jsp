<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.Player"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		
		<style>
		  body {
		    margin: 0;		    		    
		  }
		  
		  #canvas {
		  	display: flex;
		    justify-content: center;
		    align-items: center;
		    background-color: black;
		  }
		</style>
		
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link href="style.css" rel="stylesheet">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>

	<body>
		<div id="nav-placeholder"></div>

		<%
			int digimonId = Integer.parseInt(request.getParameter("selected-digimon"));
		%>
		<form id="gameForm" method="post">
		  <input type="hidden" id="digimonId" value="<%= digimonId %>" >
		  <button onclick="isOver()" id="over" formaction="../app?action=gameover" style="display: none"></button>
		  <button onclick="isOver()" id="win" formaction="../app?action=gamewin&digimonId=<%=digimonId%>" style="display: none"></button>
		  
		  <div id="canvas">
		  	<canvas></canvas>
		  </div>
		  
		</form>

		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
			$.get("../menu.html", function(data){
			    $("#nav-placeholder").replaceWith(data);
			});
		</script>
		<script src="./play.js"></script>
		<script>
			
		  function isOver() {
		    let gameover = document.getElementById("over");
		    
			document.getElementById("gameForm").submit();
		  }
		
		</script>
	</body>
</html>
	