<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态包含</title>
    <style>

        .header{
            width: 100%;
            height: 200px;
            border: 1px solid red;
            background-color: aquamarine;
            font-size: 50px;
            text-align: center;
            line-height: 150px;
        }

        .main{
            width: 100%;
            height: 510px;
            border: 1px solid red;
        }

    </style>
</head>
<body>
    <div class="header">
        欢迎来到我的世界！
    </div>

    <div class="main">

    </div>

    <%--1.静态包含--%>
    <%--<%@include file="footer.jsp"%>--%>

    <%request.setCharacterEncoding("Utf8");%>

    <%--2.动态包含--%>
    <jsp:include page="footer.jsp">
        <jsp:param name="username" value="黄任翔"/>
    </jsp:include>

    <%--3.标签转发--%>
    <jsp:forward page="b.jsp"></jsp:forward>
</body>
</html>
