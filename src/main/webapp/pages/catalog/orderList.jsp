<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>
<section class="page-content">
    <div class="container">
        <div style="max-width: 800px;" id="content-profile-box">
            <div class="col-md-12">

                <div class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Orders
                    </h2>


                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">Orders</span></div>
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <%--<td class="text-center">Image</td>--%>
                                <td class="text-left">User id</td>
                                <td class="text-left">Delivery type</td>
                                <td class="text-left">Payment type</td>
                                <td class="text-left">Order status</td>
                                <td class="text-left">Payment status</td>
                                <td class="text-left">Products</td>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                    <td class="text-left"></td>
                                </sec:authorize>
                                <%--<td class="text-left">Quantity</td>--%>
                                <%--<td class="text-right">products</td>--%>
                                <%--<td class="text-right">Total</td>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderList}" var="order">
                                <tr>
                                    <td class="text-left">
                                        ${order.user.id}
                                    </td>
                                    <td class="text-left">
                                        ${order.deliveryType.getDelivery()}
                                    </td>
                                    <td class="text-left">
                                        ${order.paymentType.getPayment()}
                                    </td>
                                    <td class="text-left">
                                        ${order.orderStatus.getOrderStatus()}
                                    </td>
                                    <td class="text-left">
                                        ${order.paymentStatus.getPaymentStatus()}
                                    </td>
                                    <td class="text-left">
                                        <c:forEach items="${order.orderProductList}" var="orderProductList">
                                            ${orderProductList.product.name} by $${orderProductList.price} /
                                        </c:forEach>
                                    </td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                        <td>
                                            <div class="btn-group btn-group-toggle btn-group-vertical orderStatusSelect" data-toggle="buttons">
                                                <c:forEach items="${orderStatusList}" var="orderStatus">
                                                    <label class="orderStatusLabel btn btn-secondary ${order.orderStatus == orderStatus ? "active" : ""}">
                                                        <input type="radio" name="orderStatus" id="${order.id}" value="${orderStatus.name()}" autocomplete="off" ${order.orderStatus == orderStatus ? "checked='true'" : ""}> ${orderStatus.orderStatus}
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </sec:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
