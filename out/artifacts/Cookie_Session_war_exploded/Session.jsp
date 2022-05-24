<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/14
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
    <style>
        ul {
            list-style-type: none;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<iframe width="50%" height="930px" style="background-color: darkcyan; float: left;" name="target">

</iframe>

<div style="float: left; text-align: center; width:900px; height: 700px; font-size: 23px; padding-top: 150px;">
    <ul>
        <li><a href="${pageContext.request.contextPath}/sessionServlet?action=createSession" target="target">Session的创建和获取（id号、是否为新创建）</a></li>
        <li><a href="${pageContext.request.contextPath}/sessionServlet?action=SetAndGet" target="target">Session域数据的存储获取</a></li>
        <li>Session的存活</li>
        <li>
            <ul>
                <li><a href="${pageContext.request.contextPath}/sessionServlet?action=defaultLife" target="target">Session的默认超时及配置</a></li>
                <li><a href="${pageContext.request.contextPath}/sessionServlet?action=setLife" target="target">Session3秒超时销毁</a></li>
                <li><a href="${pageContext.request.contextPath}/sessionServlet?action=invalidate" target="target">Session马上销毁</a></li>
            </ul>
        </li>
        <li><a href="" target="target">浏览器和Session绑定的原理</a></li>
    </ul>
</div>
</body>
</html>
