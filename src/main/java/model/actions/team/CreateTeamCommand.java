package model.actions.team;

import java.util.ArrayList;
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

public class CreateTeamCommand implements Command {
	private final String page = "/WEB-INF/home.jsp";
	private TeamService teamService = new TeamService();
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public CreateTeamCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var name = request.getParameter("team-name");
		var digimons = request.getParameterValues("selected-digimons");
		var playerId = (int) request.getSession().getAttribute("playerId");
		
		Player player = playerDAO.find(playerId);
		
		if(player != null) {
		
			List<Integer> digimonsList = new ArrayList<>();
	
			for(int i = 0; i < digimons.length; i++) {
				digimonsList.add(Integer.parseInt(digimons[i]));
			}
			
			try {
				Team team = teamService.createTeam(name, player, digimonsList);
				request.setAttribute("team", team);
				request.setAttribute("player", player);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return page;
	}

	
}
