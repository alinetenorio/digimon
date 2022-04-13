package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PlayerDAO;

public class HomeGetCommand implements Command{

	private final String page = "/WEB-INF/home.jsp";
	private final String pageDenied = "/login.html";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public HomeGetCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("playerId") != null) {
			var playerId = (int) request.getSession().getAttribute("playerId");
			var player = playerDAO.find(playerId);
	
			request.setAttribute("team", player.getTeam());
			request.setAttribute("player", player);
			
			return page;	
		}
		return pageDenied;
	}

}

