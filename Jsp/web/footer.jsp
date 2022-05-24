<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer</title>
    <style>
        div{
            width: 100%;
            height: 200px;
            border: 1px solid red;
            background-color: aquamarine;
        }
        ul{
            height: 200px;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        li{
            list-style: none;
            height: 150px;
            line-height: 150px;
            margin: 0px 30px;
        }
    </style>
</head>
<body>
    <%request.setCharacterEncoding("Utf8");%>
    <div>
        <ul>
            <li>友情链接</li>
            <li>联系我们</li>
            <li>加入我们</li>
            <li>售后服务</li>
            <li>后台管理</li>
            <li><%=request.getParameter("username")%></li>
        </ul>
    </div>
</body>
</html>
