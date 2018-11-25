<%--
  Created by IntelliJ IDEA.
  User: trinita
  Date: 11/22/18
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <div class="hidden" id="successFlag" data="<c:out value="${success}"/>"></div>
            <div class="col-md-12">
                <%--@elvariable id="productDTO" type="com.web.shop.dto.product.ProductDTO"--%>
                <form:form modelAttribute="productDTO" method="post" class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Create product
                    </h2>

                    <form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>


                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="Name" id="nameField"
                                        autofocus="true" required="true" path="name"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label" for="characterCode">Character code</label>
                        <div class="col-sm-10">
                            <div class="input-group mb-3">
                                <form:input type="text" class="form-control" name="characterCode" placeholder="Character code"
                                            required="true" path="characterCode"
                                            aria-describedby="characterCodeButton"/>
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="button" id="characterCodeButton">Change</button>
                                </div>
                            </div>
                            <div class="has-error">
                                <form:errors path="characterCode" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Price</label>
                        <div class="col-sm-10">
                            <form:input type="number" class="form-control" placeholder="Price"
                                        autofocus="true" required="true" path="price"/>
                            <div class="has-error">
                                <form:errors path="price" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Category</label>
                        <div class="col-md-12">
                            <ul class="treeview">
                                <c:set var="level" value="${0}"/>
                                <c:forEach items="${productCategoryList}" var="productCategoryListElement">
                                <c:choose>

                                <c:when test="${productCategoryListElement.level == level + 1 }">
                                <ul>
                                    <li>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <form:radiobutton class="custom-control-input" path="productCategory.id"
                                                              checked='${productDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
                                                              value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>

                                            <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                        </div>
                                        <c:set var="level" value="${level + 1}"/>
                                        </c:when>

                                        <c:when test="${productCategoryListElement.level < level}">
                                        <c:forEach begin="${productCategoryListElement.level}" end="${level - 1}">
                                    </li>
                                </ul>
                                </c:forEach>
                                <c:set var="level" value="${productCategoryListElement.level}"/>
                                </li>
                                <li>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <form:radiobutton class="custom-control-input" path="productCategory.id"
                                                          checked='${productDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
                                                          value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                        <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                    </div>
                                    </c:when>

                                    <c:when test="${productCategoryListElement.level == level}">
                                </li>
                                <li>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <form:radiobutton class="custom-control-input" path="productCategory.id"
                                                          checked='${productDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
                                                          value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                        <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                    </div>
                                    </c:when>

                                    </c:choose>

                                    </c:forEach>

                                    <c:if test="${level > 0}">
                                    <c:forEach begin="${2}" end="${level}">
                                </li>
                            </ul>
                            </c:forEach>
                            </c:if>
                            </ul>
                        </div>
                    </div>

                    <div id="sub-content-modal-box"></div>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">
                        Create
                    </button>
                </form:form>

                <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="userProfileSet">Roles</label>--%>
                <%--<div class="col-md-7">--%>
                <%--<form:select path="userProfileSet" items="${roles}" multiple="true" itemValue="id"--%>

                <%--itemLabel="type" class="form-control input-sm" />--%>
                <%--<div class="has-error">--%>
                <%--<form:errors path="userProfileSet" class="help-inline"/>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</section>
</body>
</html>

