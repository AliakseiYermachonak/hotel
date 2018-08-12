package app.service.filter;

import app.db.entity.Request;
import app.db.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            if (user.getIdDelStatus() == 3){
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/room.jsp");
                dispatcher.forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
