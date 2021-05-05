<%--
  Created by IntelliJ IDEA.
  User: Julius
  Date: 5/5/2021
  Time: 5:37 PM
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

        <form name="orderconfirmation" action="${pageContext.request.contextPath}/fc/orderconfirmation" method="POST">
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="height">Højde</label>
                <div class="col-sm-4">
                    <input class="form-control" type="number" step="1" name="height" id="height"
                           maxlength="6" placeholder="Enter number in cm">
                    <!-- Her sikre vi os at man kun kan indtaste integers som målene til en carport, ved at
                    sige (type="number" step="1"), derefter sætter vi en maks længde på (6) for at sikre os
                    at vi ikke får urealistiske bestillinger. -->
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="width">Bredde</label>
                <div class="col-sm-4">
                    <input class="form-control" type="number" step="1" name="width" id="width"
                           maxlength="6" placeholder="Enter number in cm">
                </div>
            </div>
        <!-- En lille checkbox til om man vil have skur med eller ej.
        Dette er ikke en funktion vi fokuserer på endnu, så den gør ikke
        noget i praksis. -->
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="shed"/>
            <label class="form-check-label" for="shed">
                Skal der være skur med?
            </label>
        </div>

        <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>

            <c:if test="${not empty param.msg}">
                <p style="font-size: large">${param.msg}</p>
            </c:if>
            <button class="btn btn-primary" type="submit" value="order">Bestil</button>
        </form>

        <div>
            <c:if test="${sessionScope.role == 'admin' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an Admin</p>
            <p><a href="fc/adminpage">Admin page</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a>
                </c:if>
        </div>

    </jsp:body>
</t:genericpage>