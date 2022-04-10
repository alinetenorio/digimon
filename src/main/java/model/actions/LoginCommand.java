package model.actions;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PlayerDAO;
import model.entity.Player;

public class LoginCommand implements Command{

	private final String page = "/WEB-INF/home.jsp";
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public LoginCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		var player = playerDAO.checkPassword(email, password);
		if(player != null)
			request.setAttribute("player", player);
		
		return page;
	}

}

