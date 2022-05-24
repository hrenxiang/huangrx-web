<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<%--静态包含 头引入--%>
	<%@ include file="../../pages/common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

<%--登录成功后显示的个人条框--%>
<%@ include file="../common/login_success.jsp"%>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.orderId}</h1>
		
	
	</div>

	<%--静态包含-页脚--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>