<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 05.11.2018
  Time: 23:19
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
<header class="header">
    <div class="container" style="max-width: 800px;" id="content-profile-box">

        <%--@elvariable id="productDTO" type="com.web.shop.dto.products.ProductDTO"--%>
        <form:form modelAttribute="productDTO" method="post" class="form-horizontal">

            <h2 class="form-signin-heading">
                Create product
            </h2>

            <div class="row">
                <label class="col-md-3 control-lable" for="name">Name</label>
                <div class="form-group col-md-12">
                    <form:input type="text" class="form-control" name="name" placeholder="Name"
                                autofocus="true" required="true" path="name"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>

            <div class="row">
                <label class="col-md-3 control-lable" for="name">Price</label>
                <div class="form-group col-md-12">
                    <form:input type="number" class="form-control" name="price" placeholder="Price"
                                required="true" path="price"/>
                    <div class="has-error">
                        <form:errors path="price" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>

            <div class="row">
                <label class="col-md-3 control-lable" for="stockQuantity">Stock quantity</label>
                <div class="form-group col-md-12">
                    <form:input type="number" class="form-control" name="stockQuantity" placeholder="Stock quantity"
                                required="true" path="stockQuantity"/>
                    <div class="has-error">
                        <form:errors path="stockQuantity" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>

            <div class="row">
                <label class="col-md-3 control-lable" for="productsCategory.id">Product category</label>
                <div class="form-group col-md-12">
                    <form:select path="productsCategory.id" class="custom-select" name="id">
                        <c:forEach var="field" items="${listProductsCategoryDTO}">
                            <form:option value="${field.id}">
                                <c:forEach var="space" begin="1" end="${field.level}">
                                    &emsp;
                                </c:forEach>
                                ${field.name}
                            </form:option>
                        </c:forEach>
                    </form:select>
                    <div class="has-error">
                        <form:errors path="productsCategory.id" class="help-inline"/>
                    </div>
                </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Next Step
            </button>
        </form:form>
    </div>
</header>
</body>
</html>
