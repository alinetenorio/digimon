package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PlayerDAO;
import model.service.PlayerService;
import model.service.TeamService;

public class GameWinCommand implements Command{

	private final String page = "/WEB-INF/home.jsp";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	private PlayerService playerService = new PlayerService();
	private TeamService teamService = new TeamService();
	
	public GameWinCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (int) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		
		var digimonId = Integer.parseInt((String)request.getParameter("digimonId"));
		
		teamService.nextLevel(player, digimonId);
		playerService.addPoints(player);

		request.setAttribute("team", player.getTeam());
		request.setAttribute("player", player);
		
		return page;
	 
	}

}

