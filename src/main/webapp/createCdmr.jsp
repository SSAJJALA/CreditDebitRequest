<%@ page import="com.cdmr.webservices.Customer" %>
<%@ page import="com.cdmr.entity.InvoiceHeader" %>
<%@ page import="com.cdmr.entity.InvoiceDetail" %>
<%@ page import="com.cdmr.Data.CDMRAdjustments" %>
<%--
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

<form id="createForm" action="/createCDMRServlet" >
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
                            <td>Gross:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${invoiceResults.grossAmnt}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Allowance:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${invoiceResults.allowance}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Charges:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${invoiceResults.charges}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Tax:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${invoiceResults.tax}"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Net:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${invoiceResults.netAmnt}"/></td>
                        </tr>
                    </c:if>

                    <c:if test="${cdmr.adjustments !=null && cdmr.adjustments !=''}">
                        <tr>
                            <td>Adj Gross:&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${cdmr.adjGross}"/></td>

                        </tr>
                        <tr>

                            <td>Adj Allowance:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${cdmr.adjAllowance}"/></td>
                        </tr>
                        <tr>

                            <td>Adj Charges:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${cdmr.adjCharges}"/></td>
                        </tr>
                        <tr>

                            <td>Adj Tax:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${cdmr.adjTax}"/></td>
                        </tr>
                        <tr>

                            <td>Adj Net:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$&nbsp;<c:out value="${cdmr.adjAmnt}"/></td>
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
                <tbody>
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
                </tbody>

            </table>
        </c:if>
</div>

    <h2 style="text-indent: 18em;"><b>Adjustments</b></h2>

    <div style="width:1300px;height:230px;border:1px solid #000;margin:0 auto;">
             <br>

             <table id = "datatable2" width="90%" border="1" align = "center">
                <thead>
                    <tr style="height: 7px;">
                        <th style="text-align: center;" rowspan="1" colspan="1">Delete</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item Description</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Original Qty</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Adjusted Qty</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Reason Code</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Original Unit Price($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Adjusted Price ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Allowance Adj ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Charge Adj ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Tax Adj ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Credit/Debit</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Line AdjAmnt ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Comments</th>
                    </tr>
                </thead>
                 <tbody>
                    <c:if test="${not empty cdmr}">
                        <c:forEach items="${cdmr.adjustments}" var="adjs">
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="checkbox" name="delselInv" value ="delselInv"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"> ${adjs.itemNum}</td><input type="hidden" name="adjItem" value=""${adjs.itemNum}">
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.itemDesc}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.originalQty}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="adjQty" value="${adjs.adjQty}"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1">
                                <select name="reasonCode" size="1" id="reasonCode">
                                    <option value="${adjs.reasonCode}"></option>
                                    <option value="1-Defective">1-Defective</option>
                                    <option value="2-Mis picked">2-Mis picked</option>
                                    <option value="3-Returned">3-Returned</option>
                                </select>
                        </td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.originalPrice}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.allowanceAdjAmnt}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.chargeAdjAmnt}chargeAdjAmnt</td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.taxAdjAmnt}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="creditdebit" value="${adjs.creditDebitFlg}"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1">${adjs.lineAdjAmnt}</td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="comments" value="${adjs.comments(0).comment}"></td>
                        </c:forEach>

                    </c:if>

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
    <script type="text/javascript">

        $("#datatable1 tbody input:checkbox.selInv").click(function() {
            console.log("inside the java script");
            if ($(this).is(":checked")) {
                console.log("inside the checked condition");
                //var $row = $(this).closest('tr').html();
                var tds_item = "";
                var tds_itemDesc = "";
                var tds_qty = "";
                var tds_uprice = "";
                tds_item = $(this).closest('tr').children('td:eq(1)').text();
                console.log("tds_item" + tds_item);
                tds_itemDesc = $(this).closest('tr').children('td:eq(2)').text();
                console.log("tds_itemDesc" + tds_itemDesc);
                tds_qty = $(this).closest('tr').children('td:eq(3)').text();
                console.log("tds_itemDesc" + tds_qty);
                tds_uprice = $(this).closest('tr').children('td:eq(4)').text();
                console.log("tds_uprice" + tds_uprice);
                console.log("all variables are filled");

                $('#datatable2 tbody').append('<tr class="tableRow">'+
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="checkbox" name="delselInv" value ="delselInv"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + tds_item + '</td>' + '<input type="hidden" name="adjItem" value="' + tds_item + '">' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + tds_itemDesc + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + tds_qty + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="adjQty"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' +
                            '<select name="reasonCode" size="1" id="reasonCode">' +
                                '<option value=""></option>' +
                                '<option value="1-Defective">1-Defective</option>' +
                                '<option value="2-Mis picked">2-Mis picked</option>' +
                                '<option value="3-Returned">3-Returned</option>' +

                            '</select>' +
                        '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1">' + tds_uprice + '</td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="creditdebit"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"></td>' +
                        '<td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="comments"></td>' +
                        + '</tr>');
                console.log("table2 appended");
            }
        })

    </script>
    <script type="text/javascript">

            $("#createForm").submit(function () {
                console.log("inside form submit");
                var tableData = [];
                $("#datatable2 tbody")
                        .find(".tableRow")
                        .each(function () {
                            var tableRow = {};
                            tableRow.itemId = $(this).closest('tr').children('td:eq(1)').text();
                            console.log("submit item id:" + tableRow.itemId);
                            tableRow.itemDesc = $(this).closest('tr').children('td:eq(2)').text();
                            tableRow.itemQty = $(this).closest('tr').children('td:eq(3)').text();
                            tableRow.adjQty = $(this).closest('tr').children('td:eq(4)').text();
                            tableRow.reasonCode = $(this).closest('tr').children('td:eq(5)').text();
                            tableRow.originalUp = $(this).closest('tr').children('td:eq(6)').text();
                            tableRow.adjPrice = $(this).closest('tr').children('td:eq(7)').text();
                            tableRow.allAdj = $(this).closest('tr').children('td:eq(8)').text();
                            tableRow.chrgAdj = $(this).closest('tr').children('td:eq(9)').text();
                            tableRow.taxAdj = $(this).closest('tr').children('td:eq(10)').text();
                            tableRow.creditDebit = $(this).closest('tr').children('td:eq(11)').text();
                            tableRow.lineAdjAmnt = $(this).closest('tr').children('td:eq(12)').text();
                            tableRow.comments = $(this).closest('tr').children('td:eq(13)').text();
                            tableData.push(tableRow);
                        });

                $.session.setAttribute("AdjData", tableData);
                //$.session.set("AdjData", tableData);
                //$.post(
                  //      "/createCDMRServlet" /*url of consuming servlet*/
                        //{tableData: tableData}, /*data*/
                        //function () {
                        //    alert("Success!");
                        //}, /*function to execute in case of success*/
                        //"json" /* data type */
                //);
                //event.preventDefault(); //Prevent sending form by browser

            });

    </script>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
