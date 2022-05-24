package com.hh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/17
 **/
@WebFilter(filterName = "Filter1",urlPatterns = "/a.jsp")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter1前置");
        chain.doFilter(req, resp);
        System.out.println("filter1后置");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
