package com.utils;

import javax.servlet.http.Cookie;

/**
 * @author Charon
 * @date 2020/7/14
 **/
public class CookieUtil {

    /**
     * 获取cookie
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){

        if (name==null || cookies==null || cookies.length==0){
            return null;
        }

        for (Cookie cookie : cookies){
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
