<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
    <style>
        div{
            margin: auto;
            width: 100%;
            height: 710px;
            background-color: #a79a9e;
            padding-top: 220px;
        }
        table{
            width: 650px;
            text-align: center;
            margin: auto;
            height: 400px;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div>
        <table cellspacing="0" cellpadding="0">
            <%
                for (int i = 1; i < 10; i++) {
            %>
            <tr>
                <%
                    for (int j = 1; j < i; j++) {
                %>
                <td><%=i+"x"+j+"="+(i*j)%></td>
                <%
                    }
                %>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
