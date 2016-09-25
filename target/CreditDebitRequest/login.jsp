<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/22/16
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="head.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="generator" content="HTML Tidy for Linux (vers 6 November 2007), see www.w3.org" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>CDMR - Login</title>

</head>
<body onload="usernameFocus()">
<!-- Header start from here -->
<div id="mainContainer">

    <div style="border-bottom:1px solid #d9d9db; " id="panel">
        <div class="headerInside">
            <div class="floatLeft"><h1 title="Reddy's Inc">Reddy's Inc</h1></div>
        </div>
    </div>
    <!-- Header ends here -->

    <div class="clear"></div>

    <!-- Shadow area starts from here -->
    <div class="shadow"></div>
    <!-- Shadow area ends here -->

    <div class="clear"></div>

    <div class="containerInside">
        <div class="SearchResultBox">
            <div>
                <div id="container-4">
                    <div class="login">
                        <div style="border-bottom:1px solid #d9d9db; ">
                            <h1>CDMR LOGIN</h1>
                        </div>
                        <div class="loginForm">
                            <form id="fm1" class="fm-v clearfix" action="/login" method="post">

                                <table width="100%" border="0" cellspacing="2" cellpadding="5">
                                    <tr>
                                        <td class="alignRight"><label for="username" title="Username">Username </label></td>
                                        <td><input id="username" name="username" class="required inp" tabindex="1" type="text" value="" size="25" autocomplete="false"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="alignRight"><label for="password" title="Password">Password </label></td>
                                        <td><input id="password" name="password" class="required inp" tabindex="2" type="password" value="" size="25" autocomplete="off"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>
                                            <div class="row btn-row">
                                                <input type="hidden" name="lt" value="" />
                                                <input type="hidden" name="execution" value="e2s1" />
                                                <input type="hidden" name="_eventId" value="submit" />

                                                <input class="loginBtn" name="submit" accesskey="l" value="LOGIN"
                                                       tabindex="4" type="submit" title="Click here to Login" alt="Click here to Login" />

                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>  <c:if test="${not empty message}">
                                                <h1>${message}</h1>
                                              </c:if>
                                        </td>
                                    </tr>
                                </table>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="clear"></div>
    </div>
    <script>
        function usernameFocus(){
            document.getElementById('username').focus();

        }
    </script>

</div>

<%@include file="footer.jsp"%>
<script type="text/javascript">window.NREUM||(NREUM={});NREUM.info={"applicationID":"3586288","applicationTime":4,"beacon":"bam.nr-data.net","queueTime":0,"licenseKey":"7d55d80316","transactionName":"ZwNRYUJXXxVZUUMNC15JeWZgGWYjeh9+KiIfEFpQRxlbFUgdUwECURNfQW8ZRA8XUVYXKF8BWltmX1QRFlhEFA==","agent":"","errorBeacon":"bam.nr-data.net"}</script></body>
</html>
