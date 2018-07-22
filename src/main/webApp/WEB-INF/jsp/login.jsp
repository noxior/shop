<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <c:if test="${param.error}">
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div class="message">
                <spring:message code="${param.message}"/>
            </div>
        </c:if>
        <br/>
        <p>

            <a class="btn btn-lg btn-success" href="register"><spring:message code="app.addUser"/></a>
            <button type="submit" class="btn btn-lg btn-primary"
                    onclick="setCredentials('user@yandex.ru', '{noop}password')">
                <spring:message code="app.enter"/> User
            </button>
            <button type="submit" class="btn btn-lg btn-primary"
                    onclick="setCredentials('admin@gmail.com', '{noop}admin')">
                <spring:message code="app.enter"/> Admin
            </button>
        </p>
        <br/>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <section>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><spring:message code="fuelStation.name"/></th>
                    <th><spring:message code="fuel.name"/></th>
                    <th><spring:message code="fuel.price"/></th>
                </tr>
                </thead>
                <c:forEach items="${fuels}" var="fuel">
                    <tr data-fuelEnabled="${fuel.enabled}">
                        <td>${fuel.fuelStationName}</td>
                        <td>${fuel.fuelName}</td>
                        <td>${fuel.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>


<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript">
    <c:if test="${not empty param.username}">
    setCredentials("${param.username}", "");
    </c:if>

    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
</body>
</html>