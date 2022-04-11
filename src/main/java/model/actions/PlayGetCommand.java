package model.actions;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PlayerDAO;

public class PlayGetCommand implements Command{

	private final String page = "/play.html";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public PlayGetCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		/*var playerId = (int) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
			
		request.getSession().setAttribute("playerId", player.getId());	        
        request.setAttribute("team", player.getTeam());*/
		
		return page;
	 
	}

}

