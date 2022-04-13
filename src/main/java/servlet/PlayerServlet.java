package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.actions.player.DeleteAccountCommand;
import model.actions.player.EditPlayerGetCommand;
import model.actions.player.EditPlayerPostCommand;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


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
