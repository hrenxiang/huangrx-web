<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%--静态包含 头引入--%>
    <%@ include file="../../pages/common/header.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<%@ include file="../common/manager.jsp" %>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>