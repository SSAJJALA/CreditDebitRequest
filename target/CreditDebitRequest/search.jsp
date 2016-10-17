<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
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

<form action="/searchServlet" >
    <div  style="border-bottom:2px solid #5C8727">
        <br><br>
        <span style="padding-left:60px"></span>


        <select name="searchoptions">
            <option value="searchBy">Search By</option>
            <option value="requisitionID">Req ID</option>
            <option value="customerName">Customer Name</option>
            <option value="status">Status</option>
            <option value="all">All</option>
        </select>
        <span style="padding-left:50px"></span>
        <select name="operands">
            <option value="operand">Operand</option>
            <option value="=">=</option>
            <option value="!=">!=</option>
            <option value="like">LIKE</option>
        </select>
        <span style="padding-left:50px"></span>
        <input type="text" name="searchTerm">
            <br><br>
        <span style="padding-left:500px"></span>

        <input type="submit" value="Search">
        <br><br>
    </div>
</form>

<br><br>
<div class="container-fluid" style="height: 600px; width: 100%; border:1px solid black;">
    <br><br>

    <c:if test="${not empty results}">
        <table id = "datatable"  width="90%" border="1" align = "center">
            <thead>
                <tr>
                    <th style="text-align: center;" rowspan="1" colspan="1">Req ID</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Invoice</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Inv Amnt $</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Customer No</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Customer Name</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Req Type</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Adj Amnt $</th>
                    <th style="text-align: center;" rowspan="1" colspan="1">Status</th>
                </tr>
            </thead>
            <c:forEach items="${results}" var="searchResults">
                <tr>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.requisitionID}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.invoiceNum}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.invAmnt}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.custNo}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.custName}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.reqType}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.adjAmnt}</td>
                    <td style="text-align: center;" rowspan="1" colspan="1">${searchResults.status}</td>
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
