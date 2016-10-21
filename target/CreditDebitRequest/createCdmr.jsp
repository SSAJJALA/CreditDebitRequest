<%@ page import="com.cdmr.webservices.Customer" %>
<%@ page import="com.cdmr.entity.InvoiceHeader" %>
<%@ page import="com.cdmr.entity.InvoiceDetail" %><%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/21/16
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Customer custDetails;
    InvoiceHeader invHeader;
    InvoiceDetail invDetails;
%>
<%
    custDetails = (Customer) request.getAttribute("customerResults");
    invHeader = (InvoiceHeader) request.getAttribute("invoiceResults");
    invDetails = (InvoiceDetail) request.getAttribute("invoiceDetails");
%>
<html>
<head>
    <title>Create CDMR</title>
</head>
<body>
<div id="mainContainer">
    <%@include file="header.jsp"%>

    <h2 style="text-indent: 18em;"><b>Create Credit Debit Memo request</b></h2>

<form action="/createCDMRServlet" >
<div style="width:1300px;height:170px;border:1px solid #000;margin:0 auto;">
    <p width="100%" border="0" cellspacing="10" class="single-underline">&nbsp;<i>Customer/Invoice</i>
    </p>

    <table width="90%" cellpadding="4" cellspacing="0" style="height: 100px;">
        <tr>
            <td width="40%">
                <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                    <tr><td><u><span style="font-size:15px;font-weight:bold;">Customer</span></u></td></tr>

                        <tr id="tr_custDet">
                        <td width="30%">
                            <c:choose>
                                <c:when test="${customerResults.custNum !=null && customerResults.custNum !=''}">
                                   <input type="text" name="customer" value="<c:out value="${customerResults.custNum}"/>">
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="customer">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td width="80%">&nbsp;&nbsp;
                            <input  id="btn_retCust" name="btn_retCust" class="btnInside" value="Search" type="submit">

                        </td>
                        </tr>

                    <c:if test="${customerResults.custNum !=null && customerResults.custNum !=''}">
                        <tr><td><c:out value="${customerResults.custName}"/></td></tr>
                        <tr><td><c:out value="${customerResults.add1}"/></td></tr>
                        <tr><td><c:out value="${customerResults.add2}"/></td></tr>
                        <tr><td><c:out value="${customerResults.city}"/> &nbsp;&nbsp;&nbsp;<c:out value="${customerResults.state}"/> &nbsp;&nbsp;&nbsp; <c:out value="${customerResults.zip}"/></td></tr>
                    </c:if>
                 </table>
            </td>
            <td width="60%">
                <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                    <tr><td><u><span style="font-size:15px;font-weight:bold;">Invoice</span></u></td></tr>

                        <tr id="tr_invoice">
                            <td width="30%">
                                <c:choose>
                                    <c:when test="${invoiceResults.invCustomer.invoiceNum !=null && invoiceResults.invCustomer.invoiceNum !=''}">
                                        <input type="text" name="Invoice" value="<c:out value="${invoiceResults.invCustomer.invoiceNum}"/>">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" name="Invoice">
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td width="80%">&nbsp;&nbsp;
                                <input  id="btn_retInv" name="btn_retInv" class="btnInside" value="Search" type="submit">
                            </td>
                        </tr>

                    <c:if test="${invoiceResults.invCustomer.invoiceNum !=null && invoiceResults.invCustomer.invoiceNum !=''}">
                        <tr>
                            <td>Invoice Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.invDate}"/></td>
                            <td>Gross:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.grossAmnt}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Allowance:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.allowance}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Charges:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.charges}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Tax:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.tax}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Net:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.netAmnt}"/></td>
                        </tr>
                    </c:if>
                </table>

            </td>

        </tr>
        </table>

</div>

    <h2 style="text-indent: 18em;"><b>Original Invoice Line Items</b></h2>

<div style="width:1300px;height:230px;border:1px solid #000;margin:0 auto;">
        <br>
        <c:if test="${not empty invoiceDetails}">
            <table id = "datatable1" width="90%" border="1" align = "center">
                <thead>
                    <tr style="height: 7px;">
                        <th style="text-align: center;" rowspan="1" colspan="1">Add/Remove</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item Description</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Qty</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Unit Price</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Allowances</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Charges</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Tax</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Invoice Total</th>

                    </tr>
                </thead>
                <c:forEach items="${invoiceDetails}" var="invDtl">
                    <tr style="height: 7px;">
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="checkbox" name="selInv" value ="selInv" class="selInv"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.invItem.itemNum}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.itemDesc}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.qty}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.unitPrice}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.allowance}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.charges}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.tax}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${invDtl.netAmnt}</td>

                    </tr>
                </c:forEach>

            </table>
        </c:if>
</div>

    <h2 style="text-indent: 18em;"><b>Adjustments</b></h2>

    <div style="width:1300px;height:100px;border:1px solid #000;margin:0 auto;">

             <table id = "datatable2" width="90%" border="1" align = "center">
                <thead>
                    <tr style="height: 7px;">
                        <th style="text-align: center;" rowspan="1" colspan="1">Delete</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item Description</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Original Qty</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Adjusted Qty</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Reason Code</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Original Price($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Adjusted Price ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Allowance Adj</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Charge Adj</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Tax Adj</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Credit/Debit</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Line AdjAmnt ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Comments</th>
                    </tr>
                </thead>
                 <tbody>

                 </tbody>
            </table>

</div>
    <br>
    <span style="padding-left:1000px"></span>
    <input  id="btn_calculate" name="btn_calculate" class="btnInside" value="Calculate" type="submit">
    <span style="padding-left:20px"></span>
    <input  id="btn_submit" name="btn_submit" class="btnInside" value="Submit" type="submit">
    <span style="padding-left:20px"></span>
    <input  id="btn_cancel" name="btn_cancel" class="btnInside" value="Cancel" type="submit">

</form>
    <script>

        $("#datatable1 input:checkbox.selInv").click(function() {
            if ($(this).is(":checked")) {
                var $row = $(this).closest('tr').html();
                $tds_item = $row.find("td:nth-child(2)");
                $tds_itemDesc = row.find("td:nth-child(3)");
                $tds_qty = row.find("td:nth-child(4)");
                $tds_uprice = row.find("td:nth-child(5)");
                $tds_all = row.find("td:nth-child(6)");
                $tds_chrg = row.find("td:nth-child(7)");
                $tds_tax = row.find("td:nth-child(8)");
                $tds_invtotal = row.find("td:nth-child(9)");
                $('#datatable2 tbody').append('<tr>'+row+'</tr>');
                $('#datatable2 tbody').append('<tr>'+
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="checkbox" name="delselInv" value ="delselInv"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + $tds_item.text() + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + $tds_itemDesc.text() + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + $tds_qty.text() + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + $tds_uprice.text() + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text"></td>' +
                        + '</tr>');
            }
        })

    </script>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
