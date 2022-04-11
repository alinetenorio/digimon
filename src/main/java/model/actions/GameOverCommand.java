package model.actions;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PlayerDAO;

public class GameOverCommand implements Command{

	private final String page = "/WEB-INF/home.jsp";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public GameOverCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (int) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		
		request.setAttribute("team", player.getTeam());
		request.setAttribute("player", player);
		
		return page;
	 
	}

}

