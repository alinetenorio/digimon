package model.actions.team;

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

public class EditTeamGetCommand implements Command {
	private final String page = "/WEB-INF/team-edit.jsp";
	private TeamDAO teamDAO = new TeamDAO();
	private PlayerDAO playerDAO = new PlayerDAO();
	private DigimonDAO digimonDAO = new DigimonDAO();
	
	public EditTeamGetCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (Integer) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		var team = player.getTeam();
		
		request.setAttribute("team", team);
		
		listAllDigimons(request, response);
		
		return page;
	}
	
	public void listAllDigimons(HttpServletRequest request, HttpServletResponse response) {
		digimonDAO = new DigimonDAO();
		List<Digimon> digimons = digimonDAO.findAll();
		request.setAttribute("digimons", digimons);
	}

}
