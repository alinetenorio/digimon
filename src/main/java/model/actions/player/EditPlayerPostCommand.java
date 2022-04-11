package model.actions.player;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;
import model.dao.PlayerDAO;
import model.entity.Player;

public class EditPlayerPostCommand implements Command {
	private final String page = "/WEB-INF/home.jsp";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public EditPlayerPostCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var id = (int) request.getSession().getAttribute("playerId");
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		Player player = playerDAO.edit(id, name, email, password);
		
		request.setAttribute("team", player.getTeam());
		
		return page;
	}

}
