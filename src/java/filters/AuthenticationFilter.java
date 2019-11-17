package filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
            // this code will execute before HomeServlet and UsersServlet
            HttpServletRequest r = (HttpServletRequest)request;
            HttpSession session = r.getSession();
            
            if (session.getAttribute("username") != null) {
                // if they are authenticated, i.e. have a username in the session,
                // then allow them to continue on to the servlet
                chain.doFilter(request, response);
            } else {
                // they do not have a username in the sesion
                // so, send them to login page
                HttpServletResponse resp = (HttpServletResponse)response;
                resp.sendRedirect("login");
            }
            
            // this code will execute after HomeServlet and UsersServlet
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
