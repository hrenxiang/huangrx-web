package com.hh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/17
 **/
@WebFilter(filterName = "Filter2",urlPatterns = "/a.jsp")
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("filter2前置");
        chain.doFilter(req, resp);
        System.out.println("filter2后置");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
