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
    <title>成果管理系统 | 编辑论文</title>
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
                编辑论文
                <%--<small>Preview</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/achie/paper/index">论文管理</a></li>
                <li class="active">编辑论文</li>
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
                                    <label for="paperName">论文名称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="paperName"
                                           id="paperName"
                                           value="${paper.paperName}"
                                           placeholder="请填写标题">
                                </div>
                                <div class="form-group">
                                    <label>论文类型</label>
                                    <select class="form-control" name="paperType" id="paperType">
                                        <option value="期刊论文" selected="selected">期刊论文</option>
                                        <option value="会议论文集">会议论文集</option>
                                        <option value="报纸">报纸</option>
                                        <option value="学位论文">学位论文</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="selfRank">本人排名</label>
                                    <input type="text"
                                           class="form-control"
                                           name="selfRank"
                                           id="selfRank"
                                           value="${paper.selfRank}"
                                           placeholder="1">
                                </div>
                                <div class="form-group">
                                    <label>是否独著</label>
                                    <select class="form-control" name="isAlone" id="isAlone">
                                        <option value="是" selected="selected">是</option>
                                        <option value="否">否</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>通讯作者</label>
                                    <select class="form-control" name="messageAuthor" id="messageAuthor">
                                        <option value="是" selected="selected">是</option>
                                        <option value="否">否</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="periodicalName">刊物名称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="periodicalName"
                                           id="periodicalName"
                                           value="${paper.periodicalName}"
                                           placeholder="如：装饰">
                                </div>
                                <div class="form-group">
                                    <label for="inclusionSearch">收录检索(刊物级别)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="inclusionSearch"
                                           id="inclusionSearch"
                                           value="${paper.inclusionSearch}"
                                           placeholder="请输入刊物级别">
                                </div>
                                <div class="form-group">
                                    <label>发表时间</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text"
                                               class="form-control pull-right"
                                               name="publishTime"
                                               value="${paper.publishTime}"
                                               id="publishTime">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="keyWord">关键词</label>
                                    <input type="text"
                                           class="form-control"
                                           name="keyWord"
                                           id="keyWord"
                                           value="${paper.keyWord}"
                                           placeholder="如：机器学习，生物化学">
                                </div>
                                <div class="form-group">
                                    <label for="edition">卷(期、版次)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="edition"
                                           id="edition"
                                           value="${paper.edition}"
                                           placeholder="格式为：卷(期)，如12(04)">
                                </div>
                                <div class="form-group">
                                    <label for="edition">起止页码</label>
                                    <input type="text"
                                           class="form-control"
                                           name="startEndPageNum"
                                           id="startEndPageNum"
                                           value="${paper.startEndPageNum}"
                                           placeholder="如：21~24">
                                </div>

                                <div class="form-group">
                                    <label for="doiNum">DOI号</label>
                                    <input type="text"
                                           class="form-control"
                                           name="doiNum"
                                           id="doiNum"
                                           value="${paper.doiNum}"
                                           placeholder="请输入DOI号">
                                </div>

                                <div class="form-group">
                                    <label for="issnNum">ISSN号</label>
                                    <input type="text"
                                           class="form-control"
                                           name="issnNum"
                                           id="issnNum"
                                           value="${paper.issnNum}"
                                           placeholder="请输入ISSN号">
                                </div>

                                <div class="form-group">
                                    <label for="cnNum">CN号</label>
                                    <input type="text"
                                           class="form-control"
                                           name="cnNum"
                                           id="cnNum"
                                           value="${paper.cnNum}"
                                           placeholder="请输入CN号">
                                </div>

                                <div class="form-group">
                                    <label for="impactFactor">影响因子</label>
                                    <input type="text"
                                           class="form-control"
                                           name="impactFactor"
                                           id="impactFactor"
                                           value="${paper.impactFactor}"
                                           placeholder="如：3.102">
                                </div>

                                <div class="form-group">
                                    <label for="quotesNum">引用次数</label>
                                    <input type="text"
                                           class="form-control"
                                           name="quotesNum"
                                           id="quotesNum"
                                           value="${paper.quotesNum}"
                                           placeholder="请输入论文引用次数">
                                </div>

                                <div class="form-group">
                                    <label for="relatedCourseName">关联课题</label>
                                    <input type="text"
                                           class="form-control"
                                           name="relatedCourseName"
                                           id="relatedCourseName"
                                           value="${paper.relatedCourseName}"
                                           placeholder="请输入关联课题">
                                </div>
                                <!-- textarea -->
                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control" rows="3" name="remark"
                                              placeholder="请输入备注信息">${paper.remark}</textarea>
                                </div>
                                <div>
                                    <input type="hidden" name="id" value="${paper.id}">
                                </div>
                                <div>
                                    <input type="hidden" name="createdAt" value="${paper.createdAt}">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">上传论文</label>
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
                                <%--<input type="hidden" name="paperId" value="${paper.id}">--%>
                                <%--</div>--%>
                            </div>
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
        $('#publishTime').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })

        $("#paperType").val("${paper.paperType}");
        $("#isAlone").val("${paper.isAlone}");
        $("#messageAuthor").val("${paper.messageAuthor}");

    })

    $('#exampleInputFile').bind('input exampleInputFile', function() {
        var fileValue = $(this).val();
        if(fileValue != "" || fileValue != null || fileValue != undefined){
            $('.showFile').hide();
        }
    });

</script>
</body>
</html>
