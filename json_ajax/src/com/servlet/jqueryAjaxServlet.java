package com.servlet;

import com.bean.student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charon
 * @date 2020/8/3
 */
@WebServlet(name = "jqueryAjaxServlet",urlPatterns = "/jqueryAjaxServlet")
public class jqueryAjaxServlet extends BaseServlet {
    protected void jqueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<student> arrays = new ArrayList<>();

        arrays.add(new student("hh",21));
        arrays.add(new student("gg",22));

        Gson gson = new Gson();
        String data = gson.toJson(arrays);
        System.out.println(data);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.getWriter().write(data);
    }

    protected void jqueryGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<student> arrays = new ArrayList<>();

        arrays.add(new student("黄任翔",21));
        arrays.add(new student("李文文",22));

        Gson gson = new Gson();
        String data = gson.toJson(arrays);
        System.out.println(data);

        //String s = "abc";

        response.getWriter().write(data);
    }

    protected void jqueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<student> arrays = new ArrayList<>();

        arrays.add(new student("翔仔",21));
        arrays.add(new student("华仔",22));

        Gson gson = new Gson();
        String data = gson.toJson(arrays);
        System.out.println(data);

        //String s = "abc";jqueryGetJSON

        response.getWriter().write(data);
    }
    protected void jqueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<student> arrays = new ArrayList<>();

        arrays.add(new student("shy哥",21));
        arrays.add(new student("无敌",22));

        Gson gson = new Gson();
        String data = gson.toJson(arrays);
        System.out.println(data);

        //String s = "abc";jqueryGetJSON

        response.getWriter().write(data);
    }

    protected void jquerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernme = request.getParameter("username");
        String password = request.getParameter("password");

        Integer password1 = Integer.valueOf(password);

        student student = new student(usernme, password1);

        Gson gson = new Gson();
        String data = gson.toJson(student);
        System.out.println(data);

        //String s = "abc";jqueryGetJSON

        response.getWriter().write(data);
    }

    protected void jquerySerialize2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("hh" .equals(username)){
            response.getWriter().write("用户名已存在");
        }else if (username == null || username.equals("")){
            response.getWriter().write("用户名不能为空");
        }else {
            response.getWriter().write("用户名可用");
        }

     /*
        Integer password1 = Integer.valueOf(password);

        student student = new student(username, password1);

        Gson gson = new Gson();
        String data = gson.toJson(student);
        System.out.println(data);

        //String s = "abc";jqueryGetJSON

        response.getWriter().write(data);*/
    }

}
