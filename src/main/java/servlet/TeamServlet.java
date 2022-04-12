package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.actions.SignUpCommand;
import model.actions.player.DeleteAccountCommand;
import model.actions.player.EditPlayerPostCommand;
import model.actions.team.CreateTeamCommand;
import model.actions.team.EditTeamGetCommand;
import model.actions.team.EditTeamPostCommand;
import model.actions.team.SelectTeamGetCommand;
import model.actions.team.SelectTeamPostCommand;
import model.entity.Player;

@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
  //private static final long serialVersionUID = 1L;

  public TeamServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  var action = request.getParameter("action").toLowerCase();

	  switch( action ) {
	  
		  case "deleteplayer":
			executeCommand(new DeleteAccountCommand(), request, response);
			break;
		  case "editteam":
			executeCommand(new EditTeamGetCommand(), request, response);
			break;
		  case "selectteam":
				executeCommand(new SelectTeamGetCommand(), request, response);
				break;
		
	  }

  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	  var action = request.getParameter("action").toLowerCase();

	  switch( action ) {
	  
	  case "createteam":
		executeCommand(new CreateTeamCommand(), request, response);
		break;
	  case "editteam":
		executeCommand(new EditTeamPostCommand(), request, response);
		break;
	  case "selectteam":
			executeCommand(new SelectTeamPostCommand(), request, response);
			break;
	  }
  }
  
  private void executeCommand(Command command, HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	var page = command.execute(request, response);	
	request.getRequestDispatcher(page).forward(request, response);
  }
}
