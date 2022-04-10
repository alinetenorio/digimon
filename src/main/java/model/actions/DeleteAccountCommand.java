package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PlayerDAO;
import model.entity.Player;

public class DeleteAccountCommand implements Command {
	private final String page = "/index.html";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public DeleteAccountCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var id = request.getParameter("id");
		
		playerDAO.remove(Integer.parseInt(id));
		
		return page;
	}

}
