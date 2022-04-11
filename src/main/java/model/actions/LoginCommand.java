package model.actions;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PlayerDAO;

public class LoginCommand implements Command{

	private final String pageAllowed = "/WEB-INF/home.jsp";
	private final String pageDenied = "/login.html";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public LoginCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		var player = playerDAO.checkPassword(email, password);
		
		if(player != null) {
			HttpSession oldSession = request.getSession(false);
	        if (oldSession != null) {
	            oldSession.invalidate();
	        }
	  
	        HttpSession session = request.getSession(true);	
	        session.setMaxInactiveInterval(0);
	        
	        session.setAttribute("playerId", player.getId());	        
	        request.setAttribute("team", player.getTeam());
	        request.setAttribute("player", player);
	
	        Cookie message = new Cookie("message", "Welcome");
	        //message.setSecure(true);
	        //message.setHttpOnly(true);
	        response.addCookie(message);
			
			return pageAllowed;
		} else {
			return pageDenied;
		}
		
	}

}

