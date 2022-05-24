package com.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/14
 **/
@WebServlet(name = "SessionServlet",urlPatterns = "/sessionServlet")
public class SessionServlet extends BaseServlet {
    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean isNew = session.isNew();

        if (isNew){
            System.out.println("是新的");
        }else{
            System.out.println("不是新的");
        }

        String id = session.getId();

        response.getWriter().write("会话session是"+session+"<br/>");
        response.getWriter().write("此session是否为新的"+isNew+"<br/>");
        response.getWriter().write("此session的id为"+id+"<br/>");
    }

    protected void SetAndGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("key1","value1");
        response.getWriter().write("Session数据存储成功"+"<br/>");

        Object value1 = request.getSession().getAttribute("key1");
        response.getWriter().write("Session获取"+value1+"<br/>");
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int maxInactiveInterval = session.getMaxInactiveInterval();

        response.getWriter().write("默认最大非活动间隔是："+maxInactiveInterval);

    }

    protected void setLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(3);

        int maxInactiveInterval = session.getMaxInactiveInterval();

        response.getWriter().write("设置的最大非活动间隔是："+maxInactiveInterval);

    }

    protected void invalidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.invalidate();
        int maxInactiveInterval = session.getMaxInactiveInterval();

        response.getWriter().write("设置的最大非活动间隔是："+maxInactiveInterval);

    }
}
