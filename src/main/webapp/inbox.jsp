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
<div id="wrapper" class="container">

<table width="100%" border="0" cellspacing="10" >
    <tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Task Inbox</b></h2></td></tr>
    <tr style="height: 7px;"></tr>
</table>
    <br><br>

    <div class="container-fluid" style="height: 1000px; width: 90%; border:1px solid black;">

        <table width="75%" border="1" cellspacing="10" >

            <tr style="height: 7px;">
                <th style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Task ID</th>
                <th style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Updated Date</th>
                <th style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Type</th>
                <th style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Action Required</th>
                <th style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Info</th>
            </tr>

            <c:forEach items="${inbox}" var="inboxResults">
                <tr style="height: 7px;">
                    <td style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">${inboxResults.taskID}</td>
                    <td style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">${inboxResults.updatedDate}</td>
                    <td style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">${inboxResults.application}</td>
                    <td style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Approval Required</td>
                    <td style="text-align: center;" width="10%" height="12" nowrap="nowrap" rowspan="1" colspan="1">Req ID: ${inboxResults.requisitionID}|Customer: ${inboxResults.requisitionID}|Adj $: ${inboxResults.requisitionID} </td>
                </tr>
            </c:forEach>

        </table>

</div>
    <br><br><br>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
