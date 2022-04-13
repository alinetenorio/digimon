package model.actions.team;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.actions.Command;

public class SelectTeamPostCommand implements Command {
	private final String page = "/logged/play.jsp";
	
	public SelectTeamPostCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var digimonId = request.getParameter("selected-digimon");
		
		request.setAttribute("digimonId", digimonId);
		
		return page;
	}

}
