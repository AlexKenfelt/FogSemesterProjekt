<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Det er siden for visningen af igangværende ordre.
    </jsp:attribute>
    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/fc/adminpage">
            <h1>Hello ${sessionScope.email} </h1>
            Admin siden
          <!--  <script language="javascript" type="text/javascript">
                function doSubmit() {
                    window.open("orderhandlerpage.jsp", "_self");
                }
                <html:button property="button" onclick="doSubmit();" value="Rediger ordre"/>
            </script> -->
            <a href="orderhandlerpage">Rediger ordre</a>
            <table class="table">


                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Bredde</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Status</th>
                    <th scope="col">Bruger</th>
                    <th scope="col">Tidspunkt</th>
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
