<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out/response.getwriter</title>
</head>
<body>
    <%
        out.write("out<br/>");
        out.flush();
        out.write("out2<br/>");
        out.write(123);
        out.write("<br/>");
        out.print(123);
        out.print("<br/>");
        out.write(123);
        out.write("<br/>");
        out.write(String.valueOf(123));
        out.write("<br/>");
        //out.write(new Integer(123).intValue());

        out.print(456);
        out.print(456);

        response.getWriter().write("response.getwriter<br/>");
        response.getWriter().write("response.getwriter2<br/>");

    %>
</body>
</html>
