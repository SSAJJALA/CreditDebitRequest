<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/16/16
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Main Menu</title>
    <script type="text/javascript">
        function show() { document.getElementById('searchByName').style.display = 'block'; }
        function hide() { document.getElementById('searchByName').style.display = 'none'; }
    </script>
</head>
<body>
<div id="mainContainer">
<%@include file="header.jsp"%>
<br/>

<table width="100%" border="0" cellspacing="10" class="single-underline">
    <tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to the CDMR System</b></h2></td></tr>
    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left" >
            <p>&nbsp;</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="${pageContext.request.contextPath}/toCreate">Create Credit Debit Memo Request</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to create a new credit/debit memo request</p>
        </td>
    </tr>
    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="${pageContext.request.contextPath}/inboxServlet">Requests Inbox </a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to manage requests awaiting user review and/or approval</p>
        </td>
    </tr>
    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="${pageContext.request.contextPath}/toSearch">Requests Search</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to search for specific credit debit memo requests</p>
        </td>
    </tr>


</table>


<table width="100%" border="0" cellspacing="10" class="single-underline" >
    <br><br>
    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="${pageContext.request.contextPath}/toAdmin">Administration Screen</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to manage the approvers</p>
        </td>
    </tr>
</table>

</div>
<br>
<br>
<br>
<%@include file="footer.jsp"%>
</body>

</html>
