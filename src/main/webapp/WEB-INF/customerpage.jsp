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
        <form method="post" action="${pageContext.request.contextPath}/fc/offerpage">

            <p> Velkommen ${sessionScope.user.name.toString()}, her vil du kunne se din ordre status når du har bestilt
                din carport. </p>
            <a type="button" class="btn btn-sm btn-outline-light" style="background-color: #0C2069"
               href="${pageContext.request.contextPath}/fc/index">Til forsiden</a>
            <a type="button" class="btn btn-sm btn-outline-light" style="background-color: #0C2069"
               href="${pageContext.request.contextPath}/fc/orderpage">Bestil din carport</a>


            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Order Id</th>
                    <th scope="col">Bredde</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Status</th>
                    <th scope="col">Tidspunkt</th>
                    <th scope="col"> Se Indhold</th>
                </thead>
                </tr>
                <tbody>
                <c:forEach var="order" items="${sessionScope.orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.width}</td>
                            <td>${order.length}</td>
                            <td>${order.status}</td>
                            <td>${order.timestamp}</td>
                            <td><c:if test="${!order.status.equals('pending')}">
                                <a href="${pageContext.request.contextPath}/fc/offerpage">
                                    <button scope="col" class="btn btn-primary btn-sm"
                                            style="background-color: #0C2069"
                                            type="submit" name="content"
                                            value="${order.id}">
                                        Se indhold
                                    </button>
                                </a>
                            </c:if></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </jsp:body>
</t:genericpage>

