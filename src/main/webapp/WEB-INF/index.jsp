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

        <div class="row">

            <div class="col-4 mx-auto text-center">
                <h2 style="color:#0C2069" ;>Bestil din carport
                    <a style="color: #0C2069" href="${pageContext.request.contextPath}/fc/loginpage"> her</a>
                </h2>


                <img src="${pageContext.request.contextPath}/images/Carport.png" class="img-fluid mb-4 text-center"
                     style="text-align: center"/>

                <div>
                    <c:if test="${sessionScope.role == 'admin' }">
                    <p style="font-size: larger">This is what you can do,
                        since your are logged in as an Admin</p>
                    <p><a href="fc/adminpage">Admin page</a>
                        </c:if>

                        <c:if test="${sessionScope.role == 'customer' }">

                    <p><a href="fc/customerpage">Customer Page</a>
                        </c:if>
                </div>

            </div>


        </div>

    </jsp:body>
</t:genericpage>