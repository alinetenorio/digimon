package model.actions.player;

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

public class EditPlayerGetCommand implements Command {
	private final String page = "/WEB-INF/player-edit.jsp";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public EditPlayerGetCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (Integer) request.getSession().getAttribute("playerId");
		var player = playerDAO.find(playerId);
		
		request.setAttribute("player", player);
		
		return page;
	}

}
