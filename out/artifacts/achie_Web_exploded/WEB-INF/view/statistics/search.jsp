<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/5/31
  Time: 上午1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<section class="content" id="searchContent">
    <div class="row">
        <p>${list}</p>
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
                        <tbody>
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
