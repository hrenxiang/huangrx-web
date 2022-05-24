package servlet;

import bean.User;
import com.google.gson.Gson;
import service.UserService;
import service.impl.UserSServiceImpl;
import utils.beanUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Charon
 * @date 2020/7/9
 **/
public class UserServlet extends BaseServlet {

    private final UserService userService = new UserSServiceImpl();

/*    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if (action.equals("login")){
            login(request,response);
        }else if (action.equals("register")){
            register(request,response);
        }
    }*/

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        //使用beanUtil进行数据封装
        User user = beanUtil.copyParaToBean(request.getParameterMap(), new User());

        //在if判断的外部调用此方法，如果写在if判断的括号内，将无法返回loginUser，保存到session域中时，只能保存user
        //但是通过beanUtil封装的到的user对象只有登录后获取到的username和password，没有id在需要id的地方将无法下手。
        User loginUser = userService.login(user);

        if (loginUser != null) {

            request.getSession().setAttribute("user", loginUser);

            Cookie cookie = new Cookie("username", username);

            cookie.setMaxAge(60 * 60 * 24 * 7);

            response.addCookie(cookie);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            //设置错误提示及其回传信息
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //注销用户（也就是使session无效）调用invalidate方法
        request.getSession().invalidate();

        //重定向到主页或者登录页面
        response.sendRedirect(request.getContextPath());

    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = beanUtil.copyParaToBean(request.getParameterMap(), new User());

        if (token != null && token.equalsIgnoreCase(code)) {

            if (userService.existsUsername(username)) {
                //设置错误提示及其回传信息
                request.setAttribute("msg", "用户名已存在!");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                //用户名存在，注册不成功
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

            } else {

                userService.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);

            }

        } else {
            //设置错误提示及其回传信息
            request.setAttribute("msg", "验证码错误!");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            //验证码错误
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void ajaxRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        System.out.println(username);

        boolean existsUsername = userService.existsUsername(username);

        Map<String,Boolean> map = new HashMap<>();

        map.put("existsUsername",existsUsername);

        Gson gson = new Gson();

        String data = gson.toJson(map);

        System.out.println(data);

        response.getWriter().write(data);

    }

}
