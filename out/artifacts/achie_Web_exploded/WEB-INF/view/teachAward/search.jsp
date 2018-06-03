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
<c:forEach items="${teachAwardList}" var="teachAward" begin="0" end="9" step="1">
    <tr>
        <td>${teachAward.awardName}</td>
        <td>${teachAward.selfRank}</td>
        <td>${teachAward.level}</td>
        <td>${teachAward.awardDepartment}</td>
        <td>${teachAward.awardDate}</td>
        <td>${teachAward.remark}</td>
        <td>${fn:substring(teachAward.createdAt, 0, 19)}</td>
        <td>${fn:substring(teachAward.updatedAt, 0, 19)}</td>
        <td>
            <div>
                <a href="/achie/teachAward/show?teachAwardId=${teachAward.id}">
                    <i></i>
                    查看详情
                </a>
            </div>
        </td>
    </tr>
</c:forEach>



