<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>

    <!-- Bootstrap CSS -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
    <script src="https://kit.fontawesome.com/c5d38df5c3.js" crossorigin="anonymous"></script>
</head>

<body>
<!--
    This header is inspired by this bootstrap
    example: https://getbootstrap.com/docs/5.0/examples/pricing/
-->
<div class="container">
    <img src="${pageContext.request.contextPath}/images/header.png" class="img-fluid mb-4"/>

    <header class=""
            style="align: center;">
        <div class="h5 my-0 me-md-auto fw-normal">
            <p style="font-size: larger">
                <jsp:invoke fragment="header"/>
            </p>
        </div>

        <!-- Dette kan nok sagtens gøres smartere, men der var ikke nogen navigations bar når man
        loggede ind som enten admin eller customer. -->
        <nav class="my-2 my-md-0 me-md-3" align="Right">
            <c:if test="${sessionScope.user != null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/index">Home</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/orderpage">Byg din carport</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
            </c:if>
        </nav>

        <!-- Dette er den originale navigations bar du arbejdede på Maja -->
        <nav class="my-2 my-md-0 me-md-3" align="Right">
            <c:if test="${sessionScope.user == null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/index">Home</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/orderpage">Byg din carport</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>

            </c:if>
        </nav>

        <hr style=color:#0C2069>

        <div>
            <c:if test="${sessionScope.user != null }">
                ${sessionScope.user.email}
            </c:if>

            <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
            <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
            <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

            <c:if test="${isNotLoginPage && isNotRegisterPage}">
            <c:if test="${sessionScope.user != null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
            </c:if>
        </div>
        </c:if>
</div>
</header>

<div class="container">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
<footer class="page-footer font-small blue myfooter">
    <div class="footer-copyright text-center py-3">
        <img src="${pageContext.request.contextPath}/images/1.png" style="width: 100%;">
        <div class="centered">Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439</div>
    </div>
    <%--<div class="container">
        <br>
        <hr style=color:#0C2069>
        <img src="${pageContext.request.contextPath}/images/1.png" class="img-fluid" alt="Responsive image" style="width:100%;">
        <div class="bottom-left">
        </div>
        <jsp:invoke fragment="footer"/>
    </div>--%>
</footer>
</div>
</body>
</html>