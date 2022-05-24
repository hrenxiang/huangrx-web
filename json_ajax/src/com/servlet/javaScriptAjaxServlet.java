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
@WebServlet(name = "javaScriptAjaxServlet",urlPatterns = "/AjaxServlet")
public class javaScriptAjaxServlet extends BaseServlet {
    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<student> arrays = new ArrayList<>();

        arrays.add(new student("hh",21));
        arrays.add(new student("gg",22));

        Gson gson = new Gson();
        String s = gson.toJson(arrays);
        System.out.println(s);

        response.getWriter().write(s);

    }
}
