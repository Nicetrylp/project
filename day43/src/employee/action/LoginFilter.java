package employee.action;

import employee.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter" , urlPatterns = {"/user/index.jsp","/employee/ add.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("111");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
        }
        response.sendRedirect(request.getContextPath()+"../login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
