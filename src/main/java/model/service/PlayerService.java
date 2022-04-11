package model.service;

import java.util.List;

import javax.persistence.NoResultException;

import model.dao.DigimonDAO;
import model.dao.PlayerDAO;
import model.dao.TeamDAO;
import model.entity.Digimon;
import model.entity.Player;
import model.entity.Team;

public class PlayerService {
	private TeamDAO teamDAO = new TeamDAO();
	private DigimonDAO digimonDAO = new DigimonDAO();
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public void addPoints(Player player) {	
		
		if(player != null) {
			playerDAO.addPoints( player );			
		} 

	}
	
}
