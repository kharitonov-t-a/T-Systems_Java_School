<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 23.10.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <%@ include file="/pages/head.jsp"%>
    <script src="<c:url value="/resources/js/profile.js" />"></script>
    <script src="<c:url value="/resources/js/characteristicType.js" />"></script>
    <script src="<c:url value="/resources/js/productCharacteristic.js" />"></script>
</head>
<body>
<%@ include file="/pages/navbar.jsp"%>
<header class="header">
        <div class="row">
            <div class="col-sm-4">
                <div class="list-group" id="profile-menu">
                    <a href="<c:url value="/editCurrentUser" />" class="list-group-item list-group-item-action active" id="edit-current-user">
                        Edit user
                    </a>
                    <a href="<c:url value="/editPassword" />" class="list-group-item list-group-item-action" id="edit-password">
                        Edit password
                    </a>
                    <a href="<c:url value="/orderList" />" class="list-group-item list-group-item-action">
                        Orders list
                    </a>
                    <a href="<c:url value="/allOrders" />" class="list-group-item list-group-item-action">
                        All orders
                    </a>
                    <a href="<c:url value="/formCategory" />" class="list-group-item list-group-item-action">
                        Create products category
                    </a>
                    <a href="<c:url value="/formDeleteCategory" />" class="list-group-item list-group-item-action">
                        Delete products category
                    </a>
                    <a href="<c:url value="/formCharacteristicType" />" class="list-group-item list-group-item-action">
                        Create product Characteristic
                    </a>
                    <a href="<c:url value="/formDeleteCharacteristicType" />" class="list-group-item list-group-item-action">
                        Delete product Characteristic
                    </a>
                    <a href="<c:url value="/formProduct" />" class="list-group-item list-group-item-action">
                        Create product
                    </a>
                    <a href="<c:url value="/formDeleteProduct" />" class="list-group-item list-group-item-action">
                        Delete product
                    </a>
                    <a href="<c:url value="/userslist" />" class="list-group-item list-group-item-action" id="get-users-list-box">
                        Users list for admin
                    </a>
                </div>
            </div>
            <div class="col-sm-7">
                <div id="body-profile-user">

                </div>
            </div>

        </div>


</header>

</body>
</html>
