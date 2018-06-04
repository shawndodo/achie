<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/2
  Time: 下午4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String wrongMessage = (String) session.getAttribute("wrongMessage");
    System.out.println("错误信息是====" + wrongMessage);
    if(wrongMessage == null || wrongMessage == "" || wrongMessage == "null"){
        wrongMessage = "不要显示";
    }
    System.out.println("错误信息是2====" + wrongMessage);
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>成果管理系统 | 登陆</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/plugins/iCheck/square/blue.css">

    <%@include file="../share/header_logo.jsp" %>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page" style="background: url(<%=request.getContextPath()%>/statics/image/achie_background3.jpg); background-size:cover;">
<div class="login-box">
    <div class="login-logo">
        <a href="login">教师教学与科研成果管理系统</a>
    </div>
    <!-- /.servlets-logo -->
    <div class="login-box-body" style="background: none;">
        <%--<p class="login-box-msg">登陆</p>--%>

        <form action="loginServlet" method="post">
            <%--暂时不用使用邮箱登陆--%>
            <%--<div class="form-group has-feedback">--%>
                <%--<input type="email" class="form-control" placeholder="Email">--%>
                <%--<span class="glyphicon glyphicon-envelope form-control-feedback"></span>--%>
            <%--</div>--%>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="userName" placeholder="请填写用户名">
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="userPwd" placeholder="请填写密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <%--<div class="checkbox icheck">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> Remember Me--%>
                        <%--</label>--%>
                    <%--</div>--%>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <%--<div class="social-auth-links text-center">--%>
            <%--<p>- OR -</p>--%>
            <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using--%>
                <%--Facebook</a>--%>
            <%--<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using--%>
                <%--Google+</a>--%>
        <%--</div>--%>
        <!-- /.social-auth-links -->

        <%--暂时注释--%>
        <%--<a href="#">忘记密码</a><br>--%>
        <%--<a href="register.jsp" class="text-center">注册</a>--%>

    </div>
    <!-- /.servlets-box-body -->
</div>
<!-- /.servlets-box -->

<!-- jQuery 3 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="<%=request.getContextPath()%>/statics/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });

        var wrongMessage = "<%=wrongMessage%>";

        if((wrongMessage != undefined || wrongMessage != "" || wrongMessage != "null") && wrongMessage != "不要显示"){
            "<%session.setAttribute("wrongMessage","null");%>";
            alert(wrongMessage);
        }
    });
</script>
</body>
</html>
