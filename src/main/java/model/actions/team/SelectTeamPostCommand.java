package model.actions.team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.dao.DigimonDAO;
import model.dao.PlayerDAO;
import model.dao.TeamDAO;
import model.entity.Digimon;
import model.entity.Player;
import model.entity.Team;
import model.service.TeamService;

public class SelectTeamPostCommand implements Command {
	private final String page = "/logged/play.jsp";
	private TeamService teamService = new TeamService();
	private TeamDAO teamDAO = new TeamDAO();
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public SelectTeamPostCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var digimonId = request.getParameter("selected-digimon");
		
		var playerId = (int) request.getSession().getAttribute("playerId");
		
		request.setAttribute("digimonId", digimonId);
		
		return page;
	}

}
