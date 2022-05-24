package com.hh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/17
 **/
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);

        if ("hh".equals(username) && "123".equals(password)){

            System.out.println("登陆成功");

            request.getSession().setAttribute("user",username);

            request.getRequestDispatcher("/login_success.jsp").forward(request,response);
        }

    }
}
