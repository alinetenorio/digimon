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

public class EditTeamPostCommand implements Command {
	private final String page = "/WEB-INF/home.jsp";
	private TeamService teamService = new TeamService();
	private TeamDAO teamDAO = new TeamDAO();
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public EditTeamPostCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var teamName = request.getParameter("team-name");
		var teamId = Integer.parseInt(request.getParameter("team-id"));
		var digimons = request.getParameterValues("selected-digimons");
		var playerId = (int) request.getSession().getAttribute("playerId");
		
		Player player = playerDAO.find(playerId);
		
		if(player != null) {
		
			List<Integer> digimonsList = new ArrayList<>();
	
			for(int i = 0; i < digimons.length; i++) {
				digimonsList.add(Integer.parseInt(digimons[i]));
			}
			
			try {
				Team team = teamDAO.edit(teamId, teamName);
				System.out.println("=== " + digimonsList.size());
				if(digimonsList.size() > 0)
					teamService.setDigimons(team, digimonsList);
				request.setAttribute("team", team);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return page;
	}

}
