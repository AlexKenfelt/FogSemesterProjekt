<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         This is the homepage for this sites admins
    </jsp:attribute>
    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <form method="POST" action="${pageContext.request.contextPath}/fc/orderhandlerpage">
        <h1>Hello ${sessionScope.email} </h1>
        Admin siden

            <table class="table">
            <thead>
            <tr>
                <th scope="col">Bruger ID</th>
                <th scope="col">Ordrer ID</th>
                <th scope="col">Pris</th>
                <th scope="col">Tidspunkt</th>
                <th scope="col">Indhold</th>
                <th scope="col">Fjern</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${sessionScope.orderList}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.user}</td>
                    <td>${order.status}</td>
                    <td>${order.timestamp}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/fc/orderhandlerpage">
                            <button scope="col" class="btn btn-primary btn-sm" type="submit" name="content"
                                    value="${order.id}">
                                Se indhold
                            </button>
                        </a>
                    </td>
                    <td>
                        <button class="btn btn-danger btn-sm" type="submit" name="delete"
                                value="${order.id}">
                            Fjern
                        </button>
                        <button name="confirm" type="submit" class="btn btn-primary checkoutbtn">Confirm order</button>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
        </form>

    </jsp:body>
</t:genericpage>
