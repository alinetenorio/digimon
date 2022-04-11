package servlet.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {
	private ServletContext context;

    public void init() throws ServletException {
    	
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    		throws IOException, ServletException {

    	HttpServletRequest request = (HttpServletRequest) req;
    	HttpServletResponse response = (HttpServletResponse) res;
    	
        HttpSession session = request.getSession(false);

        if (session == null) { 
        	System.out.println("null request.getContextPath()" + request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/login.html");
        } else {
            // pass the request along the filter chain
        	System.out.println("not null request.getContextPath()" + request.getContextPath());
            
        	chain.doFilter(request, response);
        }
    }

    public void destroy() {
        
    }

}
