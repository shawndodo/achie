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
    <title>成果管理系统 | 主持教学改革研究项目管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- 页面css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/statics/css/teachReformResearchProject/index.css">
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
                主持教学改革研究项目管理
                <%--<small>advanced tables</small>--%>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/achie/home/index"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">教学成果</a></li>
                <li class="active">主持教学改革研究项目管理</li>
            </ol>
        </section>

        <%--查询框--%>
        <section class="search-box">
            <div class="box-body">
                <div class="row">
                    <div class="col-md-10">
                        <div class="search-query">
                            <div class="form-group">
                                <label>教师名称</label>
                                <input type="text" class="form-control" placeholder="请输入.." id="teacherName">
                            </div>

                            <div class="form-group">
                                <label>项目编号</label>
                                <input type="text" class="form-control" placeholder="请输入.." id="code">
                            </div>

                            <div class="form-group">
                                <label>项目名称</label>
                                <input type="text" class="form-control" placeholder="请输入.." id="name">
                            </div>

                            <div class="form-group">
                                <label>级别</label>
                                <select class="form-control select2" style="width: 100%;" id="level">
                                    <option selected="selected">全部</option>
                                    <option>国家级</option>
                                    <option>省部级</option>
                                    <option>校级</option>
                                    <option>其他</option>
                                </select>
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
        <section class="content">
            <div class="row">
                <div class="col-xs-2">
                    <button type="button" class="btn btn-block btn-primary" onclick="window.location.href='add'" style="width: 200px;">
                        新增主持教学改革研究项目
                    </button>
                </div>
                <div class="col-xs-12">
                    <div class="box">
                        <%--<div class="box-header">--%>
                        <%--<h3 class="box-title">Hover Data Table</h3>--%>
                        <%--</div>--%>
                        <!-- /.box-header -->
                        <div class="box-body" id="table_content">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>教师姓名</th>
                                    <th>项目编号</th>
                                    <th>项目名称</th>
                                    <th>级别</th>
                                    <th>主持人</th>
                                    <th>年度</th>
                                    <th>备注</th>
                                    <th>提交时间</th>
                                    <th>修改时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${teachReformResearchProjectList}" var="teachReformResearchProject" begin="0" end="9" step="1">
                                    <tr>
                                        <td>${teachReformResearchProject.teacherName}</td>
                                        <td>${teachReformResearchProject.code}</td>
                                        <td>${teachReformResearchProject.name}</td>
                                        <td>${teachReformResearchProject.level}</td>
                                        <td>${teachReformResearchProject.leader}</td>
                                        <td>${teachReformResearchProject.year}</td>
                                        <td>${teachReformResearchProject.remark}</td>
                                        <td>${fn:substring(teachReformResearchProject.createdAt, 0, 19)}</td>
                                        <td>${fn:substring(teachReformResearchProject.updatedAt, 0, 19)}</td>
                                        <td>
                                            <div>
                                                <a href="/achie/teachReformResearchProject/show?teachReformResearchProjectId=${teachReformResearchProject.id}">
                                                    <i></i>
                                                    查看详情
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                                <%--<tfoot>--%>
                                <%--<tr>--%>
                                    <%--<th>获奖成果名称</th>--%>
                                    <%--<th>获奖成果类型</th>--%>
                                    <%--<th>获奖成果状态</th>--%>
                                    <%--<th>获奖成果编号</th>--%>
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
<!-- page script -->
<script src="<%=request.getContextPath()%>/statics/js/teachReformResearchProject/index.js"></script>

<!-- bootstrap datepicker -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

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

        var searchParams = {};

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
            var level = $('#level').val();
            if(level == "全部"){
                level = ""
            }
            searchParams = {
                "like_user.realName": $("#teacherName").val(),
                "like_teach_reform_research_project.code": $("#code").val(),
                "like_teach_reform_research_project.name": $("#name").val(),
                "teach_reform_research_project.level": level,
                "between_teach_reform_research_project.createdAt": createdAt
            };
            $.ajax({
                type: "POST",
                url: "admin_search",
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
