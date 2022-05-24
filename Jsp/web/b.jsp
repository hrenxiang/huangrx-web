<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/3
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page  language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="GB2312" errorPage="/error.jsp"
%>
<html>
<head>
    <title>b</title>
</head>
<body>
<%--    测试errorPage的功能--%>
<%--    <%=1/0%>--%>

    <%--声明脚本 练习： 1、声明类属性 2、声明 static 静态代码块 3、声明类方法 4、声明内部类--%>
    <%--1、声明类属性--%>
    <%! private Integer id; %>
    <%! private String name; %>
    <%! private static Map<String,String> map; %>

    <%--2、声明 static 静态代码块--%>
    <%! static {
        Map<String,String> map=new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }%>

    <%--3、声明类方法--%>
    <%! public int getMath(){
        return 123;
    }%>

    <%--4、声明内部类--%>
    <%! public static class B {}%>


    <%--表达式脚本练习： 1. 输出整型 2. 输出浮点型 3. 输出字符串 4. 输出对象--%>
    <%--1. 输出整型--%>
    <%=123 %><br>
    <%--2. 输出浮点型--%>
    <%=123.123 %><br>
    <%--3. 输出字符串--%>
    <%="帅气" %><br>
    <%--4. 输出对象--%>
    <%=map %><br>


    <%--练习： 1. 代码脚本----if 语句 2. 代码脚本----for 循环语句 3. 翻译后 java 文件中_jspService 方法内的代码都可以写--%>
    <%--1. 代码脚本----if 语句--%>
    <%
        String st = "翔仔真帅！";
        if ("翔仔真帅！".equals(st)){
            System.out.println(st);
        }else{
            System.out.println("翔仔 super powerful！");
            System.out.println("--------------------");
        }
    %>

    <%--2. 代码脚本----for 循环语句--%>
    <%
        for (int i = 0; i < 5; i++) {
            System.out.println("翔仔 super powerful！");
        }
    %>
    <%--3. 翻译后 java 文件中_jspService 方法内的代码都可以写--%>
    <%--_jspService 方法是运行jsp页面后 生成的jsp.java源文件中的方法
        request是_jspService方法的参数
    --%>
    <%
        String username = request.getParameter("username");
        System.out.println(username);
    %>

    <table border="1px solid yellow" cellpadding="0" cellspacing="0" width="300px" height="100px">
    <%
        for (int i = 0; i < 5; i++) {
    %>
        <tr>
            <td><%="第"+i+"行" %></td>
            <td></td>
            <td></td>
        </tr>
    <%
        }
    %>
    </table>

</body>
</html>
