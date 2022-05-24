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
        a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body background="img/33.jpg">
<table style="width: 1000px; height: 330px; margin: 200px auto; border: 1px black solid;text-align: center">
    <tr style="font-size: 20px;font-weight: bold">
        <td>用户ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td colspan="2">操作</td>
    </tr>
        <c:forEach items="${requestScope.users}" var="users">
            <tr style="color: white">
                <td>${users.id}</td>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td>
                    <a href="user?action=getUpdateStudent&id=${users.id}">修改</a>
                </td>
                <td><a href="user?action=delete&id=${users.id}">删除</a></td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
