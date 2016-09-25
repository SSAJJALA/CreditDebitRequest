<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/17/16
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My Inbox</title>

</head>

<body>
<div class="container-fluid">
<table width="100%" border="0" cellspacing="10" >
    <tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Task Inbox</b></h2></td></tr>
    <tr style="height: 7px;"></tr>
</table>
</div>
<div class="container-fluid">
    <c:choose>
        <c:when test="${empty inbox}">
            <h2>No tasks found</h2>
        </c:when>
        <c:otherwise>
            <table width="100%" border="1" cellspacing="10" >

                <tr style="height: 7px;">
                    <th>Task ID</th>
                    <th>Updated Date</th>
                    <th>Type</th>
                    <th>Action Required</th>
                    <th>Info</th>
                </tr>
                <c:forEach items="${inbox}" var="inboxResults">
                    <tr style="height: 7px;">
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${inboxResults.taskID}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${inboxResults.updatedDate}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${inboxResults.application}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">Approval Required/td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">Req ID: ${inboxResults.requisitionID}|Customer: ${inboxResults.requisitionID}|Adj $: ${inboxResults.requisitionID}</td>
                    </tr>
                </c:forEach>

            </table>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
