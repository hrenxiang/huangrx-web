<%@ page import="java.security.Key" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>四大域对象</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    <%=pageContext.getAttribute("key")%><br>
    <%=request.getAttribute("key")%><br>
    <%=session.getAttribute("key")%><br>
    <%=application.getAttribute("key")%>

    <%
        request.getRequestDispatcher("/d.jsp").forward(request,response);
    %>
</body>
</html>
