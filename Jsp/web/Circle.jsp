<%@ page import="javafx.scene.shape.Circle" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/4
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>圆的周长和面积</title>
    <style>
        div{
            width: 100%;
            height: 670px;
            background-color: #a79a9e;
            text-align: center;
            padding-top: 260px;
        }
    </style>
</head>
<body>
<div>
    <h1>请输入圆的半径</h1>
    <br>
    <FORM action="Circle.jsp" method="get">
        <input type="text" name="cat">
        <input type="submit" name="submit" value="开始计算">
    </FORM>
    <%!
        public class Circle {
            private double r;

            public Circle(double r) {
                this.r = r;
            }

            public double area() {
                return Math.PI * r * r;
            }
        }
    %>
    <%
        String cat = request.getParameter("cat");
        double r;
        if (cat != null) {
            r = Double.valueOf(cat).doubleValue();
        }else{
            r=1;
        }
        Circle circle = new Circle(r);
    %>
    <h3>半径为<%=(int)r%>>圆的面积是:&nbsp;&nbsp;<%=circle.area()%></h3>
</div>
</body>
</html>
