package model.service;

import java.util.List;

import javax.persistence.NoResultException;

import model.dao.DigimonDAO;
import model.dao.PlayerDAO;
import model.dao.TeamDAO;
import model.entity.Digimon;
import model.entity.Player;
import model.entity.Team;

public class TeamService {
	private TeamDAO teamDAO = new TeamDAO();
	private DigimonDAO digimonDAO = new DigimonDAO();
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public Team createTeam(String name, Player player, List<Integer> digimonsIds) {	
		
		if(player != null) {
			Team team = teamDAO.insert( new Team(name, player ) );
			setDigimons(team, digimonsIds);
			return team;
		} else {
			throw new NoResultException();
		}

	}
	
	public void setDigimons(Team team, List<Integer> digimonIds) {
		for(Digimon d : team.getDigimons()) {
			
			if(!digimonIds.contains(d.getId())) {				
				teamDAO.removeTeamDigimon(team.getId(), d.getId());
				team.getDigimons().remove(d);
			} else {				
				digimonIds.remove((Object)d.getId());
			}
		}
		
		Digimon digimon;
		for( Integer id : digimonIds ) {
			digimon = digimonDAO.find(id);
			teamDAO.addTeamDigimon(team, digimon, 1);
			team.getDigimons().add(digimon);
		}
		
	}
}
