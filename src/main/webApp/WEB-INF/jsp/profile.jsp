<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="accounting_of_shop" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <%--@elvariable id="user" type="com.shop.fuelcoupons.model.User"--%>
        <h2>${user.name} <spring:message code="${register ? 'app.addUser' : 'app.profile'}"/></h2>

        <form:form modelAttribute="user" class="form-horizontal" method="post"
                   action="${register ? 'register' : 'profile'}"
                   charset="utf-8" accept-charset="UTF-8">

            <spring:message code="user.name" var="userName"/>
            <accounting_of_shop:inputField label='${userName}' name="name"/>
            <form:errors path="email" cssClass="error"/>

            <spring:message code="user.email" var="userEmail"/>
            <accounting_of_shop:inputField label='${userEmail}' name="email"/>
            <form:errors path="email" cssClass="error"/>

            <spring:message code="user.password" var="userPassword"/>
            <accounting_of_shop:inputField label='${userPassword}' name="password" inputType="password"/>
            <form:errors path="password" cssClass="error"/>

            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>