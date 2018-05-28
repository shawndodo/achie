<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/3
  Time: 上午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>成果管理系统 | 首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%--<%--%>
        <%--String userName = (String) session.getAttribute("loginName");--%>
    <%--%>--%>
    <!-- Main Header -->
    <%@include file="../share/header.jsp" %>

    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="../share/sidebar.jsp" %>



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <%--<%--%>
                <%--String userName = (String) session.getAttribute("loginName");--%>
            <%--%>--%>
            <h1>
                欢迎<%=realName%>
                <%--<small>Optional description</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 欢迎</a></li>
                <li class="active">当前页</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@include file="../share/footer.jsp" %>


    <!-- Control Sidebar -->
    <%--右侧栏--%>
    <%--<aside class="control-sidebar control-sidebar-dark">--%>
        <%--<!-- Create the tabs -->--%>
        <%--<ul class="nav nav-tabs nav-justified control-sidebar-tabs">--%>
            <%--<li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>--%>
            <%--<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>--%>
        <%--</ul>--%>
        <%--<!-- Tab panes -->--%>
        <%--<div class="tab-content">--%>
            <%--<!-- Home tab content -->--%>
            <%--<div class="tab-pane active" id="control-sidebar-home-tab">--%>
                <%--<h3 class="control-sidebar-heading">Recent Activity</h3>--%>
                <%--<ul class="control-sidebar-menu">--%>
                    <%--<li>--%>
                        <%--<a href="javascript:;">--%>
                            <%--<i class="menu-icon fa fa-birthday-cake bg-red"></i>--%>

                            <%--<div class="menu-info">--%>
                                <%--<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>--%>

                                <%--<p>Will be 23 on April 24th</p>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<!-- /.control-sidebar-menu -->--%>

                <%--<!-- test upsource -->--%>
                <%--&lt;%&ndash;test upsource2&ndash;%&gt;--%>

                <%--<h3 class="control-sidebar-heading">Tasks Progress</h3>--%>
                <%--<ul class="control-sidebar-menu">--%>
                    <%--<li>--%>
                        <%--<a href="javascript:;">--%>
                            <%--<h4 class="control-sidebar-subheading">--%>
                                <%--Custom Template Design--%>
                                <%--<span class="pull-right-container">--%>
                    <%--<span class="label label-danger pull-right">70%</span>--%>
                  <%--</span>--%>
                            <%--</h4>--%>

                            <%--<div class="progress progress-xxs">--%>
                                <%--<div class="progress-bar progress-bar-danger" style="width: 70%"></div>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<!-- /.control-sidebar-menu -->--%>

            <%--</div>--%>
            <%--<!-- /.tab-pane -->--%>
            <%--<!-- Stats tab content -->--%>
            <%--<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>--%>
            <%--<!-- /.tab-pane -->--%>
            <%--<!-- Settings tab content -->--%>
            <%--<div class="tab-pane" id="control-sidebar-settings-tab">--%>
                <%--<form method="post">--%>
                    <%--<h3 class="control-sidebar-heading">General Settings</h3>--%>

                    <%--<div class="form-group">--%>
                        <%--<label class="control-sidebar-subheading">--%>
                            <%--Report panel usage--%>
                            <%--<input type="checkbox" class="pull-right" checked>--%>
                        <%--</label>--%>

                        <%--<p>--%>
                            <%--Some information about this general settings option--%>
                        <%--</p>--%>
                    <%--</div>--%>
                    <%--<!-- /.form-group -->--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<!-- /.tab-pane -->--%>
        <%--</div>--%>
    <%--</aside>--%>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <%--<div class="control-sidebar-bg"></div>--%>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/statics/dist/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>
