<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 11.11.2018
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
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
                            <sec:authorize access="isAnonymous()">
                                You are not authenticated. Log in please or sign up in form below.
                            </sec:authorize>
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
                                    <%--<td class="text-right">Total</td>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderSession.orderProductList}" var="orderProduct">
                                    <tr>
                                            <%--<td class="text-center">--%>
                                            <%--<a href="#"><img class="img-thumbnail" src="img/product/cart/2.jpg" alt="#" /></a>--%>
                                            <%--</td>--%>
                                        <td class="text-left">
                                            <a href="#">${orderProduct.product.name}</a>
                                            <c:if test="${!orderProduct.inStock}">
                                                This product is out of stock.
                                            </c:if>
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
                        <%--<p>Choose if you have a discount code or reward points you want to use or would like to estimate your deliveryType cost.</p>--%>
                        <!-- Accordion start -->

                        <c:if test="${fn:length(orderSession.orderProductList) < 0}">
                        <h1>
                            Your cart have not any products.
                        </h1>
                        </c:if>

                        <%--@elvariable id="orderDTO" type="com.web.shop.dto.orderList.OrderDTO"--%>
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
                                <!-- Start UserAddress -->
                                <div class="panel panel_default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-trigger collapsed" data-toggle="collapse"
                                               data-parent="#userAddress" href="#userAddress">Address<i
                                                    class="fa fa-caret-down"></i> </a>
                                        </h4>
                                    </div>
                                    <div id="userAddress" class="collapse">
                                        <div class="panel-body">
                                            <div class="col-sm-2">
                                                <p>Select or enter an userAddress.</p>
                                            </div>
                                            <div class="input-group">

                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.country">Country</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="userAddress.country"
                                                                    placeholder="Country"
                                                                    required="true" path="userAddress.country"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.country"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.city">City</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="userAddress.city"
                                                                    placeholder="City"
                                                                    required="true" path="userAddress.city"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.city"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.street">Street</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="userAddress.street"
                                                                    placeholder="Street"
                                                                    required="true" path="userAddress.street"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.street"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.house">House</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="number" class="form-control"
                                                                    name="userAddress.house"
                                                                    placeholder="House"
                                                                    required="true" path="userAddress.house"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.house"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.house">Flat</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="number" class="form-control"
                                                                    name="userAddress.flat"
                                                                    placeholder="Flat"
                                                                    required="true" path="userAddress.flat"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.flat"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress.house">ZIP</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="number" class="form-control"
                                                                    name="userAddress.zip"
                                                                    placeholder="ZIP"
                                                                    required="true" path="userAddress.zip"/>
                                                        <div class="has-error">
                                                            <form:errors path="userAddress.zip"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Start UserAddress -->
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
                                                <p>Enter your way paymentType and deliveryType.</p>
                                            </div>
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><sup>*</sup>Payment</label>
                                                    <div class="col-sm-10">
                                                        <form:select path="paymentType" class="form-control input-sm"
                                                                     multiple="false">
                                                            <form:options
                                                                    items="${com.web.shop.model.enums.PaymentEnum.values()}"
                                                                    itemLabel="paymentType"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><sup>*</sup>Delivery</label>
                                                    <div class="col-sm-10">
                                                        <form:select path="deliveryType" class="form-control input-sm"
                                                                     multiple="false">
                                                            <form:options
                                                                    items="${com.web.shop.model.enums.DeliveryEnum.values()}"
                                                                    itemLabel="deliveryType"/>
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
                            <button ${cartIsEmpty == true ? "disabled title=\"Cart is empty\"":""}  class="btn btn-primary pull-right" type="submit">Checkout</button>
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