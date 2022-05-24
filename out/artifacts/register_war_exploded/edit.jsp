<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/8
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <base href="${pageContext.request.contextPath}/">
    <style>
        a {
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body background="img/33.jpg">
<form action="user" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${requestScope.student.id}">
    <table style="width: 1000px; height: 330px; margin: 200px auto; border: 1px black solid;text-align: center">
        <tr style="font-size: 20px;font-weight: bold">
            <td>用户ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td colspan="2">操作</td>
        </tr>
            <tr style="color: white">
                <td><input name="id" type="text" value="${requestScope.student.id}"/></td>
                <td><input name="username" type="text" value="${requestScope.student.username}"/></td>
                <td><input name="password" type="text" value="${requestScope.student.password}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
    </table>
</body>
</html>
