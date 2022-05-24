<%@ page import="bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%--静态包含 头引入--%>
    <%@ include file="../../pages/common/header.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>

<%@ include file="../common/manager.jsp" %>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <input type="hidden" name="pageNum" value="${param.pageNum}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>

            <tr>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>