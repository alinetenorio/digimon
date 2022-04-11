package model.actions;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.DigimonDAO;
import model.dao.PlayerDAO;
import model.entity.Digimon;
import model.entity.Player;

public class SignUpCommand implements Command {
	private final String page = "/WEB-INF/team-create.jsp";
	private PlayerDAO playerDAO = new PlayerDAO();
	private DigimonDAO digimonDAO;
	
	public SignUpCommand() {
		super();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		Player player = playerDAO.insert(new Player(name, email, password));		
		listAllDigimons(request, response);
		
		if(player != null) {			
			HttpSession oldSession = request.getSession(false);
	        if (oldSession != null) {
	            oldSession.invalidate();
	        }
	  
	        HttpSession session = request.getSession(true);	
	        session.setMaxInactiveInterval(0);
	        session.setAttribute("playerId", player.getId());
		}
		
		
		return page;
	}

	public void listAllDigimons(HttpServletRequest request, HttpServletResponse response) {
		digimonDAO = new DigimonDAO();
		List<Digimon> digimons = digimonDAO.findAll();
		request.setAttribute("digimons", digimons);
	}
}
