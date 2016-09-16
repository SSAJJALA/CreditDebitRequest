<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/16/16
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
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

<br/>
<table width="100%" border="0" cellspacing="10" class="single-underline">
    <tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to the CDMR System</b></h2></td></tr>
    <tr style="height: 7px;"></tr>

    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left" >
            <p>&nbsp;</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="../CDMR/createCDMR">Create Credit Debit Memo Request</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to create a new credit/debit memo request</p>
            <p>&nbsp;</p>
        </td>
    </tr>

</table>

<table width="100%" border="0" cellspacing="10" class="single-underline">

    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;</p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="javascript:window.location=inboxUrl;">Requests Inbox </a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to manage requests awaiting user review and/or approval</p>
        </td>
    </tr>


    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="../CDMR/cdmrSearch">Requests Search</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to search for specific credit debit memo requests</p>
        </td>
    </tr>
</table>

<table width="100%" border="0" cellspacing="10" class="single-underline" >
    <tr>
        <td width="32%" height="12" nowrap="nowrap" align="left">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="homePage" href="../CDMR/cdmrSearch">Administration Screen</a></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Link to manage the approvers</p>
        </td>
    </tr>
</table>

</body>
</html>
