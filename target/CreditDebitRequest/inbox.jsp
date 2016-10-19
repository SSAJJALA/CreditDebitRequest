<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/17/16
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

<div class="container-fluid" style="height: 600px; width: 100%; border:1px solid black;">

    <br> <br>
    <c:if test="${not empty inbox}">
        <table id = "datatable" width="90%" border="1" align = "center">
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
                    <td style="text-align: center;" rowspan="1" colspan="1">${inboxResults.taskID}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${inboxResults.updatedDate}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${inboxResults.application}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">Approval Required</td>
                    <%-- <c:set var="info" value="Req ID:${inboxResults.requisitionID}|Customer:${inboxResults.customerName}|Adj Amnt:${{inboxResults.adjAmnt}}" />
                    <c:set var="info" value="${fn:join('Req ID:', '${inboxResults.requisitionID}')}" /> --%>
                    <c:set var = "ReqID" value="${inboxResults.requisitionID}" />
                    <c:set var = "CustName" value="${inboxResults.customerName}" />
                    <c:set var = "AdjAmnt" value="${inboxResults.adjAmnt}" />
                    <%
                        String info = "ReqID:" + pageContext.getAttribute("ReqID").toString() + "|Customer:" + pageContext.getAttribute("CustName") + "|Adj Amnt:" + pageContext.getAttribute("AdjAmnt").toString();
                    %>


                    <td style="text-align: center;" rowspan="1" colspan="1"><%= info %>></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
    <br>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
