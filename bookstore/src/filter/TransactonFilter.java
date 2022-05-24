package filter;

import utils.jdbcUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/21
 **/
@WebFilter(filterName = "TransactonFilter",urlPatterns = "/*")
public class TransactonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(req, resp);
            jdbcUtil.commitAndClose();
        } catch (Exception e) {
            jdbcUtil.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
