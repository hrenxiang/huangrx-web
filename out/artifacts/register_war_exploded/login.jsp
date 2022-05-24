<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/23
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <base href="${pageContext.request.contextPath}/">
    <style>
        h1 {
            color: #fff;
            text-shadow: 0 0 10px rgba(0,0,0,0.3);
            letter-spacing:1px;
            text-align:center;
            margin-top: 200px;
            font-size: 40px;
        }

        input {
            margin-left: 700px;
            width: 500px;
            margin-bottom: 10px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 13px;
            color: #fff;
            text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
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

<body background="img/33.jpg">
<h1>Login</h1>
<form action="user" method="post">
    <input type="hidden" name="action" value="login">
    <input type="text" name="username" id="username" placeholder="username"><br><br>
    <input type="text" name="password" id="passwoed" placeholder="password"><br><br>
    <input type="submit" value="提交" id="submit">
</form>
</body>
</html>
