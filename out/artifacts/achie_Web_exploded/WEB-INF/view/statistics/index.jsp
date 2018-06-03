<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 上午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>成果管理系统 | 成果统计</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- 页面css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/css/paper/index.css">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/statics/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/dist/css/skins/_all-skins.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/bower_components/select2/dist/css/select2.min.css">

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
                成果统计
                <%--<small>advanced tables</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">科研成果</a></li>
                <li class="active">成果统计</li>
            </ol>
        </section>

        <%--查询框--%>
        <section class="search-box">
            <div class="box-body">
                <div class="row">
                    <div class="col-md-10">
                        <div class="search-query">
                            <div class="form-group">
                                <label>教师姓名</label>
                                <input type="text" class="form-control" id="teacherName" placeholder="请输入..">
                            </div>

                            <div class="form-group">
                                <label>提交时间</label>

                                <div style="display: flex">
                                    <div class="input-group date" style="width: 11rem;margin-right: 10px;">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" name="startDate"
                                               id="startDate">
                                    </div>
                                    <div class="input-group date" style="width: 11rem;">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" name="endDate"
                                               id="endDate">
                                    </div>
                                </div>
                            </div>

                            <%--<div class="form-group">--%>
                                <%--<label>论文类型</label>--%>
                                <%--<select class="form-control select2" style="width: 100%;">--%>
                                    <%--<option selected="selected">期刊论文</option>--%>
                                    <%--<option>会议论文集</option>--%>
                                    <%--<option>报纸</option>--%>
                                    <%--<option>学位论文</option>--%>
                                <%--</select>--%>
                            <%--</div>--%>

                        </div>
                        <div>
                            <div class="col-xs-2">
                                <button type="button" class="btn btn-block btn-primary" id="searchButton">
                                    查询
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Main content -->
        <section class="content" id="searchContent">
            <div class="row">
                <%--<div class="col-xs-2">--%>
                    <%--<button type="button" class="btn btn-block btn-primary" onclick="window.location.href='add'">--%>
                        <%--新增论文--%>
                    <%--</button>--%>
                <%--</div>--%>
                <div class="col-xs-12">
                    <div class="box">
                        <%--<div class="box-header">--%>
                        <%--<h3 class="box-title">Hover Data Table</h3>--%>
                        <%--</div>--%>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>教师姓名</th>
                                    <th>科研成果数</th>
                                    <th>专利</th>
                                    <th>软件著作权</th>
                                    <th>论文</th>
                                    <th>参与学术会议</th>
                                    <th>获奖成果</th>
                                    <th>科研项目</th>
                                    <th>教学成果数</th>
                                    <th>著作</th>
                                    <th>教学奖项</th>
                                    <th>指导学生项目</th>
                                    <th>教学论文</th>
                                    <th>主持教学改革研究项目</th>
                                </tr>
                                </thead>
                                <tbody id="table_content">
                                <c:forEach items="${list}" var="lis" begin="0" end="9" step="1">
                                    <tr>
                                        <td>${lis.userName}</td>
                                        <td>${lis.teachCount}</td>
                                        <td>${lis.writingCount}</td>
                                        <td>${lis.teachAwardCount}</td>
                                        <td>${lis.studentProjectCount}</td>
                                        <td>${lis.teachPaperCount}</td>
                                        <td>${lis.teachReformResearchProjectCount}</td>
                                        <td>${lis.researchCount}</td>
                                        <td>${lis.patentCount}</td>
                                        <td>${lis.softwareCopyrightCount}</td>
                                        <td>${lis.paperCount}</td>
                                        <td>${lis.joinAcademicConferenceCount}</td>
                                        <td>${lis.researchAwardCount}</td>
                                        <td>${lis.researchProjectCount}</td>
                                        <%--<td>${fn:substring(paper.createdAt, 0, 19)}</td>--%>
                                        <%--<td>${fn:substring(paper.updatedAt, 0, 19)}</td>--%>
                                        <%--<td>--%>
                                            <%--<div>--%>
                                                <%--<a href="/achie/paper/show?paperId=${paper.id}">--%>
                                                    <%--<i></i>--%>
                                                    <%--查看详情--%>
                                                <%--</a>--%>
                                            <%--</div>--%>
                                        <%--</td>--%>
                                    </tr>
                                </c:forEach>

                                </tbody>
                                <%--<tfoot>--%>
                                <%--<tr>--%>
                                    <%--<th>专利名称</th>--%>
                                    <%--<th>专利类型</th>--%>
                                    <%--<th>专利状态</th>--%>
                                    <%--<th>专利编号</th>--%>
                                    <%--<th>获得时间</th>--%>
                                    <%--<th>申请编号</th>--%>
                                    <%--<th>申请时间</th>--%>
                                    <%--<th>本人排名</th>--%>
                                    <%--<th>备注</th>--%>
                                    <%--<th>操作</th>--%>
                                <%--</tr>--%>
                                <%--</tfoot>--%>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>

    <!-- Main Footer -->
    <%@include file="../share/footer.jsp" %>


</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="<%=request.getContextPath()%>/statics/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/statics/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="<%=request.getContextPath()%>/statics/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=request.getContextPath()%>/statics/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/statics/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/statics/dist/js/demo.js"></script>
<!-- Select2 -->
<script src="<%=request.getContextPath()%>/statics/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- bootstrap datepicker -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- page script -->
<script src="<%=request.getContextPath()%>/statics/js/paper/index.js"></script>
<script>
    $(function() {

        $('#startDate').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })
        $('#endDate').datepicker({
            autoclose: true,
            format: 'yyyy-mm-dd'
        })

        $("#searchButton").click(function() {
            var startDate = $("#startDate").val();
            var endDate = $("#endDate").val();
            var createdAt = "";
            if(startDate != "" && endDate != ""){
                createdAt = startDate + " " + endDate
            }else if(startDate == "" && endDate != "") {
                createdAt = " " + endDate
            }else if(startDate != "" && endDate == "") {
                createdAt = startDate + " "
            }
            var searchParams = {
                "like_user.realName": $("#teacherName").val(),
                "between_teacher_achie.createdAt": createdAt
            };
            $.ajax({
                type: "POST",
                url: "search",
                data : searchParams,
                dataType: "text", //return dataType: text or json
                // contentType:'application/json;charset=UTF-8',
                success: function(json) {
                    // alert(json.strResult)
                    $('#table_content').html(json);
                    // var obj = $.parseJSON(json); // if dataType: text then change dataType to json
                    // alert(obj.strResult);
                    // alert("success");
                },
                error: function(json) {
                    alert("json=" + json);
                    return false;
                }
            });
        });

    });

</script>

</body>
</html>
