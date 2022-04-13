package servlet.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {

    public void init() throws ServletException {
    	
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    		throws IOException, ServletException {

    	HttpServletRequest request = (HttpServletRequest) req;
    	HttpServletResponse response = (HttpServletResponse) res;
    	
        HttpSession session = request.getSession(false);

        if (session == null) { 
            response.sendRedirect(request.getContextPath() + "/login.html");
        } else {            
        	chain.doFilter(request, response);
        }
    }

    public void destroy() {
        
    }

}
