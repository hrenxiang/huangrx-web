<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--静态包含 头引入--%>
    <%@ include file="/pages/common/header.jsp" %>

    <script>
        $(function () {
            $("a.delete").click(function () {
                return confirm("您确定要删除【" + $(this).parent().parent().find("td:first").text() + "】嘛!");
            })
        })
    </script>
</head>
<body>

<%@ include file="../common/manager.jsp" %>

<div id="main">
    <table style="width: 1000px; height: 330px">
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.currentData}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="manager/bookServlet?action=getUpdateBook&id=${book.id}&pageNum=${requestScope.page.pageNum}">修改</a>
                </td>
                <td><a href="manager/bookServlet?action=delete&id=${book.id}&pageNum=${requestScope.page.pageNum}"
                       class="delete">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNum=${requestScope.page.pageNumTotal}">添加图书</a></td>
        </tr>
    </table>


    <%--分页条--%>
    <%@ include file="/pages/common/page_nav.jsp" %>

</div>

<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>