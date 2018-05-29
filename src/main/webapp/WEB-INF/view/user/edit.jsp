<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 上午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>成果管理系统 | 编辑教学论文</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/AdminLTE.min.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/skins/_all-skins.min.css">

    <%@include file="../share/header_logo.jsp" %>

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

    <%--顶部--%>
    <%@include file="../share/header.jsp" %>
    <%--侧边栏--%>
    <%@include file="../share/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                编辑教学论文
                <%--<small>Preview</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/achie/user/show">教学论文管理</a></li>
                <li class="active">编辑教学论文</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- left column -->
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">信息填写</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form action="update" method="post" role="form" enctype="multipart/form-data">
                            <div class="box-body">
                                <%--<%@include file="_paper_form.jsp" %>--%>
                                <div class="form-group">
                                    <label for="userName">登录名</label>
                                    <input type="text"
                                           class="form-control"
                                           name="userName"
                                           id="userName"
                                           value="${user.userName}"
                                           placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="realName">真实姓名</label>
                                    <input type="text"
                                           class="form-control"
                                           name="realName"
                                           id="realName"
                                           value="${user.realName}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="age">年龄</label>
                                    <input type="text"
                                           class="form-control"
                                           name="age"
                                           id="age"
                                           value="${user.age}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="text"
                                           class="form-control"
                                           name="password"
                                           id="password"
                                           value="${user.password}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="job">职务</label>
                                    <input type="text"
                                           class="form-control"
                                           name="job"
                                           id="job"
                                           value="${user.job}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="position">职称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="position"
                                           id="position"
                                           value="${user.position}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>入职时间</label>
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" name="startWorkingTime"
                                               value="${user.startWorkingTime}"
                                               id="startWorkingTime">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>当前状态</label>
                                    <select class="form-control" id="status" name="status">
                                        <option value="在职">在职</option>
                                        <option value="离职">离职</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control"
                                              rows="3"
                                              name="remark"
                                              placeholder="请输入备注信息">${user.remark}</textarea>
                                </div>
                                <div>
                                    <input type="hidden" name="id" value="${user.id}">
                                </div>
                                <div>
                                    <input type="hidden" name="createdAt" value="${user.createdAt}">
                                </div>
                                <%--<div class="form-group">--%>
                                    <%--<label for="exampleInputFile">上传教学论文</label>--%>
                                    <%--<input type="file" id="exampleInputFile" name="file">--%>
                                    <%--<div class="showFile">--%>
                                        <%--<span>"${attachment.fileName}"</span>--%>
                                        <%--<button type="button" class="btn btn-block btn-default btn-xs"--%>
                                                <%--style="width:40px;display:inline;">下载--%>
                                        <%--</button>--%>
                                    <%--</div>--%>
                                    <%--&lt;%&ndash;<p class="help-block">Example block-level help text here.</p>&ndash;%&gt;--%>
                                <%--</div>--%>
                                <%--<div>--%>
                                <%--<input type="hidden" name="patentId" value="${patent.id}">--%>
                                <%--</div>--%>
                                <%--<div class="checkbox">--%>
                                <%--<label>--%>
                                <%--<input type="checkbox"> Check me out--%>
                                <%--</label>--%>
                                <%--</div>--%>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">确认</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->


                    <!-- /.box-body -->
                    <!-- /.box -->

                </div>
            </div>
        </section>

    </div>
    <!-- Main Footer -->
    <%@include file="../share/footer.jsp" %>


</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="<%=request.getContextPath()%>/statics/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/statics/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/statics/dist/js/demo.js"></script>
<!-- bootstrap datepicker -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Page script -->
<script>
    $(function () {

        $('#startWorkingTime').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })

    })

    $('#exampleInputFile').bind('input exampleInputFile', function () {
        var fileValue = $(this).val();
        if (fileValue != "" || fileValue != null || fileValue != undefined) {
            $('.showFile').hide();
        }
    });

</script>
</body>
</html>
