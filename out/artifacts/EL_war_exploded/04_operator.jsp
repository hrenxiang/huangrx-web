<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/5
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符（operator）</title>
</head>
<body style="background-color: darkcyan; font-size: 25px; text-align: center; padding-top: 180px">
    <%--关系运算--%>
    ${12 == 12}或${12 eq 12}<br>
    ${12 != 12}或${12 ne 12}<br>
    ${12 > 11}或${12 gt 11}<br>
    ${12 < 13}或${12 lt 13}<hr/>
    <%--逻辑运算--%>
    ${12 == 12 && 11 == 11}或${12 == 12 and 11 == 11}<br/>
    ${12 != 11 || 12 != 13}或${12 != 11 or 12 != 13}<br/>
    ${!(12 == 12)}或${not(12 == 12)}<hr/>
    <%--算术运算符--%>
    ${1+2}<br/>
    ${5-4}<br/>
    ${5 * 6}<br/>
    ${6/2}或${6 div 2}<br/>
    ${6%5}或${6 mod 5}<hr/>

    <%--empty运算符--%>
    <% request.setAttribute("a",""); %>
    ${empty a}
    <%request.setAttribute("b",null);%>
    ${empty b}
    <%--不写即为空--%>
    <%request.setAttribute("b2",new Object[]{1});%>
    ${empty b2}
    <hr/>
    <%--三元运算--%>
    <%request.setAttribute("c","cccc");%>
    ${c.equals("abcd")?"想在真帅":"翔仔又骗人了"}
    <hr/>
    <%--.运算--%>
    <%--[]中括号运算符--%>
    <%request.setAttribute("d.d.d","123456");%>
    ${d.d.d}<%--因为键名含有 特殊字符，所以无法得到对应的值--%>
    ${['d.d.d']}
</body>
</html>
