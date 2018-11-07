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

        <%--@elvariable id="productsCategoryDTO" type="com.web.shop.dto.Products.ProductsCategoryDTO"--%>
        <form:form modelAttribute="productsCategoryDTO" method="post" class="form-horizontal">

            <h2 class="form-signin-heading">
                Delete products category
            </h2>

            <div class="row">
                <label class="col-md-3 control-lable" for="id">Select node</label>
                <div class="form-group col-md-12">
                    <form:select path="id" class="custom-select" name="id">
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
                        <form:errors path="id" class="help-inline"/>
                    </div>
                </div>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Delete
            </button>
        </form:form>
    </div>
</header>
</body>
</html>
