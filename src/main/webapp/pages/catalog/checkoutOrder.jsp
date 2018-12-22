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
    <script src="<c:url value="/resources/js/checkoutOrder.js" />"></script>
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
                        <table class="table table-bordered shoppingCart">
                            <thead>
                            <tr>
                                <%--<td class="text-center">Image</td>--%>
                                <td class="text-left">Product Name</td>
                                <%--<td class="text-left">Model</td>--%>
                                <td class="text-left">Count</td>
                                <td class="text-right">Unit Price</td>
                                <td class="text-right">Total</td>
                                <td class="text-right"></td>
                            </tr>
                            </thead>
                            <tbody class="shCrt">
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
                                    <td class="text-left">
                                        <div class="input-group mb-3 countProductAction">
                                            <div class="input-group-prepend">
                                                <button class="btn btn-outline-secondary reduceCountProduct"
                                                        type="button"
                                                        productId="${orderProduct.product.id}">
                                                    -
                                                </button>
                                            </div>
                                            <input type="text" class="form-control countProductAdd"
                                                   placeholder="" aria-label=""
                                                   aria-describedby="basic-addon1"
                                                   max="${orderProduct.product.stockQuantity}"
                                                   min="1" value="${orderProduct.count}"
                                                   disabled="disabled">
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-secondary increaseCountProduct"
                                                        type="button"
                                                        productId="${orderProduct.product.id}">
                                                    +
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right unitPrice">${orderProduct.price}</td>
                                    <td class="text-right totalPrice">
                                            ${orderProduct.count * orderProduct.price}
                                    </td>
                                    <td class="text-right">
                                        <a class="btn btn-success deleteOrderProduct"
                                           href="<c:url value="/deleteProductInOrder" />"
                                           role="button" productId="${orderProduct.product.id}">Delete</a>
                                    </td>
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

                    <%--@elvariable id="orderDTO" type="com.web.shop.dto.order.OrderDTO"--%>
                    <form:form modelAttribute="orderDTO" method="post" class="form-horizontal">


                    <div class="accordion-cart">
                        <div class="panel-group" id="accordion">


                            <sec:authorize access="isAnonymous()">
                                <div class="panel panel_default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a class="accordion-trigger" data-toggle="collapse"
                                               data-parent="#userProfile" href="#userProfile">User profile<i
                                                    class="fa fa-caret-down"></i> </a>
                                        </h4>
                                    </div>
                                    <div id="userProfile" class="collapse show">
                                        <div class="panel-body">
                                            <div class="col-md-3">
                                                <p>Enter registration info</p>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.email">Email</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="user.email"
                                                                    placeholder="Email"
                                                                    required="true" path="user.email"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.email"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.password">Password</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="password" class="form-control"
                                                                    name="user.password"
                                                                    placeholder="Password"
                                                                    required="true" path="user.password"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.password"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.confirmPassword">Confirm password</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="password" class="form-control"
                                                                    name="user.confirmPassword"
                                                                    placeholder="Confirm password"
                                                                    required="true" path="user.confirmPassword"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.confirmPassword"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.firstName">First name</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="user.firstName"
                                                                    placeholder="First name"
                                                                    required="true" path="user.firstName"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.firstName"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.lastName">Last name</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="text" class="form-control"
                                                                    name="user.lastName"
                                                                    placeholder="Last name"
                                                                    required="true" path="user.lastName"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.lastName"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="user.birthday">Birthday</label>
                                                    <div class="form-group col-md-12">
                                                        <form:input type="date" class="form-control"
                                                                    name="user.birthday"
                                                                    placeholder="Birthday"
                                                                    required="true" path="user.birthday"
                                                                    max="1999-12-31"
                                                                    id="birthdayInput"/>
                                                        <div class="has-error">
                                                            <form:errors path="user.birthday"
                                                                         class="help-inline"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </sec:authorize>

                            <!-- Start UserAddress -->
                            <div class="panel panel_default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a class="accordion-trigger" data-toggle="collapse"
                                           data-parent="#userAddress" href="#userAddress">Address<i
                                                class="fa fa-caret-down"></i> </a>
                                    </h4>
                                </div>
                                <div id="userAddress" class="collapse show">
                                    <div class="panel-body">
                                        <div class="col-md-3">
                                            <p>Select or enter an userAddress.</p>
                                        </div>
                                        <div class="col-md-3">
                                            <sec:authorize access="!isAnonymous()">
                                                <div class="custom-control custom-radio custom-control-inline">
                                                    <input type="radio" class="custom-control-input" name="addressRadio"
                                                           id="addressRadio1"/>
                                                    <label class="custom-control-label" for="addressRadio1">Select
                                                        address</label>
                                                </div>
                                            </sec:authorize>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" checked="checked" class="custom-control-input"
                                                       name="addressRadio" id="addressRadio2"/>
                                                <label class="custom-control-label" for="addressRadio2">Create new
                                                    address</label>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <sec:authorize access="!isAnonymous()">
                                                <div class="row">
                                                    <label class="col-md-3 control-lable"
                                                           for="userAddress">Address</label>
                                                    <div class="form-group col-md-12">
                                                            <%--<form:select path="userAddress" class="form-control input-sm" multiple="false" disabled="true">--%>
                                                            <%--<form:options items='${userAddressDTOList}' itemLabel="fullAddress"/>--%>
                                                            <%--</form:select>--%>

                                                        <form:select path="userAddress.id" class="form-control input-sm"
                                                                     multiple="false" disabled="true">
                                                            <c:forEach var="field" items="${userAddressDTOList}">
                                                                <form:option value="${field.id}">
                                                                    ${field.fullAddress}
                                                                </form:option>
                                                            </c:forEach>
                                                        </form:select>

                                                    </div>
                                                </div>
                                            </sec:authorize>
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
                                                       for="userAddress.flat">Flat</label>
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
                                                       for="userAddress.zip">ZIP</label>
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
                                        <a class="accordion-trigger" data-toggle="collapse"
                                           data-parent="#accordion" href="#shipping">Payment and Delivery<i
                                                class="fa fa-caret-down"></i> </a>
                                    </h4>
                                </div>
                                <div id="shipping" class="collapse show">
                                    <div class="panel-body">
                                        <div class="col-md-12">
                                            <p>Enter your way paymentType and deliveryType.</p>
                                        </div>
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label"><sup>*</sup>Payment</label>
                                                <div class="col-md-10">
                                                    <form:select path="paymentType" class="form-control input-sm"
                                                                 multiple="false">
                                                        <form:options
                                                                items="${com.web.shop.model.enums.PaymentType.values()}"
                                                                itemLabel="payment"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 control-label"><sup>*</sup>Delivery</label>
                                                <div class="col-md-10">
                                                    <form:select path="deliveryType" class="form-control input-sm"
                                                                 multiple="false">
                                                        <form:options
                                                                items="${com.web.shop.model.enums.DeliveryType.values()}"
                                                                itemLabel="delivery"/>

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
                        <div class="col-sm-1 col-sm-offset-8">
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
                                    <td class="text-right megaTotalPrice"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="shopping-checkout">
                        <a href="#" class="btn btn-default pull-left">Continue Shopping</a>
                        <button ${cartIsEmpty == true ? "disabled title=\"Cart is empty\"":""}
                                class="btn btn-primary pull-right" type="submit">Checkout
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Shopping-Cart -->

        </form:form>
    </div>
</section>
</body>
</html>