<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/3
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page  language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="GB2312" errorPage="/error.jsp"
%>
<html>
<head>
    <title>b</title>
</head>
<body>
<%--    ����errorPage�Ĺ���--%>
<%--    <%=1/0%>--%>

    <%--�����ű� ��ϰ�� 1������������ 2������ static ��̬����� 3�������෽�� 4�������ڲ���--%>
    <%--1������������--%>
    <%! private Integer id; %>
    <%! private String name; %>
    <%! private static Map<String,String> map; %>

    <%--2������ static ��̬�����--%>
    <%! static {
        Map<String,String> map=new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }%>

    <%--3�������෽��--%>
    <%! public int getMath(){
        return 123;
    }%>

    <%--4�������ڲ���--%>
    <%! public static class B {}%>


    <%--���ʽ�ű���ϰ�� 1. ������� 2. ��������� 3. ����ַ��� 4. �������--%>
    <%--1. �������--%>
    <%=123 %><br>
    <%--2. ���������--%>
    <%=123.123 %><br>
    <%--3. ����ַ���--%>
    <%="˧��" %><br>
    <%--4. �������--%>
    <%=map %><br>


    <%--��ϰ�� 1. ����ű�----if ��� 2. ����ű�----for ѭ����� 3. ����� java �ļ���_jspService �����ڵĴ��붼����д--%>
    <%--1. ����ű�----if ���--%>
    <%
        String st = "������˧��";
        if ("������˧��".equals(st)){
            System.out.println(st);
        }else{
            System.out.println("���� super powerful��");
            System.out.println("--------------------");
        }
    %>

    <%--2. ����ű�----for ѭ�����--%>
    <%
        for (int i = 0; i < 5; i++) {
            System.out.println("���� super powerful��");
        }
    %>
    <%--3. ����� java �ļ���_jspService �����ڵĴ��붼����д--%>
    <%--_jspService ����������jspҳ��� ���ɵ�jsp.javaԴ�ļ��еķ���
        request��_jspService�����Ĳ���
    --%>
    <%
        String username = request.getParameter("username");
        System.out.println(username);
    %>

    <table border="1px solid yellow" cellpadding="0" cellspacing="0" width="300px" height="100px">
    <%
        for (int i = 0; i < 5; i++) {
    %>
        <tr>
            <td><%="��"+i+"��" %></td>
            <td></td>
            <td></td>
        </tr>
    <%
        }
    %>
    </table>

</body>
</html>
