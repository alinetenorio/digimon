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
		
		<form method="POST" action="app?action=editTeam">
			<%
				Team team = (Team) request.getAttribute("team");
				ArrayList<TeamDigimon> teamDigimons = (ArrayList) request.getAttribute("teamDigimons");
			%>				
			<div class="album py-3 bg-transparent">		   
				<div class="container">
					<h2>Nome do time:</h2>
					<input id="team-name" name="team-name" type="text" style="background-color:white;margin-bottom: 10px; padding-bottom:10px" 
						value="<%= team.getName() %>"/> 
					<input type="hidden" name="team-id" value="<%= team.getId() %>"/>	
	        	<div class="row">
			<%
				ArrayList<Digimon> digimons = (ArrayList) request.getAttribute("digimons");
				for(Digimon digimon : digimons){			
					
			%>
						<div class="col-md-4">
			              <div class="card mb-4 box-shadow" onclick="check(this)">
				            <input type="checkbox" id="selected-digimons.<%= digimon.getId() %>"
								 name="selected-digimons" value="<%= digimon.getId() %>"
								 <%
								 if(team.getDigimons().size() > 0) {
									 for(Digimon d : team.getDigimons()) {
									 	if(d.getId() == digimon.getId()) out.print("checked"); 
									 }
								 }
								 %>					 
							>
			              	           
			                <img class="card-img-top" src="<%= digimon.getImage() %>" alt="Card image cap">
			                <div class="card-body">
			                  <p class="card-text text-center font-white"> <%= digimon.getName() %> </p>	
			                  <p class="font-white">N�vel:
								<%
								 	boolean myDigimon = false;
								 	for(TeamDigimon td : teamDigimons) {
								 		if(td.getId().getDigimonId() == digimon.getId()) {
								 			out.print(td.getLevel());
								 			myDigimon = true;
								 		}							 		
								 	}
								 	if(!myDigimon) out.print(0);
								 %>	
								</p>        
			                </div>							
							
			              </div>
			            </div>			
				<%	} %>
					</div>
					<div class="row justify-content-center">
			      		<div>
			      			<button type="submit">Editar time</button>
			      		</div>
		      		</div>			
		      	</div>      	
		      </div>		
			
		</form>
	
		<script type="text/javascript">
			function check(el) {
				var checkbox = el.firstChild.nextElementSibling;
				checkbox.checked = checkbox.checked ? false : true;
			}
		</script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		<script src="//code.jquery.com/jquery.min.js"></script>
		<script>
			$.get("menu.html", function(data){
			    $("#nav-placeholder").replaceWith(data);
			});
		</script>
	</body>
</html>