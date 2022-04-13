package model.service;

import model.dao.PlayerDAO;
import model.entity.Player;

public class PlayerService {
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public void addPoints(Player player) {	
		
		if(player != null) {
			playerDAO.addPoints( player );			
		} 

	}
	
}
