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
    <title>成果管理系统 | 查看参加学术会议</title>
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
                查看参加学术会议
                <%--<small>Preview</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/achie/joinAcademicConference/index">参加学术会议管理</a></li>
                <li class="active">查看参加学术会议</li>
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
                            <h3 class="box-title">信息查看</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form action="edit" method="get" role="form">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="name">学术会议名称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="name"
                                           id="name"
                                           value="${joinAcademicConference.name}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="location">会议地点</label>
                                    <input type="text"
                                           class="form-control"
                                           name="location"
                                           id="location"
                                           value="${joinAcademicConference.location}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>会议等级</label>
                                    <select class="form-control select2" style="width: 100%;" id="level" name="level" disabled="disabled">
                                        <option value="国际" selected="selected">国际</option>
                                        <option value="国家">国家</option>
                                        <option value="省市">省市</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="participant">参加人</label>
                                    <input type="text"
                                           class="form-control"
                                           name="participant"
                                           id="participant"
                                           value="${joinAcademicConference.participant}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="title">职称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="title"
                                           id="title"
                                           value="${joinAcademicConference.title}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="paperName">提交论文</label>
                                    <input type="text"
                                           class="form-control"
                                           name="paperName"
                                           id="paperName"
                                           value="${joinAcademicConference.paperName}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>是否独著</label>
                                    <select class="form-control select2" style="width: 100%;" id="isInviteReport" name="isInviteReport" disabled="disabled">
                                        <option value="是" selected="selected">是</option>
                                        <option value="否">否</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="subjectCategory">所属学科</label>
                                    <input type="text"
                                           class="form-control"
                                           name="subjectCategory"
                                           id="subjectCategory"
                                           value="${joinAcademicConference.subjectCategory}"
                                           disabled="disabled"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>提交时间</label>
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text"
                                               class="form-control pull-right"
                                               name="submitDate"
                                               value="${joinAcademicConference.submitDate}"
                                               disabled="disabled"
                                               id="submitDate">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control"
                                              rows="3"
                                              name="remark"
                                              disabled="disabled"
                                              placeholder="请输入备注信息">${joinAcademicConference.remark}</textarea>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputFile">上传附件</label>
                                    <input id="exampleInputFile" name="file" disabled="disabled">
                                    <div class="showFile">
                                        <span>"${attachment.fileName}"</span>
                                        <button type="button" class="btn btn-block btn-default btn-xs"
                                                style="width:40px;display:inline;">
                                            <a href="${attachment.attachmentUrl}" download="" target="_blank">下载</a>
                                        </button>
                                    </div>
                                    <%--<p class="help-block">Example block-level help text here.</p>--%>
                                </div>
                                <div>
                                    <input type="hidden" name="joinAcademicConferenceId" value="${joinAcademicConference.id}">
                                </div>
                                <%--<div class="checkbox">--%>
                                <%--<label>--%>
                                <%--<input type="checkbox"> Check me out--%>
                                <%--</label>--%>
                                <%--</div>--%>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">编辑</button>
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

        $('#submitDate').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })

        $("#level").val("${joinAcademicConference.level}");
        $("#isInviteReport").val("${joinAcademicConference.isInviteReport}");

        $("#exampleInputFile").hide();

    })
</script>
</body>
</html>
