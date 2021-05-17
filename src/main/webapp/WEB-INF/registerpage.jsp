<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div>
            <h2 style="color:#0C2069" ;>Sign up</h2>
            <br>
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="text" name="email" value="${param.email}"
                               placeholder="Enter a valid email">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Kodeord</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control" type="password" name="password1"
                               value="${param.password1}" placeholder="Enter your password">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password2">Kodeord</label>
                    <div class="col-sm-4">
                        <input id="password2" class="form-control" type="password" name="password2"
                               value="${param.password2}" placeholder="Repeat the password">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="name">Navn</label>
                    <div class="col-sm-4">
                        <input id="name" class="form-control" type="text" name="name" value="${param.name}"
                               placeholder="Enter your first name">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="address">Adresse</label>
                    <div class="col-sm-4">
                        <input id="address" class="form-control" type="text" name="address" value="${param.address}"
                               placeholder="Enter a valid address">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="postal">Post adresse</label>
                    <div class="col-sm-4">
                        <input id="postal" class="form-control" type="text" name="postal" value="${param.postal}"
                               placeholder="Enter a valid postal">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="city">By</label>
                    <div class="col-sm-4">
                        <input id="city" class="form-control" type="text" name="city" value="${param.city}"
                               placeholder="Enter a valid city">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="phone">tlf. nummer</label>
                    <div class="col-sm-4">
                        <input id="phone" class="form-control" type="text" name="phone" value="${param.phone}"
                               placeholder="Enter a valid phone number">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


