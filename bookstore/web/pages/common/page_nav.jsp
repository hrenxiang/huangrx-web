<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/13
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分页</title>
    <script>
        $(function () {
            $("#confirm").click(function () {
                var val = $("#pn_input").val();
                if (val < 1 || val >${requestScope.page.pageNumTotal}) {
                    alert("您输入的页码有误，请重新输入！")
                } else {
                    location.href = "${requestScope.page.url}&pageNum=" + val
                }
            })
        })
    </script>
</head>
<body>


<%--分页条--%>
<div id="page_nav" style="position: absolute; width: 1200px;margin-top: 10px;">
    <c:if test="${requestScope.page.pageNum>1}">
        <a href="${requestScope.page.url}&pageNum=1">首页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${requestScope.page.pageNumTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageNumTotal}"/>
        </c:when>
        <c:when test="${requestScope.page.pageNumTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNum <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <c:when test="${requestScope.page.pageNum > requestScope.page.pageNumTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageNumTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageNumTotal}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNum-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNum+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNum}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNum}">
            <a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNum<requestScope.page.pageNumTotal}">
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNumTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageNumTotal}页，${requestScope.page.recodeTotal}条记录
    到第<input name="pn" id="pn_input" value="${requestScope.page.pageNum}"
             oninput="value=value.replace(/[^\d]/g,'')"/>页
    <input type="button" value="确定" id="confirm">
</div>

</body>
</html>
