<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 23.10.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
    <script src="<c:url value="/resources/js/profile.js" />"></script>
    <%--<script src="<c:url value="/resources/js/productCharacteristicList.js" />"></script>--%>
    <script src="<c:url value="/resources/js/productCategory.js" />"></script>
    <script src="<c:url value="/resources/js/productCharacteristicType.js" />"></script>
    <script src="<c:url value="/resources/js/user.js" />"></script>
    <script src="<c:url value="/resources/js/product.js" />"></script>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>
<!-- START PAGE-CONTENT -->
<section class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="page-menu">
                    <li><a href="index.html">Home</a></li>
                    <li class="active"><a href="my-account.html">My Account</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <!-- PROFILE-MENU-LIST START -->
                <div class="left-productCategory-menu">
                    <div class="left-product-cat">
                        <div class="productCategory-heading ">
                            <h2>profile</h2>
                        </div>
                        <div class="productCategory-menu-list list-group"  id="profile-menu">
                            <ul>
                                <li><a href="<c:url value="/user" />" class="list-group-item active">
                                    Edit user
                                </a></li>
                                <li><a href="<c:url value="/user/password" />" class="list-group-item">
                                    Edit password
                                </a></li>
                                <%--<li><a href="<c:url value="/orderList" />" class="list-group-item">--%>
                                    <%--Orders list--%>
                                <%--</a></li>--%>
                                <%--<li><a href="<c:url value="/allOrders" />" class="list-group-item">--%>
                                    <%--All orderList--%>
                                <%--</a></li>--%>
                                <li><a href="<c:url value="/productCategory/list" />" class="list-group-item">
                                    Products category
                                </a></li>
                                <li><a href="<c:url value="/product/characteristic/type/list" />" class="list-group-item">
                                    Product Characteristic Type
                                </a></li>
                                <li><a href="<c:url value="/product/list" />" class="list-group-item">
                                    Products
                                </a></li>
                                <li><a href="<c:url value="/user/list" />" class="list-group-item list-group-item-action">
                                    Users list for admin
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- END PROFILE-MENU-LIST -->
            <div class="col-md-9 col-xs-12">
                <div id="body-profile-user">

                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
