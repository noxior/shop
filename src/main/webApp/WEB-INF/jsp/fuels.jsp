<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/fuelsDatatables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <br/>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="fuelStation.name"/></th>
                <th><spring:message code="fuel.name"/></th>
                <th><spring:message code="fuel.price"/></th>
                <th></th>
            </tr>
            </thead>
        </table>


        <table class="table table-striped" id="datatableCart">
            <thead>
            <tr>
                <th><spring:message code="cart.fuelStationName"/></th>
                <th><spring:message code="cart.amount"/></th>
                <th><spring:message code="cart.price"/></th>
                <th><spring:message code="cart.fuelName"/></th>
                <th><spring:message code="cart.quantity"/></th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="modal fade" tabindex="-1" id="editCartRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalCartTitle"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsCartForm">

                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="fuelStationName" class="col-form-label"><spring:message
                                code="cart.fuelStationName"/></label>
                        <input type="text" class="form-control" id="fuelStationName" name="fuelStationName"
                               placeholder="<spring:message code="cart.fuelStationName"/>">
                    </div>

                    <div class="form-group">
                        <label for="fuelName" class="col-form-label"><spring:message
                                code="cart.fuelName"/></label>
                        <input type="text" class="form-control" id="fuelName" name="fuelName"
                               placeholder="<spring:message code="cart.fuelName"/>">
                    </div>

                    <div class="form-group">
                        <label for="quantity" class="col-form-label"><spring:message
                                code="cart.quantity"/></label>
                        <input type="number" min="0" step="10" class="form-control" id="quantity"
                               name="quantity"
                               placeholder="<spring:message code="cart.quantity"/>">
                    </div>

                    <div class="form-group">
                        <label for="price" class="col-form-label"><spring:message code="cart.oneLiter"/></label>
                        <input type="number" min="0.00" step="0.01" max="10000.00" readonly class="form-control"
                               id="price" name="price"
                               placeholder="<spring:message code="cart.oneLiter"/>">
                    </div>

                    <div class="form-group">
                        <label for="amount" class="col-form-label"><spring:message code="cart.amount"/></label>
                        <input type="number" min="0.00" step="0.01" max="10000.00" readonly class="form-control"
                               id="amount" name="amount"
                               placeholder="<spring:message code="cart.amount"/>">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    <spring:message code="common.cancel"/>
                </button>
                <button type="button" class="btn btn-primary" onclick="saveCart()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <section>
            <table border="1" cellpadding="8" cellspacing="0" class="table table-striped">
                <thead>
                <tr>
                    <th><spring:message code="orders.date"/></th>
                    <th><spring:message code="orders.amount"/></th>
                    <th><spring:message code="orders.status"/></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="order">
                    <jsp:useBean id="order" scope="page" type="com.shop.fuelcoupons.to.OrderWithSum"/>
                    <tr>

                        <td>
                                ${fn:replace(order.dateTime, 'T', ' ')}
                        </td>
                        <td>${order.amountOrder}</td>
                        <td>${order.status}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/order_details?orderId=${order.id}"
                               class='btn btn-primary'><spring:message code="common.update"/></a>
                        </td>


                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
<jsp:include page="fragments/i18n.jsp">
    <jsp:param name="page" value="cart"/>
</jsp:include>
</html>
