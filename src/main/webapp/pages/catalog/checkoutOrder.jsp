<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 11.11.2018
  Time: 18:21
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
        <div class="row">
            <div class="col-md-12">
                <ul class="page-menu">
                    <li><a href="index.html">Home</a></li>
                    <li class="active"><a href="#">Shopping Cart</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <!-- Start Shopping-Cart -->
            <div class="shopping-cart">
                <div class="row">
                    <div class="col-md-12">
                        <div class="cart-title">
                            <h2 class="entry-title">Shopping Cart</h2>
                        </div>
                        <!-- Start Table -->
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <%--<td class="text-center">Image</td>--%>
                                    <td class="text-left">Product Name</td>
                                    <%--<td class="text-left">Model</td>--%>
                                    <%--<td class="text-left">Quantity</td>--%>
                                    <td class="text-right">Unit Price</td>
                                    <%--<td class="text-right">Total</td>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderDTO.orderProducts}" var="orderProduct">
                                    <tr>
                                            <%--<td class="text-center">--%>
                                            <%--<a href="#"><img class="img-thumbnail" src="img/product/cart/2.jpg" alt="#" /></a>--%>
                                            <%--</td>--%>
                                        <td class="text-left">
                                            <a href="#">${orderProduct.product.name}</a>
                                        </td>
                                            <%--<td class="text-left">Product 14</td>--%>
                                            <%--<td class="text-left">--%>
                                            <%--<div class="btn-block cart-put">--%>
                                            <%--<input class="form-control" type="number" placeholder="1" />--%>
                                            <%--<div class="input-group-btn cart-buttons">--%>
                                            <%--<button class="btn btn-primary" data-toggle="tooltip" title="Update" >--%>
                                            <%--<i class="fa fa-refresh"></i>--%>
                                            <%--</button>--%>
                                            <%--<button class="btn btn-danger" data-toggle="tooltip" title="Remove">--%>
                                            <%--<i class="fa fa-times-circle"></i>--%>
                                            <%--</button>--%>
                                            <%--</div>--%>
                                            <%--</div>--%>
                                            <%--</td>--%>
                                        <td class="text-right total-cost">${orderProduct.price}</td>
                                            <%--<td class="text-right">$100.00</td>--%>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- End Table -->
                        <%--<h3 class="title-group-3 gfont-1">What would you like to do next?</h3>--%>
                        <%--<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>--%>
                        <!-- Accordion start -->


                        <%--@elvariable id="orderDTO" type="com.web.shop.dto.orders.OrderDTO"--%>
                        <form:form modelAttribute="orderDTO" method="post" class="form-horizontal">
                        <div class="accordion-cart">
                            <div class="panel-group" id="accordion">
                                <!-- Start Coupon -->
                                    <%--<div class="panel panel_default">--%>
                                    <%--<div class="panel-heading">--%>
                                    <%--<h4 class="panel-title">--%>
                                    <%--<a class="accordion-trigger" data-toggle="collapse" data-parent="#accordion" href="#coupon">Use Coupon Code<i class="fa fa-caret-down"></i> </a>--%>
                                    <%--</h4>--%>
                                    <%--</div>--%>
                                    <%--<div id="coupon" class="collapse in">--%>
                                    <%--<div class="panel-body">--%>
                                    <%--<div class="col-sm-2">--%>
                                    <%--<p>Enter your coupon here</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="input-group">--%>
                                    <%--<input class="form-control" type="text" placeholder="Enter your coupon here" />--%>
                                    <%--<button type="submit" class="btn btn-primary">Apply Coupon</button>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                <!-- End Coupon -->
                                <!-- Start Address -->
                                <div class="panel panel_default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-trigger collapsed" data-toggle="collapse"
                                               data-parent="#address" href="#address">Address<i
                                                    class="fa fa-caret-down"></i> </a>
                                        </h4>
                                    </div>
                                    <div id="address" class="collapse">
                                        <div class="panel-body">
                                            <div class="col-sm-2">
                                                <p>Select or enter an address.</p>
                                            </div>
                                            <div class="input-group">
                                                <form:input type="text" class="form-control" name="address.country"
                                                            placeholder="Country"
                                                            required="true" path="address.country"/>
                                                <form:input type="text" class="form-control" name="address.city"
                                                            placeholder="City"
                                                            required="true" path="address.city"/>
                                                <form:input type="text" class="form-control" name="address.street"
                                                            placeholder="Street"
                                                            required="true" path="address.street"/>
                                                <form:input type="number" class="form-control" name="address.house"
                                                            placeholder="House"
                                                            required="true" path="address.house"/>
                                                <form:input type="number" class="form-control" name="address.flat"
                                                            placeholder="Flat"
                                                            required="true" path="address.flat"/>
                                                <form:input type="number" class="form-control" name="address.zip"
                                                            placeholder="ZIP"
                                                            required="true" path="address.zip"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Start Address -->
                                <!-- Start Shipping -->
                                <div class="panel panel_default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-trigger collapsed" data-toggle="collapse"
                                               data-parent="#accordion" href="#shipping">Payment and Delivery<i
                                                    class="fa fa-caret-down"></i> </a>
                                        </h4>
                                    </div>
                                    <div id="shipping" class="collapse">
                                        <div class="panel-body">
                                            <div class="col-sm-12">
                                                <p>Enter your way payment and delivery.</p>
                                            </div>
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><sup>*</sup>Payment</label>
                                                    <div class="col-sm-10">
                                                        <form:select path="paymentEnum" class="form-control input-sm" multiple="false">
                                                            <form:options items="${com.web.shop.model.enums.PaymentEnum.values()}" itemLabel="payment"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><sup>*</sup>Delivery</label>
                                                    <div class="col-sm-10">
                                                        <form:select path="deliveryEnum" class="form-control input-sm" multiple="false">
                                                            <form:options items="${com.web.shop.model.enums.DeliveryEnum.values()}" itemLabel="delivery"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Start Shipping -->
                            </div>
                        </div>
                        <!-- Accordion end -->
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-8">
                                <table class="table table-bordered">
                                    <tbody>
                                        <%--<tr>--%>
                                        <%--<td class="text-right">--%>
                                        <%--<strong>Sub-Total:</strong>--%>
                                        <%--</td>--%>
                                        <%--<td class="text-right">$145.00</td>--%>
                                        <%--</tr>--%>
                                    <tr>
                                        <td class="text-right">
                                            <strong>Total:</strong>
                                        </td>
                                        <td class="text-right"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="shopping-checkout">
                            <a href="#" class="btn btn-default pull-left">Continue Shopping</a>
                            <a href="#" class="btn btn-primary pull-right" type="submit">Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Shopping-Cart -->

            </form:form>
        </div>
    </div>
</section>
</body>
</html>