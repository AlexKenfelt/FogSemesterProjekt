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
        <h2 style="color:#0C2069">Ordrebekræftelse </h2>
        <br>
        <p>Tak for at handle hos os, vi sender dine materialer snarest muligt. </p>
        <br>


    </jsp:body>
</t:genericpage>