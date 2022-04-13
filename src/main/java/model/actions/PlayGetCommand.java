package model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PlayGetCommand implements Command{

	private final String page = "/play.jsp";
	
	public PlayGetCommand() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return page;
	 
	}

}

