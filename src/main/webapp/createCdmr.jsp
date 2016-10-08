<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/21/16
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create CDMR</title>
</head>
<body>
<div id="mainContainer">
    <%@include file="header.jsp"%>

    <h2 style="text-indent: 18em;"><b>Create Credit Debit Memo request</b></h2>

<form action="/submitCDMRServlet" >
<div style="width:1300px;height:270px;border:1px solid #000;margin:0 auto;">
    <p width="100%" border="0" cellspacing="10" class="single-underline">&nbsp;<i>Customer/Invoice</i>
    </p>

    <table width="90%" cellpadding="4" cellspacing="0" style="height: 100px;">
        <tr>
            <td width="40%">
                <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                    <tr><td><u><span style="font-size:15px;font-weight:bold;">Customer</span></u></td></tr>
                    <form action="/customerLookup" >
                    <tr id="tr_custDet">
                        <td width="30%">
                            <input type="text" name="customer">
                        </td>
                        <td width="80%">&nbsp;&nbsp;
                            <input  id="btn_retCust" name="btn_retCust" class="btnInside" value="Search" type="button">
                        </td>
                    </tr>
                    </form>
                    <c:if test="${customerResults.custNum !=null && customerResults.custNum !=''}">
                        <tr><td><c:out value="${customerResults.custName}"/></td></tr>
                        <tr><td><c:out value="${customerResults.custAddr1}"/></td></tr>
                        <tr><td><c:out value="${customerResults.custAddr2}"/></td></tr>
                        <tr><td><c:out value="${customerResults.city}"/> &nbsp;&nbsp;&nbsp;<c:out value="${customerResults.state}"/> &nbsp;&nbsp;&nbsp; <c:out value="${customerResults.zip}"/></td></tr>
                    </c:if>
                 </table>
            </td>
            <td width="60%">
                <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                    <tr><td><u><span style="font-size:15px;font-weight:bold;">Invoice</span></u></td></tr>
                    <form action="/invoiceLookup" >
                        <tr id="tr_invoice">
                            <td width="30%">
                                <input type="text" name="Invoice">
                            </td>
                            <td width="80%">&nbsp;&nbsp;
                                <input  id="btn_retInv" name="btn_retInv" class="btnInside" value="Search" type="button">
                            </td>
                        </tr>
                    </form>
                    <c:if test="${invoiceResults.invNum !=null && invoiceResults.invNum !=''}">
                        <tr>
                            <td>Invoice Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.invDate}"/></td>
                            <td>Gross:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.gross}"/></td>
                        </tr>
                        <tr>
                            <td>Line count:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.lineCount}"/></td>
                            <td>Allowance:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.allowance}"/></td>
                        </tr>
                        <tr>
                            <td>Sales Rep:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.invDate}"/></td>
                            <td>Charges:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.charges}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Net:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${invoiceResults.net}"/></td>
                        </tr>
                    </c:if>
                </table>

            </td>

        </tr>
        </table>

</div>

    <h2 style="text-indent: 18em;"><b>Original Invoice Line Items</b></h2>

<div style="width:1300px;height:270px;border:1px solid #000;margin:0 auto;">

            <table id = "datatable1" style="display:none" class="t-table" width="90%" border="1" align = "center">
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
                <c:forEach items="${search}" var="searchResults">
                    <tr style="height: 7px;">
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="checkbox" name="selInv" value ="selInv"></td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.item}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.itemDesc}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.qty}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.unitPrice}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.allowance}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.charges}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.tax}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${searchResults.invTotal}</td>

                    </tr>
                </c:forEach>

            </table>
</div>

    <h2 style="text-indent: 18em;"><b>Adjustments</b></h2>

<div style="width:1300px;height:150px;border:1px solid #000;margin:0 auto;">

             <table id = "datatable2" style="display:none" class="t-table" width="90%" border="1" align = "center">
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
                <tr style="height: 7px;">
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="checkbox" name="delselInv" value ="delselInv"></td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.item}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.itemDesc}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.orgQty}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="text"></td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="text"></td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.orgPrice}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.allowanceAdj}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.chargeAdj}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.taxAdj}</td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="text"></td>
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">${selectInv.lineAdj}</td>
                    <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="text"></td>

                    </tr>
            </table>

</div>
    <br><br>
    <span style="padding-left:1370px"></span>
    <input  id="btn_calculate" name="btn_calculate" class="btnInside" value="Calculate" type="button">
    <span style="padding-left:20px"></span>
    <input  id="btn_submit" name="btn_submit" class="btnInside" value="Submit" type="button">
    <span style="padding-left:20px"></span>
    <input  id="btn_cancel" name="btn_cancel" class="btnInside" value="Cancel" type="button">

</form>
</div>
</body>
</html>
