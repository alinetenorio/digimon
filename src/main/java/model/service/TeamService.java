package model.service;

import java.util.List;

import model.dao.DigimonDAO;
import model.dao.TeamDAO;
import model.entity.Team;

public class TeamService {
	private TeamDAO teamDAO = new TeamDAO();
	private DigimonDAO digimonDAO = new DigimonDAO();
	
	public void setDigimons(int teamId, List<Integer> digimonIds) {
		
		Team team = teamDAO.find(teamId);
		team.getDigimons().clear();
		
		for( Integer id : digimonIds ) {
			team.getDigimons().add(digimonDAO.find(id));
		}
		
		teamDAO.setDigimons(team);
	}
}
