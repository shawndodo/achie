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
<c:forEach items="${joinAcademicConferenceList}" var="joinAcademicConference" begin="0" end="9" step="1">
    <tr>
        <td>${joinAcademicConference.name}</td>
        <td>${joinAcademicConference.location}</td>
        <td>${joinAcademicConference.level}</td>
        <td>${joinAcademicConference.paperName}</td>
        <td>${joinAcademicConference.isInviteReport}</td>
        <td>${joinAcademicConference.subjectCategory}</td>
        <td>${joinAcademicConference.remark}</td>
        <td>${fn:substring(joinAcademicConference.createdAt, 0, 19)}</td>
        <td>${fn:substring(joinAcademicConference.updatedAt, 0, 19)}</td>
        <td>
            <div>
                <a href="/achie/joinAcademicConference/show?joinAcademicConferenceId=${joinAcademicConference.id}">
                    <i></i>
                    查看详情
                </a>
            </div>
        </td>
    </tr>
</c:forEach>



