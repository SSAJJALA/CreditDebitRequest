<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 9/17/16
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>CDMR Search</title>

</head>
<body>

<form action="/search" class="single-underline">
    <table width="100%" border="0" cellspacing="10" class="single-underline">

        <tr style="height: 7px;"></tr>

        <tr style="height: 7px;">
            <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <select name="searchoptions">
                    <option value="volvo">Search By</option>
                    <option value="saab">Req ID</option>
                    <option value="fiat">Customer Name</option>
                    <option value="audi">Status</option>
                </select>
            </td>
            <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <select name="operands">
                    <option value="volvo">Operand</option>
                    <option value="saab">=</option>
                    <option value="fiat">!=</option>
                    <option value="audi">LIKE</option>
                </select>
            </td>
            <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <input type="text" name="searchTerm">
            </td>

        </tr>

    </table>

    <br><br><br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<input type="submit" value="Search">
</form>

<div class="container-fluid">
    <c:choose>
    <c:when test="${empty results}">
        <h2>No requisition found</h2>
    </c:when>
    <c:otherwise>
    <table width="100%" border="1" cellspacing="10" >

        <tr style="height: 7px;">
            <th>Req ID</th>
            <th>Invoice</th>
            <th>Inv Amnt $</th>
            <th>Customer No</th>
            <th>Customer Name</th>
            <th>Req Type</th>
            <th>Adj Amnt $</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${results}" var="searchResults">
            <tr style="height: 7px;">
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.requisitionID}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.invoiceNum}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.invAmnt}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.custNo}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.custName}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.reqType}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.adjAmnt}</td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.status}</td>

            </tr>
        </c:forEach>

    </table>
    </c:otherwise>
    </c:choose>

</div>

</body>
</html>
