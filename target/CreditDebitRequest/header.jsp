<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="java.security.Principal" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!-- Header starts from here -->
<header>
    <nav>
        <ul>Reddy's Inc</ul>
    </nav>
    <%
        String userName = null;
        Principal user = request.getUserPrincipal();
        if (user != null) {
            userName = user.getName();
            request.setAttribute("user", userName);
        }
    %>
    <span style="padding-left:1000px">
    <c:if test="${not empty user}">
        <div class="topcorner">
            <img width="18" height="21" alt="User" src="/images/userIcon.png"/>
            <strong><c:out value="${user}"/></strong>
            (
            <a class="logOut" shape="rect" href="/cdmr/logoutServlet">
                Logout
            </a>
            )
        </div>
    </c:if>
</header>
<!-- Header ends here -->