<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/5/31
  Time: 上午1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="example2" class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>教师姓名</th>
        <th>著作权名称</th>
        <th>证书号</th>
        <th>本人排名</th>
        <th>开发完成时间</th>
        <th>获得时间</th>
        <th>著作权类型</th>
        <th>著作权人</th>
        <th>备注</th>
        <th>提交时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${softwareCopyrightList}" var="softwareCopyright" begin="0" end="${softwareCopyrightList.size()}" step="1">
        <tr>
            <td>${softwareCopyright.teacherName}</td>
            <td>${softwareCopyright.copyrightName}</td>
            <td>${softwareCopyright.certificateNum}</td>
            <td>${softwareCopyright.selfRank}</td>
            <td>${softwareCopyright.getDate}</td>
            <td>${softwareCopyright.developFinishDate}</td>
            <td>${softwareCopyright.copyrightType}</td>
            <td>${softwareCopyright.copyrightPerson}</td>
            <td>${softwareCopyright.remark}</td>
            <td>${fn:substring(softwareCopyright.createdAt, 0, 19)}</td>
            <td>${fn:substring(softwareCopyright.updatedAt, 0, 19)}</td>
            <td>
                <div>
                    <a href="/achie/softwareCopyright/show?softwareCopyrightId=${softwareCopyright.id}">
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
<!-- bootstrap datepicker -->
<script src="<%=request.getContextPath()%>/statics/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- page script -->
<script src="<%=request.getContextPath()%>/statics/js/softwareCopyright/index.js"></script>

