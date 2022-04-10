package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PlayerDAO;
import model.entity.Player;

public class EditPlayerCommand implements Command {
	private final String page = "/WEB-INF/home.jsp";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public EditPlayerCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var id = Integer.parseInt(request.getParameter("id"));
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		playerDAO.edit(id, name, email, password);
		
		return page;
	}

}
