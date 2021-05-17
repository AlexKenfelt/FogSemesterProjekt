<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        header placeholder.
    </jsp:attribute>
    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/fc/customerpage">
            <h1>Hello ${sessionScope.email} </h1>

            <p> Velkommen til din kunde side, her vil du kunne se din ordre status når du har bestilt din carport. </p>

            <!-- Her skal vi altså have en funktion/metode der går ind og henter kunde ID ud fra sessionScope email. -->
            <!-- Og på den måde kan vi sikre os at kun den ordre der tilhører den tilsvarende kunde der er logget ind bliver vist. -->

            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Bredde</th>
                    <th>Længde</th>
                    <th>Status</th>
                    <th>Bruger</th>
                    <th>Tidspunkt</th>
                </thead>
                </tr>
                <tbody>
                <c:forEach var="order" items="${sessionScope.orderList}">

                    <tr>
                        <td>${order.id}</td>
                        <td>${order.width}</td>
                        <td>${order.length}</td>
                        <td>${order.status}</td>
                        <td>${order.user}</td>
                        <td>${order.timestamp}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </form>

    </jsp:body>
</t:genericpage>

