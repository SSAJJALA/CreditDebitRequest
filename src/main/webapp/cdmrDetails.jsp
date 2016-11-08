<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/28/16
  Time: 7:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp"%>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page buffer="16kb" autoFlush="true" %>
<html>
<head>
    <title>CDMR Details</title>
</head>
<body>
<div id="mainContainer">

    <%@include file="header.jsp"%>
    <h2 style="text-indent: 18em;"><b>Credit Debit Request Details</b></h2>


    <form id="createForm" action="/cdmrDetailsServlet" method="post">
        <div style="width:1300px;height:170px;border:1px solid #000;margin:0 auto;">
            <p width="100%" border="0" cellspacing="10" class="single-underline">&nbsp;<i>Requisition # ${cdmr.requisitionID}</i>
            </p>

            <table width="90%" cellpadding="4" cellspacing="0" style="height: 100px;">

                <tr>
                    <td width="30%">
                        <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                            <tr><td><u><span style="font-size:15px;font-weight:bold;">Customer</span></u></td></tr>
                            <tr><td>Customer Number: &nbsp; <c:out value="${cdmr.customer.custNum}"/></td></tr>
                            <tr><td><c:out value="${cdmr.customer.custName}"/></td></tr>
                            <tr><td><c:out value="${cdmr.customer.address1}"/> &nbsp; <c:out value="${cdmr.customer.address2}"/></td></tr>
                            <tr><td><c:out value="${cdmr.customer.city}"/>, &nbsp; <c:out value="${cdmr.customer.state}"/>&nbsp;<c:out value="${cdmr.customer.zip}"/></td></tr>
                        </table>
                    </td>
                    <td width="40%">
                        <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                            <tr><td><u><span style="font-size:15px;font-weight:bold;">Invoice</span></u></td></tr>
                            <tr>
                                <td>Invoice #:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${cdmr.invHeader.invNum}"/></td>
                                <td>Gross:&nbsp;&nbsp;&nbsp;&nbsp;$ &nbsp;<c:out value="${cdmr.invHeader.grossAmnt}"/></td>
                            </tr>
                            <tr>
                                <td>Invoice Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${cdmr.invHeader.invDate}"/></td>
                                <td>Allowance:&nbsp;&nbsp;&nbsp;&nbsp;$ &nbsp;<c:out value="${cdmr.invHeader.allowanceAmnt}"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Charges:&nbsp;&nbsp;&nbsp;&nbsp;$ &nbsp;<c:out value="${cdmr.invHeader.chargesAmnt}"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Tax:&nbsp;&nbsp;&nbsp;&nbsp;$ &nbsp;<c:out value="${cdmr.invHeader.taxAmnt}"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Tax:&nbsp;&nbsp;&nbsp;&nbsp;$ &nbsp;<c:out value="${cdmr.invHeader.netAmnt}"/></td>
                            </tr>
                        </table>
                    </td>
                    <td width="30%">
                        <table cellpadding="4" cellspacing="0" align="center" width="80%" >
                            <tr><td><u><span style="font-size:15px;font-weight:bold;">Credit Debit Request</span></u></td></tr>
                            <tr><td>Created On: &nbsp;&nbsp; <c:out value="${cdmr.cdmrDate}"/></td></tr>
                            <tr><td>CDMR Amount: &nbsp; $&nbsp; <c:out value="${cdmr.adjAmnt}"/></td></tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
        <div style="width:1300px;height:230px;border:1px solid #000;margin:0 auto;">
            <br>
                <span style="padding-left:1000px"></span>
            <c:if test="${not empty taskDetails}">
                <input  id="btn_approve" name="btn_approve" class="btnInside" value="Approve" type="submit">
            </c:if>
                <span style="padding-left:20px"></span>
            <c:if test="${not empty taskDetails}">
                <input  id="btn_reject" name="btn_reject" class="btnInside" value="Reject" type="submit">
            </c:if>
                <span style="padding-left:20px"></span>
            <input  id="btn_exit" name="btn_exit" class="btnInside" value="Exit" type="submit">
            <br><br>
            <table id = "datatable1" width="90%" border="1" align = "center">
                <thead>
                    <tr style="height: 7px;">
                        <th style="text-align: center;" rowspan="1" colspan="1">Item</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Item Description</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Reason Code</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Original Unit Price($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Orig Qtye</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Qty Adj</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Credit/Debit</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Comments</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">Adj Amnt ($)</th>
                        <th style="text-align: center;" rowspan="1" colspan="1">New Inv Total ($)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cdmr.adjustments}" var="adjs">
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.itemNum}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.itemDesc}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.reasonCode}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.originalPrice}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.originalQty}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.adjQty}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.creditDebitFlg}"/></td>
                        <%
                            String commentInfo = "";
                        %>
                        <c:forEach items="${adjs.comments}" var="comment">
                            <c:set var = "commentCon" value="${comment.comment}" />
                            <%
                                commentInfo = commentInfo + pageContext.getAttribute("commentCon").toString();
                            %>
                        </c:forEach>
                        <td style="text-align: center;" rowspan="1" colspan="1"><input type="text" name="comments" value="<%= commentInfo%>"></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.lineAdjAmnt}"/></td>
                        <td style="text-align: center;" rowspan="1" colspan="1"><c:out value="${adjs.newInvLineTotal}"/></td>
                    </c:forEach>
                </tbody>
            </table>

        </div>

        <c:if test="${not empty message}">
            <div id="pop">
                <c:out value="${message}"/>
                <input  id="btn_message" name="btn_message" class="btnMessage" value="OK" type="submit">
            </div>
        </c:if>

    </form>

    <!--
    <script type="text/javascript">
        var msg = '<%=session.getAttribute("message")%>';
        if (msg != "null") {
            function alertName() {
                alert(msg);
                request.getSession().removeAttribute("cdmr");
                request.getSession().removeAttribute("taskDetails");
                request.getSession().removeAttribute("message");
                window.location = 'index.jsp';
            }
        }
    </script>
    -->
</div>
<br><br>
<%@include file="footer.jsp"%>
<!--<script type = "text/javascript"> window.onload = alertName(); </script> -->
</body>
</html>
