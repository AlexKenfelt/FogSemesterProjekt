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
