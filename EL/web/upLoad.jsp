<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/6
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body style="text-align: center;background-color: burlywood;padding-top: 260px">
    <form action="http://localhost:8080/EL/upload" method="post" enctype="multipart/form-data">
        用户名:<input type="text" name="username"/>
        密码:<input type="text" name="password"/>
        文件上传:<input type="file" name="photo"/>
        <input type="submit" name="submit"/>
    </form>
</body>
</html>
