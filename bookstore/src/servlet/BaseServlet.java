package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Charon
 * @date 2020/7/9
 **/
public abstract class BaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");

        String action = request.getParameter("action");

        try {
            // 获取 action 业务鉴别字符串，获取相应的业务 方法反射对象
            //System.out.println(this);//servlet.UserServlet@20e68ff8
            //System.out.println(this.getClass());//class servlet.UserServlet
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //System.out.println(method);//protected void servlet.UserServlet.login(javax.servlet.http.HttpServletRequest,
            // +javax.servlet.http.HttpServletResponse)throws javax.servlet.ServletException,java.io.IOException

            // 调用目标业务 方法
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }

}
