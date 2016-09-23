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


<tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create Credit Debit Memo request</b></h2></td></tr>
<div style="width:500px;height:100px;border:1px solid #000;">
    <p width="100%" border="0" cellspacing="10" class="single-underline">&nbsp;<i>Customer/Invoice</i>
    </p>
    <br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;<u>Customer</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>Invoice</u>
    <form action="/customerLookup" >
        <table width="50%" border="0" cellspacing="10" >

            <tr style="height: 7px;"></tr>

            <tr style="height: 7px;">
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                    <input type="text" name="customer">
                </td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                    <input type="submit" value="Search">
                </td>
            </tr>

        </table>
    </form>
    <form action="/invoiceLookup" >
        <table width="50%" border="0" cellspacing="10" >

            <tr style="height: 7px;"></tr>

            <tr style="height: 7px;">
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                    <input type="text" name="invoice">
                </td>
                <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1">
                    <input type="submit" value="Search">
                </td>
            </tr>

        </table>
    </form>
    <table>
        <tr><td>Customer Number:</td></tr>
        <tr><td>Address1:</td></tr>
        <tr><td>Address2</td>
        <tr><td>City:%%. State: Zip:</td></tr>
    </table>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <table>
        <tr><td>Invoice Date:</td></tr>
        <tr><td>Line Count:</td></tr>
        <tr><td>Sales Manager</td>
    </table>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <table>
        <tr><td>Gross:</td></tr>
        <tr><td>Allowance:</td></tr>
        <tr><td>Charges</td>
        <tr><td>Tax</td>
        <tr><td>Net</td>
    </table>

</div>
<tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Original Invoice Line Items</b></h2></td></tr>
<div style="width:500px;height:100px;border:1px solid #000;">
    <c:choose>
        <c:when test="${empty search}">
            <h2>No invoice found</h2>
        </c:when>
        <c:otherwise>
            <table width="100%" border="1" cellspacing="10" >

                <tr style="height: 7px;">
                    <th>Add</th>
                    <th>Item</th>
                    <th>Item Description</th>
                    <th>Qty</th>
                    <th>Unit Price</th>
                    <th>Allowances</th>
                    <th>Charges</th>
                    <th>Tax</th>
                    <th>Invoice Total</th>
                </tr>
                <c:forEach items="${search}" var="searchResults">
                    <tr style="height: 7px;">
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="checkbox" name="selInv" value ="selInv"</td>
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
        </c:otherwise>
    </c:choose>

</div>
<tr><td><h2><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Adjustments</b></h2></td></tr>
<div style="width:500px;height:100px;border:1px solid #000;">
             <table width="100%" border="1" cellspacing="10" >

                <tr style="height: 7px;">
                    <th>Delete</th>
                    <th>Item</th>
                    <th>Item Description</th>
                    <th>Original Qty</th>
                    <th>Adjusted Qty</th>
                    <th>Reason Code</th>
                    <th>Original Price($)</th>
                    <th>Adjusted Price ($)</th>
                    <th>Allowance Adj</th>
                    <th>Charge Adj</th>
                    <th>Tax Adj</th>
                    <th>Credit/Debit</th>
                    <th>Line AdjAmnt ($)</th>
                    <th>Comments</th>
                </tr>
                <tr style="height: 7px;">
                        <td width="32%" height="12" nowrap="nowrap" align="left" rowspan="1" colspan="1"><input type="checkbox" name="delselInv" value ="delselInv"</td>
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

</body>
</html>
