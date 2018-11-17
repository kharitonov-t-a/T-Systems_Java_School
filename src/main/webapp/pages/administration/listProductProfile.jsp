<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 15.11.2018
  Time: 10:05
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
                        Products
                    </h2>

                    <div class="form-group">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block">
                                Create new product
                            </button>
                        </div>
                    </div>

                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">Product Characteristic Type</span></div>
                        <table class="table table-hover" id="user-list-table">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Stock quantity</th>
                                <th>Category</th>
                                <th width="100"></th>
                                <th width="100"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productDTOList}" var="product">
                                <tr>
                                    <td>${product.name}</td>
                                    <td>${product.price}</td>
                                    <td>${product.stockQuantity}</td>
                                    <td>${product.productCategory.name}</td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                        <td><a href="<c:url value='/edit-product-${productCharacteristicType.id}' />"
                                               class="btn btn-success custom-width btn-edit-product">edit</a></td>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td><a href="<c:url value='/delete-product-${productCharacteristicType.id}' />"
                                               class="btn btn-danger custom-width btn-delete-product">delete</a></td>
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
