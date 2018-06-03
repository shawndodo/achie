<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/5/31
  Time: 上午1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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



