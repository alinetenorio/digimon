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
import model.actions.player.EditPlayerGetCommand;
import model.actions.player.EditPlayerPostCommand;
import model.actions.team.EditTeamGetCommand;
import model.entity.Player;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
  //private static final long serialVersionUID = 1L;

  //TODO: remover teste
  private List<Player> players = new ArrayList<>();

  public PlayerServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  var action = request.getParameter("action").toLowerCase();

	  switch( action ) {
	  
		  case "editplayer":
			executeCommand(new EditPlayerGetCommand(), request, response);
			break;	
		 
	  }
    
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	  var action = request.getParameter("action").toLowerCase();

	  switch( action ) {
	  
		  case "editplayer":
			executeCommand(new EditPlayerPostCommand(), request, response);
			break;
			
		  case "deleteplayer":
				executeCommand(new DeleteAccountCommand(), request, response);
				break;
	  }
  }
  
  private void executeCommand(Command command, HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	var page = command.execute(request, response);	
	request.getRequestDispatcher(page).forward(request, response);
  }
}
