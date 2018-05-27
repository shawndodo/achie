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
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">教学论文管理</a></li>
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
                                    <label for="leader">负责人</label>
                                    <input type="text"
                                           class="form-control"
                                           name="leader"
                                           id="leader"
                                           value="${researchProject.leader}"
                                           placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="name">项目名称</label>
                                    <input type="text"
                                           class="form-control"
                                           name="name"
                                           id="name"
                                           value="${researchProject.name}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>项目来源</label>
                                    <select class="form-control" name="projectType" id="projectType"
                                            >
                                        <option value="国家社科" selected="selected">国家社科</option>
                                        <option value="国家自然科学基金">国家自然科学基金</option>
                                        <option value="教育部人文社科">教育部人文社科</option>
                                        <option value="省科技项目">省科技项目</option>
                                        <option value="省市社科基金">省市社科基金</option>
                                        <option value="省教育厅社科项目">省教育厅社科项目</option>
                                        <option value="省教育厅自然科学项目">省教育厅自然科学项目</option>
                                        <option value="地市厅局等政府部门项目">地市厅局等政府部门项目</option>
                                        <option value="企事业单位委托项目">企事业单位委托项目</option>
                                        <option value="学校基金项目项目">学校基金项目项目</option>
                                        <option value="其他研究项目">其他研究项目</option>
                                        <option value="无依托项目研究成果">无依托项目研究成果</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="approvalNumber">批准号</label>
                                    <input type="text"
                                           class="form-control"
                                           name="approvalNumber"
                                           id="approvalNumber"
                                           value="${researchProject.approvalNumber}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>研究类别</label>
                                    <select class="form-control" name="researchCategory" id="researchCategory"
                                            >
                                        <option value="(社科类)基础研究" selected="selected">(社科类)基础研究</option>
                                        <option value="应用研究">应用研究</option>
                                        <option value="(自然科学类)基础研究">(自然科学类)基础研究</option>
                                        <option value="应用研究">应用研究</option>
                                        <option value="试验发展">试验发展</option>
                                        <option value="研究与发展成果应用">研究与发展成果应用</option>
                                        <option value="其他科技服务">其他科技服务</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="approvalFund">批准经费(单位万元)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="approvalFund"
                                           id="approvalFund"
                                           value="${researchProject.approvalFund}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="currentYearInMoney">本年度到账经费(单位万元)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="currentYearInMoney"
                                           id="currentYearInMoney"
                                           value="${researchProject.currentYearInMoney}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="currentYearOutMoney">本年度支出(单位万元)精确到千元</label>
                                    <input type="text"
                                           class="form-control"
                                           name="currentYearOutMoney"
                                           id="currentYearOutMoney"
                                           value="${researchProject.currentYearOutMoney}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="subjectCategory">学科门类(按一级学科目录填写)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="subjectCategory"
                                           id="subjectCategory"
                                           value="${researchProject.subjectCategory}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="organizationForm">组织形式(牵头单位/合作单位)</label>
                                    <input type="text"
                                           class="form-control"
                                           name="organizationForm"
                                           id="organizationForm"
                                           value="${researchProject.organizationForm}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="serveNationalEconomyIndustry">服务的国名经济行业</label>
                                    <input type="text"
                                           class="form-control"
                                           name="serveNationalEconomyIndustry"
                                           id="serveNationalEconomyIndustry"
                                           value="${researchProject.serveNationalEconomyIndustry}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label for="projectGoal">项目的社会经济目标</label>
                                    <input type="text"
                                           class="form-control"
                                           name="projectGoal"
                                           id="projectGoal"
                                           value="${researchProject.projectGoal}"
                                           placeholder="">
                                </div>

                                <div class="form-group">
                                    <label>项目状态</label>
                                    <select class="form-control" name="projectStatus" id="projectStatus"
                                            >
                                        <option value="在研" selected="selected">在研</option>
                                        <option value="结题">结题</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>备注</label>
                                    <textarea class="form-control"
                                              rows="3"
                                              name="remark"
                                              placeholder="请输入备注信息">${researchProject.remark}</textarea>
                                </div>
                                <div>
                                    <input type="hidden" name="id" value="${researchProject.id}">
                                </div>
                                <div>
                                    <input type="hidden" name="createdAt" value="${researchProject.createdAt}">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">上传教学论文</label>
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

        $("#projectType").val("${researchProject.projectType}");
        $("#researchCategory").val("${researchProject.researchCategory}");
        $("#projectStatus").val("${researchProject.projectStatus}");

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
