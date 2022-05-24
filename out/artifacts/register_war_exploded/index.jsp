<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/23
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <base href="${pageContext.request.contextPath}/">
    <style>
        h1 {
            color: #fff;
            text-shadow: 0 0 10px rgba(0,0,0,0.3);
            letter-spacing:1px;
            text-align:center;
            margin-top: 200px;
            font-size: 60px;
        }

        button{
            width: 500px;
            margin-left: 700px;
            margin-bottom: 20px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 18px;
            color: coral;
            text-shadow: 1px 1px 1px deepskyblue;
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 4px;
            box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
            -webkit-transition: box-shadow .5s ease;
            -moz-transition: box-shadow .5s ease;
            -o-transition: box-shadow .5s ease;
            -ms-transition: box-shadow .5s ease;
            transition: box-shadow .5s ease;
        }
    </style>
</head>
<body background="img/1.jpg">
<h1>Index</h1>
<button type="button" ><a href="login.jsp" style="text-decoration: none">登录</a></button>
<button type="button"><a href="register.jsp" style="text-decoration: none">注册</a></button>
</body>
</html>
