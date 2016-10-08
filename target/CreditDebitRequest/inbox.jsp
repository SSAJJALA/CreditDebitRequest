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
<%@include file="header.jsp"%>

<table width="100%" border="0" cellspacing="10" >
    <tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Task Inbox</b></h2></td></tr>
    <tr style="height: 7px;"></tr>
</table>

<div class="container-fluid" style="height: 800px; width: 100%; border:1px solid black;">

    <br> <br>

    <table id = "datatable" style="display:none" class="t-table" width="90%" border="1" align = "center">
        <thead>
        <tr>
            <th style="text-align: center;" rowspan="1" colspan="1">Task ID</th>
            <th style="text-align: center;" rowspan="1" colspan="1">Updated Date</th>
            <th style="text-align: center;" rowspan="1" colspan="1">Type</th>
            <th style="text-align: center;" rowspan="1" colspan="1">Action Required</th>
            <th style="text-align: center;" rowspan="1" colspan="1">Information</th>
        </tr>
        </thead>
        <c:forEach items="${inbox}" var="inboxResults">
            <tr >
                <td>${inboxResults.taskID}</td>
                <td>${inboxResults.updatedDate}</td>
                <td>${inboxResults.application}</td>
                <td>Approval Required</td>
                <td>${inboxResults.info} </td>
            </tr>
        </c:forEach>
    </table>

</div>
    <br>
</div>
<br>
<%@include file="footer.jsp"%>
</body>
</html>
