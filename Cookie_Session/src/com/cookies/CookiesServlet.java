package com.cookies;

import com.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Charon
 * @date 2020/7/14
 **/
@WebServlet(name = "CookiesServlet" , urlPatterns = "/cookies")
public class CookiesServlet extends BaseServlet {

    /**
     * 添加cookie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("hh1","ww1");

        response.addCookie(cookie);

        response.getWriter().write("cookie已经保存！");
    }

    /**
     * 获取cookie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
 /*       for (Cookie cookie : cookies) {
            //System.out.println(cookie);
            response.getWriter().write(cookie.getName()+"="+cookie.getValue()+"<br>");
        }*/

        //获取相应的cookie对象，需要先得到所有cookie的集合（因为cookie没有单独获取一个cookie的方法），然后遍历cookie集合，
        //在遍历的时候判断是否有与已知key值相等的cookie，如果有，则进行输出
        Cookie cookie = CookieUtil.findCookie("hh", cookies);
        if (cookie!=null){
            response.getWriter().write(cookie.getName()+"="+cookie.getValue());
        }
    }

    /**
     * 修改cookie的两种方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        直接获取相应的cookie对象并且设置新值，重新设置后，一定要调用addCookie()方法，不然没有作用

//        Cookie cookie = new Cookie("hh","newWW");
//
//        response.addCookie(cookie);
//
//        response.getWriter().write("cookie修改成功！");

        //先获取需要修改的cookie对象，然后重新设置cookie对象的值，重新设置后，一定要调用addCookie()方法，不然没有作用
        Cookie cookie = CookieUtil.findCookie("hh1", request.getCookies());

        if (cookie!=null){
            cookie.setValue("newWW1");
            response.addCookie(cookie);
        }

        response.getWriter().write("cookie修改成功");

    }

    /**
     * 创建的cookie如果不设置存活周期，默认周期一般是-1，-1代表关闭浏览器后，cookie就消失
     * 设置cookie周期的方法，setMaxAge(int expiry)
     * 设置后，一定要调用addCookie（）方法，通知客户端保存相应cookie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("default" ,"defaultValue");

        cookie.setMaxAge(-1);

        response.addCookie(cookie);

        response.getWriter().write("默认存活时间cookie创建成功");

    }

    /**
     *当setMaxAge（0） 时，表示cookie立刻删除，即刻销毁
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ZeroCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("zero" ,"zeroValue");

        cookie.setMaxAge(0);

        response.addCookie(cookie);

        response.getWriter().write("存活时间为0的cookie创建成功");

    }

    /**
     * 当expire为正数时，表示相应的存活周期，1代表1秒，60代表1分钟
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void Cookie3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("cookie3600" ,"cookie3600Value");

        cookie.setMaxAge(60);

        response.addCookie(cookie);

        response.getWriter().write("存活时间为60秒的cookie创建成功");

    }

    protected void setPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("path" ,"path");

        cookie.setPath(request.getContextPath()+"/abc");

        response.addCookie(cookie);

        response.getWriter().write("路径为/Cookies_Session/abc的cookie创建成功");

    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("hh") && password.equals("123")){

            Cookie cookie = new Cookie("username" , username);

            cookie.setMaxAge(60*60*24*7);

            response.addCookie(cookie);

            System.out.println("登录成功");

            response.getWriter().write("<script>$(function(){alert(登陆成功);})</script>");
        }
        System.out.println("登录失败");
    }
}
