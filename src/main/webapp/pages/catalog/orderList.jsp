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
    <div id="content-profile-box">
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <%--<td class="text-center">Image</td>--%>
                    <td class="text-left">id</td>
                    <td class="text-left">delivery</td>
                    <td class="text-left">payment</td>
                    <td class="text-left">order status</td>
                    <td class="text-left">payment status</td>
                    <td class="text-left">products</td>
                    <%--<td class="text-left">Quantity</td>--%>
                    <%--<td class="text-right">products</td>--%>
                    <%--<td class="text-right">Total</td>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td class="text-left">
                            <a href="#">${order.id}</a>
                        </td>
                        <td class="text-left">
                            <a href="#">${order.deliveryEnum}</a>
                        </td>
                        <td class="text-left">
                            <a href="#">${order.paymentEnum}</a>
                        </td>
                        <td class="text-left">
                            <a href="#">${order.orderStatusEnum}</a>
                        </td>
                        <td class="text-left">
                            <a href="#">${order.paymentStatusEnum}</a>
                        </td>
                        <td class="text-left">
                            <c:forEach items="${order.orderProducts}" var="orderProducts">
                                <a href="#">${orderProducts.product.name} by $${orderProducts.price}</a> /
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</section>

</body>
</html>
