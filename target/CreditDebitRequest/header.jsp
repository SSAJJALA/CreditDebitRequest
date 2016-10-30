<!-- Header starts from here -->
<header>
    <nav>
        <ul>Reddy's Inc</ul>
    </nav>
    <c:if test="${not empty request.getUserPrincipal().getName()}">
        <span style="padding-left:100px"></span>
        <div class="userArea">
        <span class="floatRight">
            <img width="18" height="21" alt="User" src="/images/userIcon.png"/>
            <strong><%=request.getUserPrincipal().getName()%></strong>
            (
            <a class="logOut" shape="rect" href="/logoutServlet">
                Logout
            </a>
            )
        </span>
        </div>
    </c:if>
</header>
<!-- Header ends here -->