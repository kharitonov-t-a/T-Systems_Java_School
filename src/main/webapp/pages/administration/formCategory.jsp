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

        <%--@elvariable id="productsCategoryDTO" type="com.web.shop.dto.products.ProductsCategoryDTO"--%>
        <form:form modelAttribute="productsCategoryDTO" method="post" class="form-horizontal">

            <h2 class="form-signin-heading">
                Create products category
            </h2>

            <div class="row">
                <label class="col-md-3 control-lable" for="name">Name</label>
                <div class="form-group col-md-12">
                    <form:input type="text" class="form-control" name="name" placeholder="Name"
                                autofocus="true" required="true" path="namie"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>

            <div class="row">
                <label class="col-md-3 control-lable" for="parent">Parent</label>
                <div class="form-group col-md-12">
                    <form:select path="parent" class="custom-select" name="parent">
                        <c:forEach var="field" items="${productsCategory}">
                            <form:option value="${field.id}">
                                <c:forEach var="space" begin="1" end="${field.level}">
                                    &emsp;
                                </c:forEach>
                                ${field.name}
                            </form:option>
                        </c:forEach>
                    </form:select>
                    <div class="has-error">
                        <form:errors path="parent" class="help-inline"/>
                    </div>
                </div>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Create
            </button>
        </form:form>

        <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
        <%--<label class="col-md-3 control-lable" for="userProfiles">Roles</label>--%>
        <%--<div class="col-md-7">--%>
        <%--<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id"--%>

        <%--itemLabel="type" class="form-control input-sm" />--%>
        <%--<div class="has-error">--%>
        <%--<form:errors path="userProfiles" class="help-inline"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</header>
</body>
</html>
