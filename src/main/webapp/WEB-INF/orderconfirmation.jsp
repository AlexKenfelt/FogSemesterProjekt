<%--
  Created by IntelliJ IDEA.
  User: Julius
  Date: 5/5/2021
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <br>
        <p style="font-size: larger"> Vi vil nu behandle din anmodning om en carport med målene: </p>
        <!-- Her requester vi om den data kunden indtastede på orderpage og der blev
        behandlet i vores BuildCarportCommand klasse. Og så bliver den displayet her -->
        <p style="font-size: larger"> Bredde: ${requestScope.width} </p>
        <p style="font-size: larger"> Længde: ${requestScope.length} </p>


        <a href="${pageContext.request.contextPath}/fc/customerpage">
            <button scope="col" class="btn btn-sm btn-outline-light" name="content" style="background-color: #0C2069"
                    value="${order.id}">
                Tryk her for at gå til din side.
            </button>
        </a>

        ${requestScope.drawing}
        <!-- Dette her data har ikke noget med databasen at gøre, så ingen data bliver gemt
        udover i vores sessionScope. -->
        </div>

        <!-- Dette her er umiddelbart ikke nødvendigt, der skal vel ikke være link tilbage til deres page.
        <div>
        <c:if test="${sessionScope.role == 'admin' }">
            <p style="font-size: larger">This is what you can do,
            since your are logged in as an Admin</p>
            <p><a href="fc/adminpage">Admin page</a>
        </c:if>
        -->
        </div>

    </jsp:body>
</t:genericpage>