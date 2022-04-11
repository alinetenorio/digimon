package model.actions;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PlayerDAO;

public class LogoutCommand implements Command{

	private final String page = "/login.html";
	
	private PlayerDAO playerDAO = new PlayerDAO();
	
	public LogoutCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        
        if(session != null)
            session.invalidate();
		
        return page;
	}

}

