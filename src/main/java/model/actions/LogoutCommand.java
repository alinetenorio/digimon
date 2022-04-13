package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command{

	private final String page = "/login.html";
	
	public LogoutCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        
        if(session != null)
        	session.removeAttribute("playerId");
            session.invalidate();
		
        return page;
	}

}

