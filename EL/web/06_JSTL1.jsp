<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/6
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库</title>
    <style>
        table{
            width: 750px;
            height: 500px;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body style="background-color: darkcyan; font-size: 20px; text-align: center; padding-top: 320px">
    保存前：${requestScope.hh}<br>
    <c:set scope="request" var="hh" value="hh.value" />
    保存后：${requestScope.hh}<hr>

    <c:if test="${12==12}">
        <span>12等于12</span><br/>
    </c:if>
    <c:if test="${12!=11}">
        <span>12不等11</span><hr/>
    </c:if>

    <c:forEach begin="1" end="3" var="i">
        <span>${i}: 翔仔好帅</span><br/>
    </c:forEach>
    <hr/>

    <% request.setAttribute("arr",new String[]{"123456","456789"}); %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}<br/>
    </c:forEach>
    <hr/>

    <%
        Map<String,String> map=new HashMap<String, String>();
        map.put("1","123");
        map.put("2","456");
        map.put("3","789");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        ${entry.key}:${entry.value}<br/>
    </c:forEach>
    <hr/>

    <%
        List<Teacher> list=new ArrayList<Teacher>();
        for (int i = 1; i < 4; i++) {
            Teacher teacher=new Teacher(i,"hh"+i,21+i,"女");
            list.add(teacher);
        }
        request.setAttribute("list",list);
    %>
    <table border="1px solid block" cellspacing="0">

        <tr>
            <th>ID</th>
            <th>名字</th>
            <th>年龄</th>
            <th>性别</th>
            <th>操作</th>
        </tr>

        <C:forEach items="${requestScope.list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.sex}</td>
                <td>${"删除 | 修改"}</td>
            </tr>
        </C:forEach>
    </table>

</body>
</html>
