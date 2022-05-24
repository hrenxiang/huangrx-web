<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/5
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐含对象</title>
</head>
<body>
    获取ip:<%=request.getServerName()%><br/>
    获取端口号:<%=request.getServerPort()%><br/>
    获取协议:<%=request.getScheme()%><br/>
    获取工程路径:<%=request.getServletPath()%><br/>
    <%--<%=application.getRealPath("05_hideenObject.jsp")%>--%>
    <%--<%=request.getContextPath()%>--%>
    获取请求方法:<%=request.getMethod()%><br/>
    获取客户端IP:<%=request.getRemoteHost()%><br/>
    获取会话id编号:<%=session.getId()%><hr/>

    <%
        pageContext.setAttribute("req",request);
        pageContext.setAttribute("ses",session);
    %>
    ${ req.serverName }<br/>
    ${ req.serverPort }<br/>
    ${ req.scheme }<br/>
    ${ req.servletPath }<br/>
    ${ req.method}<br/>
    ${ req.remoteHost}<br/>
    ${ ses.id}<br/>
</body>
</html>
