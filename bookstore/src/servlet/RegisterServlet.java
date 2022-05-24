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
 * @author Charon
 * @date 2020/7/7
 **/
public class RegisterServlet extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        UserService userService = new UserSServiceImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        if ("abc".equals(code)){

            if (userService.existsUsername(username)){
                //设置错误提示及其回传信息
                request.setAttribute("msg","用户名已存在!");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                //用户名存在，注册不成功
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

            }else {

                userService.register(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);

            }

        }else {
            //设置错误提示及其回传信息
            request.setAttribute("msg","验证码错误!");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            //验证码错误
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }


    }*/
}
