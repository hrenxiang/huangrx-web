<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/8
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>manager</title>
    <%--静态包含 头引入--%>
    <%@ include file="../../pages/common/header.jsp"%>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">订单管理系统</span>
    <div>
        <a href="manager/bookServlet?action=page">图书管理</a>
        <a href="pages/manager/order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>
</body>
</html>
