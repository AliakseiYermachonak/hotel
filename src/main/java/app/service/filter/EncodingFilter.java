package app.service.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Filter class for keeping the encoding UTF-8
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class EncodingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}