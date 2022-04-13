package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.actions.GameOverCommand;
import model.actions.GameWinCommand;
import model.actions.HomeGetCommand;
import model.actions.LoginCommand;
import model.actions.LogoutCommand;
import model.actions.PlayGetCommand;
import model.actions.SignUpCommand;

@WebServlet("/app")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	public Controller() {
	    super();
	  }
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  var action = request.getParameter("action").toLowerCase();
	  
	  if( action.contains("team") ) {    	
		  new TeamServlet().doGet(request, response);
	  } 
	  
	  if( action.contains("player") ) {    	
		  new PlayerServlet().doGet(request, response);
	  } 
	  
	  if( action.equals("logout") ) {    	
    	Command command = new LogoutCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
	  } 
	  
	  if( action.equals("play") ) {    	
    	Command command = new PlayGetCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
	  } 
	  
	  if( action.equals("home") ) {    	
    	Command command = new HomeGetCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
	  } 
	  
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

	var action = request.getParameter("action").toLowerCase();

    if( action.equals("login") ) {    	
    	Command command = new LoginCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
    } 
    
    if( action.equals("signup") ) {
    	Command command = new SignUpCommand();
		var page = command.execute(request, response);
		request.getRequestDispatcher(page).forward(request, response);
    }
    
    if( action.contains("player") ) {
    	new PlayerServlet().doPost(request, response);
    }
    
    if( action.contains("team") ) {
    	new TeamServlet().doPost(request, response);
    }
    
    if( action.equals("gamewin") ) {    	
    	Command command = new GameWinCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
	}
    
    if( action.equals("gameover") ) {    	
    	Command command = new GameOverCommand();
		var page = command.execute(request, response);
		
		request.getRequestDispatcher(page).forward(request, response);
	}
  }
}
