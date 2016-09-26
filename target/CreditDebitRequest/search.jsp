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
<div id="wrapper" class="container">

<%@include file="header.jsp"%>

<form action="/search" >
    <div  style="border-bottom:2px solid #5C8727">
        <br><br>
        <span style="padding-left:100px"></span>
        <span style="padding-left:50px"></span>

        <select name="searchoptions">
            <option value="volvo">Search By</option>
            <option value="saab">Req ID</option>
            <option value="fiat">Customer Name</option>
            <option value="audi">Status</option>
        </select>
        <span style="padding-left:50px"></span>
        <select name="operands">
            <option value="volvo">Operand</option>
            <option value="saab">=</option>
            <option value="fiat">!=</option>
            <option value="audi">LIKE</option>
        </select>
        <span style="padding-left:50px"></span>
        <input type="text" name="searchTerm">
            <br><br><br>
        <span style="padding-left:100px"></span>
        <span style="padding-left:100px"></span>
        <span style="padding-left:100px"></span>
        <span style="padding-left:100px"></span>

        <input type="submit" value="Search">
        <br><br>
    </div>
</form>
<!--
    <table width="50%" border="0" cellspacing="10" >

        <tr style="height: 7px;"></tr>

        <tr style="height: 7px;">
            <td width="35%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <select name="searchoptions">
                    <option value="volvo">Search By</option>
                    <option value="saab">Req ID</option>
                    <option value="fiat">Customer Name</option>
                    <option value="audi">Status</option>
                </select>
            </td>
            <td width="20%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <select name="operands">
                    <option value="volvo">Operand</option>
                    <option value="saab">=</option>
                    <option value="fiat">!=</option>
                    <option value="audi">LIKE</option>
                </select>
            </td>
            <td width="35%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                <input type="text" name="searchTerm">
            </td>

        </tr>

    </table>
-->

<br><br>

<div class="container-fluid" style="height: 100px; width: 75%">

    <table width="75%" border="1" cellspacing="10" >

        <tr style="height: 7px;">
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Req ID</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Invoice</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Inv Amnt $</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Customer No</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Customer Name</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Req Type</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Adj Amnt $</th>
            <th width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">Status</th>
        </tr>
        <c:forEach items="${results}" var="searchResults">
            <tr style="height: 7px;">
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.requisitionID}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.invoiceNum}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.invAmnt}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.custNo}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.custName}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.reqType}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.adjAmnt}</td>
                <td width="10%" height="12" nowrap="nowrap" align="center" rowspan="1" colspan="1">${searchResults.status}</td>

            </tr>
        </c:forEach>

    </table>


</div>

<br><br><br>
<%@include file="footer.jsp"%>
</div>

</body>
</html>
