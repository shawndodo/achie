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
<c:forEach items="${patentList}" var="patent" begin="0" end="9" step="1">
    <tr>
        <td>${patent.patentName}</td>
        <td>${patent.patentType}</td>
        <td>${patent.patentStatus}</td>
        <td>${patent.patentCode}</td>
        <td>${patent.getPatentDate}</td>
        <td>${patent.applyCode}</td>
        <td>${patent.applyDate}</td>
        <td>${patent.selfRank}</td>
        <td>${patent.remark}</td>
        <td>${fn:substring(patent.createdAt, 0, 19)}</td>
        <td>${fn:substring(patent.updatedAt, 0, 19)}</td>
        <td>
            <div>
                <a href="/achie/patent/show?patentId=${patent.id}">
                    <i></i>
                    查看详情
                </a>
            </div>
        </td>
    </tr>
</c:forEach>



