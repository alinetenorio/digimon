package model.actions.player;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.dao.PlayerDAO;
import model.entity.Player;

public class DeleteAccountCommand implements Command {
	private final String page = "/login.html";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public DeleteAccountCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var playerId = (int) request.getSession().getAttribute("playerId");
		
		playerDAO.remove(playerId);
		
		return page;
	}

}
