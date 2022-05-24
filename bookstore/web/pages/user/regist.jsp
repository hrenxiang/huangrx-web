<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--静态包含 头引入--%>
    <%@ include file="../../pages/common/header.jsp"%>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/messages_zh.js"></script>
    <script type="text/javascript">
        $(function(){

            $("#username").blur(function () {

                var username = this.value;

                $.getJSON("http://localhost:8080/bookstore/user","action=ajaxRegister&username="+username,function (data) {
                    //alert($("#username").serialize());
                    /*alert(username);
                    alert(data);
                    alert(data.existsUsername);
                    console.log(data)*/

                    if (data.existsUsername) {
                        //设置错误提示及其回传信息
                        $(".errorMsg").text("用户名已存在");
                    } else {
                        $(".errorMsg").text("用户名可用");
                    }

                })
            })

            $("#kaptchJpg").click(function () {

                this.src="${pageContext.request.contextPath}/kaptch.jpg?date="+new Date();

            })

            $("#register").validate({
                errorPlacement: function(error, element) {
                    $(".errorMsg").css("color","red");
                    $(".errorMsg").html(error.text());
                },
                success:function(){
                    $(".errorMsg").empty();
                },
                rules:{
                    username:{
                        required:true,
                        minlength:2,
                        maxlength:8,
                        success:true
                    },
                    password:{
                        required:true,
                        minlength:6
                    },
                    repwd:{
                        required:true,
                        equalTo:password
                    },
                    email:{
                        required:true,
                        email: true
                    }
                },
                messages:{
                    username:{
                        required:"用户名必填",
                        minlength:"最小长度为二",
                        maxlength: "最大长度为八",
                        success: "ok"
                    },
                    password:{
                        required:"密码必填",
                        minlength:"密码最小长度为六"
                    },
                    repwd:{
                        required:"二次密码必填",
                        equalTo:"密码二次输入不同"
                    },
                    email:{
                        required:"邮箱必填",
                        email:"邮箱格式不符"
                    }
                }
            })
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        ${empty requestScope.msg?"":requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="user" method="post" id="register">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" name="password" id="password"
                               autocomplete="off"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" name="repwd" id="repwd"
                               autocomplete="off"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" name="email" id="email"
                               value="${requestScope.email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 120px;" id="code"
                               autocomplete="off"/>
                        <img alt="" id="kaptchJpg" src="kaptch.jpg" style="float:right;margin-right:50px; width: 100px; height: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含-页脚--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>