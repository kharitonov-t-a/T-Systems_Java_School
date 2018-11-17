<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                <td class="text-left">id</td>
                                <td class="text-left">deliveryType</td>
                                <td class="text-left">paymentType</td>
                                <td class="text-left">order status</td>
                                <td class="text-left">paymentType status</td>
                                <td class="text-left">products</td>
                                <%--<td class="text-left">Quantity</td>--%>
                                <%--<td class="text-right">products</td>--%>
                                <%--<td class="text-right">Total</td>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderList}" var="order">
                                <tr>
                                    <td class="text-left">
                                        <a href="#">${order.id}</a>
                                    </td>
                                    <td class="text-left">
                                        <a href="#">${order.deliveryType.getDelivery()}</a>
                                    </td>
                                    <td class="text-left">
                                        <a href="#">${order.paymentType.getPayment()}</a>
                                    </td>
                                    <td class="text-left">
                                        <a href="#">${order.orderStatus.getOrderStatus()}</a>
                                    </td>
                                    <td class="text-left">
                                        <a href="#">${order.paymentStatus.getPaymentStatus()}</a>
                                    </td>
                                    <td class="text-left">
                                        <c:forEach items="${order.orderProductList}" var="orderProductList">
                                            <a href="#">${orderProductList.product.name} by $${orderProductList.price}</a> /
                                        </c:forEach>
                                    </td>
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
