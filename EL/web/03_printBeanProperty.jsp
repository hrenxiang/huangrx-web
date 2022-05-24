<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/5
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出Bean的各个属性</title>
</head>
<body style="background-color: darkcyan; font-size: 30px; text-align: center; padding-top: 320px">
    <%
        Student student = new Student();
        student.setName("翔仔好帅！");
        student.setPhone(new String[]{"123456","456789"});
        List<String> cities = new ArrayList<String>();
        cities.add("上海");
        cities.add("北京");
        student.setCities(cities);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        student.setMap(map);
        request.setAttribute("stu",student);
    %>
    所有信息:&nbsp;&nbsp;${stu}<br/>
    此同学的名字为:&nbsp;&nbsp;${stu.name}<br/>
    所有的电话号码为:&nbsp;&nbsp;${stu.phone}<br/><%--获取到的是地址值：[Ljava.lang.String;@7157ed0d--%>
    主电话号码为:&nbsp;&nbsp;${stu.phone[0]}<br/>
    去过的城市:&nbsp;&nbsp;${stu.cities}<br/>
    居住地:&nbsp;&nbsp;${stu.cities[0]}<br/>
    设置的键值对是:&nbsp;&nbsp;${stu.map}
</body>
</html>
