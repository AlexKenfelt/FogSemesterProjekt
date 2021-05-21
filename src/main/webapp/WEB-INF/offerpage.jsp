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
        <h2 style="color:#0C2069">Godkend og betal dit tilbud</h2>
        <br>
        <form name="receiptpage" action="${pageContext.request.contextPath}/fc/receiptpage" method="POST">
            <p>Det samlet tilbud, plantegning og pris skal vises her</p>

            <div class="center">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Beskrivelse</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Enhed</th>
                        <th scope="col">Beskrivelse</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="carportItems" items="${sessionScope.carportItems}">

                    <tr>
                        <td>${carportItems.name}</td>
                        <td>${carportItems.quantity}</td>
                        <td>${carportItems.unit}</td>
                        <td>${carportItems.description}</td>
                    </tr>


                    </c:forEach>
                </table>
            </div>
        </form>

        ${requestScope.totalPrice}

        <button class="btn btn-sm btn-outline-light" style="background-color: #0C2069">Betal</button>

    </jsp:body>
</t:genericpage>