package model.actions;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PlayerDAO;
import model.service.PlayerService;

public class GameWinCommand implements Command{

	private final String page = "/WEB-INF/home.jsp";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	private PlayerService playerService = new PlayerService();
	
	public GameWinCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (int) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		
		playerService.addPoints(player);

		request.setAttribute("team", player.getTeam());
		request.setAttribute("player", player);
		
		return page;
	 
	}

}

