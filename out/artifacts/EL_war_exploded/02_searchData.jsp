<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/5
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索域中数据的顺序</title>
</head>
<body style="background-color: darkcyan; font-size: 30px; text-align: center; padding-top: 320px">
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key1","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    ${key}<br/>
    ${key1}
</body>
</html>
