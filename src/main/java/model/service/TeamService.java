package model.service;

import java.util.Iterator;
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
		System.out.println("Criando time. digimonIds.size: " + digimonIds.size());
		for(Iterator<Digimon> it = team.getDigimons().iterator(); it.hasNext();) {
			Digimon d = it.next();
			if(!digimonIds.contains(d.getId())) {				
				teamDAO.removeTeamDigimon(team.getId(), d.getId());
				it.remove();
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
	
	public void nextLevel(Player player, int digimonId) {
		teamDAO.nextLevel(player.getTeam().getId(), digimonId);
	}
}
