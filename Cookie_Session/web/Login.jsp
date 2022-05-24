<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/14
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="cookies?action=login" method="post">
    用户名:<label>
          <input type="text" name="username" value="${cookie.username.value}">
          </label>
    密 码:<label>
        <input type="text" name="password">
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>
