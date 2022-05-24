<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/5
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>步入EL表达式</title>
</head>
<body style="background-color: darkcyan; font-size: 30px; text-align: center; padding-top: 320px">
    <%request.setAttribute("key","value");%>
    request获取到的结果为:<%=request.getAttribute("key")%><br/>
    EL expression获取的结果为:${key}<br/>

    <%--若有一个不存在的key1，则两者得到的结果分别为 null 和 空(什么都没有)--%>
    request获取到的结果为:<%=request.getAttribute("key1")%><br/>
    EL expression获取的结果为:${key1}<br/>
</body>
</html>
