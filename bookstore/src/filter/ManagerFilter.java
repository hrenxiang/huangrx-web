package filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/17
 **/
@WebFilter(filterName = "ManagerFilter",urlPatterns = {"/pages/manager/*","/manager/bookServlet"})
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest servletRequest = (HttpServletRequest) req;

        User user = (User) servletRequest.getSession().getAttribute("user");
        if (user!=null){
            chain.doFilter(req, resp);
        }else{
            servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
