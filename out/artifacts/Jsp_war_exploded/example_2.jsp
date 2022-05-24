<%@ page import="java.util.List" %>
<%@ page import="jsp_01.Bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.ietf.jgss.Oid" %>
<%@ page import="jsp_01.Student" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打印学生信息</title>
    <style>
        body{
            background-color: #a79a9e;
            padding-top: 250px;
        }
        table{
            width: 750px;
            height: 500px;
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>

<% List<Student> students=(List<Student>)request.getAttribute("students");%>

    <table border="1px solid block" cellspacing="0">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>电话</th>
                <th colspan="2">操作</th>
            </tr>
        <% for (Student student : students) {%>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
                <td><%=student.getPhone()%></td>
                <td><a href="#" style="text-decoration:none; color: #843551"><%="修改"%></a></td>
                <td><%="删除"%></td>
            </tr>
        <%}%>

    </table>
</body>
</html>
