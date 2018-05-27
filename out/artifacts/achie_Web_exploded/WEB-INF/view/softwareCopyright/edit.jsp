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
    <title>成果管理系统 | 编辑软件著作权</title>
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
                编辑软件著作权
                <%--<small>Preview</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">软件著作权管理</a></li>
                <li class="active">编辑软件著作权</li>
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
                                    <label for="copyrightName">著作权名称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="copyrightName"
                                           id="copyrightName"
                                           value="${softwareCopyright.copyrightName}"
                                           placeholder="请填写标题">
                                </div>
                                <div class="form-group">
                                    <label for="certificateNum">证书号</label>
                                    <input type="text"
                                           class="form-control"
                                           name="certificateNum"
                                           id="certificateNum"
                                           value="${softwareCopyright.certificateNum}"
                                           placeholder="请填写证书右上角的[软著登字xxx]">
                                </div>
                                <div class="form-group">
                                    <label for="selfRank">本人排名</label>
                                    <input type="text"
                                           class="form-control"
                                           name="selfRank"
                                           id="selfRank"
                                           value="${softwareCopyright.selfRank}"
                                           placeholder="">
                                </div>
                                <div class="form-group">
                                    <label>开发完成时间</label>
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text"
                                               class="form-control pull-right"
                                               name="developFinishDate"
                                               value="${softwareCopyright.developFinishDate}"
                                               id="developFinishDate">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>获得时间</label>
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text"
                                               class="form-control pull-right"
                                               name="getDate"
                                               value="${softwareCopyright.getDate}"
                                               id="getDate">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>著作权类型</label>
                                    <select class="form-control"
                                            name="copyrightType"
                                            id="copyrightType">
                                        <option value="软件制品" selected="selected">软件制品</option>
                                        <option value="音像制品">音像制品</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="copyrightPerson">著作权人</label>
                                    <input type="text"
                                           class="form-control"
                                           name="copyrightPerson"
                                           id="copyrightPerson"
                                           value="${softwareCopyright.copyrightPerson}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="relatedCourseName">关联课题</label>
                                    <input type="text"
                                           class="form-control"
                                           name="relatedCourseName"
                                           id="relatedCourseName"
                                           value="${softwareCopyright.relatedCourseName}"
                                           placeholder="">
                                </div>


                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control" rows="3" name="remark"
                                              placeholder="请输入备注信息">${softwareCopyright.remark}</textarea>
                                </div>
                                <div>
                                    <input type="hidden" name="id" value="${softwareCopyright.id}">
                                </div>
                                <div>
                                    <input type="hidden" name="createdAt" value="${softwareCopyright.createdAt}">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">上传软件著作权</label>
                                    <input type="file" id="exampleInputFile" name="file">
                                    <div class="showFile">
                                        <span>"${attachment.fileName}"</span>
                                        <button type="button" class="btn btn-block btn-default btn-xs"
                                                style="width:40px;display:inline;">下载
                                        </button>
                                    </div>
                                    <%--<p class="help-block">Example block-level help text here.</p>--%>
                                </div>
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
        //Date picker
        $('#getDate').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })
        $('#developFinishDate').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })

        $("#copyrightType").val("${softwareCopyright.copyrightType}");

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
