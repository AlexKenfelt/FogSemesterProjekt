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

            <p> Velkommen ${sessionScope.user.name.toString()}, her vil du kunne se din ordre status når du har bestilt din carport. </p>

            <table class="table">
                <thead>
                <tr>
                    <th>Bredde</th>
                    <th>Længde</th>
                    <th>Status</th>
                    <th>Tidspunkt</th>
                </thead>
                </tr>
                <tbody>
                <c:forEach var="order" items="${sessionScope.orders}">

                    <tr>
                        <td>${order.width}</td>
                        <td>${order.length}</td>
                        <td>${order.status}</td>
                        <td>${order.timestamp}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </form>

    </jsp:body>
</t:genericpage>

