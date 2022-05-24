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
        <li><a href="cookies?action=createCookies" target="target">Cookie的创建</a></li>
        <li><a href="cookies?action=getCookies" target="target">Cookie的获取</a></li>
        <li><a href="cookies?action=updateCookies" target="target">Cookie值的修改</a></li>
        <li>Cookie的存活周期</li>
        <li>
            <ul>
                <li><a href="cookies?action=defaultCookie" target="target">Cookie的默认存活时间（会话）</a></li>
                <li><a href="cookies?action=ZeroCookie" target="target">Cookie立即删除</a></li>
                <li><a href="cookies?action=Cookie3600" target="target">Cookie存活3600秒（1小时）</a></li>
            </ul>
        </li>
        <li><a href="cookies?action=setPath" target="target">Cookie的路径设置</a></li>
        <li><a href="" target="target">Cookie的用户免登录练习</a></li>
    </ul>
</div>
</body>
</html>
