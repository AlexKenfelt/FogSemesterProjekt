<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div>
            <h2 style="color:#0C2069" ;>Login </h2>
            <br>
            <form name="login" action="${pageContext.request.contextPath}/fc/logincommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="text" name="email" id="email"
                               placeholder="someone@nowhere.com">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password">Password</label>
                    <div class="col-sm-4">
                        <input class="form-control" type="password" name="password" id="password" placeholder="sesam">
                    </div>
                </div>
                <c:if test="${requestScope.error != null }">
                    <p style="color:red">
                            ${requestScope.error}
                    </p>
                </c:if>

                <c:if test="${not empty param.msg}">
                    <p style="font-size: large">${param.msg}</p>
                </c:if>
                <button class="btn btn-sm btn-outline-light" style="background-color: #0C2069" type="submit"
                        value="Login">Sign in
                </button>
            </form>
        </div>
    </jsp:body>
</t:genericpage>