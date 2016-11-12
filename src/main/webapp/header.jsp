<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="java.security.Principal" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!-- Header starts from here -->
<header>
    <nav>
        <ul>Reddy's Inc</ul>
    </nav>
    <c:if test="${not empty getName(request)}">
        <span style="padding-left:100px"></span>
        <div class="userArea">
        <span class="floatRight">
            <img width="18" height="21" alt="User" src="/images/userIcon.png"/>
            <strong><%=getName(request)%></strong>
            (
            <a class="logOut" shape="rect" href="/cdmr/logoutServlet">
                Logout
            </a>
            )
        </span>
        </div>
    </c:if>
</header>
<!-- Header ends here -->
<%!
    private String getName(HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        if (user != null) {
            return user.getName();
        }

        return ""; // or return null
    }
%>