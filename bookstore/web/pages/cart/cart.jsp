<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--静态包含 头引入--%>
    <%@ include file="../../pages/common/header.jsp" %>
    <script>

        $(function () {
            $(".delete").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗?");
            })

            $("#clear").click(function () {
                return confirm("你确定要清空购物车吗?");
            })

            $(".updateCount").change(function () {

                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr("bookid");
                var count = $(this).val();

                if (confirm("您确定要修改【" + name + "】的数量为【" + count + "】嘛")) {

                    location.href = "http://localhost:8080/bookstore/cart?action=updateItem&id=" + id + "&count=" + count;

                } else {
                    this.value = this.defaultValue;
                }
            })

        })

    </script>
</head>
<body>

<%--登录成功后显示的个人条框--%>
<%@ include file="../common/login_success.jsp" %>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input type="text" value="${entry.value.count}" bookid="${entry.value.id}" name="count"
                               class="updateCount">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a href="cart?action=deleteItem&id=${entry.value.id}" class="delete">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">亲，您的购物车中还没有物品！快去和您的小伙伴一起转转吧！</td>
            </tr>
        </c:if>
    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cart?action=clear" id="clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=creatOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>