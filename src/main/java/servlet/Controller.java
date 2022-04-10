package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.actions.LoginCommand;
import model.actions.SignUpCommand;
import model.dao.PlayerDAO;
import model.entity.Player;

@WebServlet("/app")
public class Controller extends HttpServlet {
	
	public Controller() {
	    super();
	  }
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    var action = request.getParameter("action");

    if( action.contains("player") ) {
      new PlayerServlet().doGet(request, response);
    } else if( action.contains("digimon") ) {
    //  new DigimonServlet().doGet(request, response);
    }
    
    System.out.println("aqui");

    //service
    //dao
    //command

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
  }
}
