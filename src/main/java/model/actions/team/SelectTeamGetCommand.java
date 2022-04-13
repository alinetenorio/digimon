package model.actions.team;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.dao.PlayerDAO;

public class SelectTeamGetCommand implements Command {
	private final String page = "/WEB-INF/digimon-select.jsp";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public SelectTeamGetCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (Integer) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		
		var team = player.getTeam();
		
		request.setAttribute("team", team);
		
		return page;
	}
	

}
