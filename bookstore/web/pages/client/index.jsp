<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%--静态包含 头引入--%>
    <%@ include file="/pages/common/header.jsp" %>
    <script>

        $(function () {
            $(".addItem").click(function () {

            /*    var stock = $(this).attr("stock");
                if (stock == 0) {
                    alert("库存不够，快提醒店家上货吧！");
                } else {
                    var id = $(this).attr("bookId");
                    location.href = "http://localhost:8080/bookstore/cart?action=addItem&id=" + id;
                }*/

                var stock = $(this).attr("stock");
                if (stock == 0) {
                    alert("库存不够，快提醒店家上货吧！");
                } else {
                    var id = $(this).attr("bookId");
                    $.getJSON("http://localhost:8080/bookstore/cart","action=addItem&id="+id,function (data) {
                        alert(data);
                        $("#totalCount").html("您的购物车中有"+data.TotalCount+"件商品");
                        $("#lastName").html("您刚刚将|||"+data.LastName+"|||加入到了购物车中");
                    });
                }
            })
        })

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="user?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>&nbsp;&nbsp;
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="post">
                <input type="hidden" name="action" value="pricePage">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <p style="color: palevioletred;margin-left: 80px">您的购物车还没有商品，快快添加吧！</p>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span id="totalCount"><%--您的购物车中有${sessionScope.cart.totalCount}件商品--%></span>
                <div>
                    <span style="color: red" id="lastName"><%--您刚刚将 [${sessionScope.lastName}] 加入到了购物车中--%></span>
                </div>
            </c:if>
        </div>
        <c:forEach items="${requestScope.page.currentData}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/default.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" stock="${book.stock}" class="addItem">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--分页条--%>
    <%@ include file="/pages/common/page_nav.jsp" %>

</div>
<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>