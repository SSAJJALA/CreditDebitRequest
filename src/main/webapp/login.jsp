<%--
  Created by IntelliJ IDEA.
  User: Siva Sajjala
  Date: 9/22/16
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp"%>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>CDMR - Login</title>

</head>
<body onload="usernameFocus()">
<!-- Header start from here -->
<div id="mainContainer">

    <%@include file="header.jsp"%>
    <br><br><br>
    <div class="containerInside">
        <div class="SearchResultBox">
            <div>
                <div id="container-4">
                    <div class="login">
                        <div style="border-bottom:1px solid #d9d9db; ">
                            <h2>CDMR LOGIN</h2>
                        </div>
                        <div class="loginForm">
                            <FORM ACTION="j_security_check" METHOD="POST">
                                <TABLE>
                                    <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username"> </TD></TR>
                                    <TR><TD>Password:  <INPUT TYPE="PASSWORD" NAME="j_password"> </TD></TR>
                                    <TR><TD><span style="padding-left:20px"></span><INPUT TYPE="SUBMIT" VALUE="Log In"></TD></TR>
                                </TABLE>
                            </FORM>
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
<br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp"%>
<script type="text/javascript">window.NREUM||(NREUM={});NREUM.info={"applicationID":"3586288","applicationTime":4,"beacon":"bam.nr-data.net","queueTime":0,"licenseKey":"7d55d80316","transactionName":"ZwNRYUJXXxVZUUMNC15JeWZgGWYjeh9+KiIfEFpQRxlbFUgdUwECURNfQW8ZRA8XUVYXKF8BWltmX1QRFlhEFA==","agent":"","errorBeacon":"bam.nr-data.net"}</script>
</body>
</html>
