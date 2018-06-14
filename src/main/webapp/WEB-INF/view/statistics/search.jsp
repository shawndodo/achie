<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/5/31
  Time: 上午1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <c:forEach items="${list}" var="lis" begin="0" end="${list.size()}" step="1">
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

