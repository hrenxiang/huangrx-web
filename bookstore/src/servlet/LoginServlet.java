package servlet;

import bean.User;
import service.UserService;
import service.impl.UserSServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录页面
 * @author Charon
 * @date 2020/7/7
 **/
public class LoginServlet extends HttpServlet {
/*    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserSServiceImpl();

        if (userService.login(new User(null,username,password,null))!=null){
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }else {
            //设置错误提示及其回传信息
            request.setAttribute("msg","用户名或密码错误！");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }*/

}
