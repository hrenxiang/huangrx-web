package com.hh.filter;

import jdk.nashorn.internal.ir.IfNode;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/17
 **/
@WebFilter(filterName = "LoginFilter",urlPatterns = "/admin/*")
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req1 = (HttpServletRequest) req;
        HttpServletResponse resp1 = (HttpServletResponse) resp;
        Object user = req1.getSession().getAttribute("user");

        if(user==null){
            System.out.println("登陆失败");
            req1.getRequestDispatcher("/login.jsp").forward(req1,resp1);
           /* resp1.sendRedirect("/login.jsp");*/
        }else{
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化");
    }

}
