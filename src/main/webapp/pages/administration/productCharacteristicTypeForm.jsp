<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 05.11.2018
  Time: 23:19
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
                <%--@elvariable id="productCharacteristicTypeDTO" type="com.web.shop.dto.product.ProductCharacteristicTypeDTO"--%>
                <form:form modelAttribute="productCharacteristicTypeDTO" method="post" class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Create product characteristic type
                    </h2>

                    <form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>


                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="Name"
                                        autofocus="true" required="true" path="name"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Measure</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="Measure"
                                        autofocus="true" required="true" path="measure"/>
                            <div class="has-error">
                                <form:errors path="measure" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="characteristicType">Characteristic type</label>
                        <div class="col-sm-10">
                                <%--<form:select path="productCharacteristicType" items="${productCharacteristicType}" multiple="false"--%>

                                <%--itemLabel="productCharacteristicType" class="form-control input-sm"/>--%>
                            <form:select path="characteristicType" class="form-control input-sm" multiple="false">
                                <%--<form:option value="-" label="--Please Select"/>--%>
                                <form:options items="${productCharacteristicTypeValues}"/>
                            </form:select>
                            <div class="has-error">
                                <form:errors path="characteristicType" class="help-inline"/>
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
                                                  checked='${productCharacteristicTypeDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
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
                                              checked='${productCharacteristicTypeDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
                                               value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                        <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                    </div>
                                    </c:when>

                                    <c:when test="${productCategoryListElement.level == level}">
                                </li>
                                <li>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <form:radiobutton class="custom-control-input" path="productCategory.id"
                                              checked='${productCharacteristicTypeDTO.productCategory.id == productCategoryListElement.id ? "checked" : ""}'
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

                    <div class="form-group row" ${fn:length(productCharacteristicTypeDTO.productCharacteristicCheckboxFieldList) > 0 ? "" : "style='display: none;'"}>
                        <label class="col-sm-2 control-lable">Checkbox characteristic names</label>
                        <div class="col-sm-10" id="checkbox-values">
                            <c:choose>
                            <c:when test="${fn:length(productCharacteristicTypeDTO.productCharacteristicCheckboxFieldList) > 0}">
                                <c:forEach items="${productCharacteristicTypeDTO.productCharacteristicCheckboxFieldList}" var="productCharacteristicCheckboxField" varStatus="сounter">
                                    <div class="input-group mb-3">
                                        <input type="number" name="productCharacteristicCheckboxFieldList[${сounter.count}].id"
                                               value="${productCharacteristicCheckboxField.id}"
                                               hidden>
                                        <input type="text" class="form-control" name="productCharacteristicCheckboxFieldList[${сounter.count}].value"
                                               value="${productCharacteristicCheckboxField.value}"
                                               placeholder="Checkbox Name Value" aria-label="Checkbox Name Value" aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary close closeProductCharacteristicCheckboxField" type="button" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" name="productCharacteristicCheckboxFieldList[0].value"
                                           placeholder="Checkbox Name Value" aria-label="Checkbox Name Value" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary close closeProductCharacteristicCheckboxField" type="button" aria-label="Close" disabled>
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                </div>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" name="productCharacteristicCheckboxFieldList[1].value"
                                           placeholder="Checkbox Name Value" aria-label="Checkbox Name Value" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary close closeProductCharacteristicCheckboxField" type="button" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                </div>
                            </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

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
