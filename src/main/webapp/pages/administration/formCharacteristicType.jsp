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
    <script src="<c:url value="/resources/js/productCharacteristicType.js" />"></script>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>
<section class="page-content">
    <div class="container">
        <div style="max-width: 800px;" id="content-profile-box">
            <div class="col-md-12">
                <%--@elvariable id="productCharacteristicTypeDTO" type="com.web.shop.dto.product.ProductCharacteristicTypeDTO"--%>
                <form:form modelAttribute="productCharacteristicTypeDTO" method="post" class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Create product productCharacteristicList
                    </h2>

                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" name="name" placeholder="Name"
                                        autofocus="true" required="true" path="name"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="name">Measure</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" name="measure" placeholder="Measure"
                                        autofocus="true" required="true" path="measure"/>
                            <div class="has-error">
                                <form:errors path="measure" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="productCharacteristicType">Characteristic type</label>
                        <div class="col-sm-10">
                                <%--<form:select path="productCharacteristicType" items="${productCharacteristicType}" multiple="false"--%>

                                <%--itemLabel="productCharacteristicType" class="form-control input-sm"/>--%>
                            <form:select path="productCharacteristicType" class="form-control input-sm" multiple="false">
                                <%--<form:option value="-" label="--Please Select"/>--%>
                                <form:options items="${productCharacteristicType}"/>
                            </form:select>
                            <div class="has-error">
                                <form:errors path="productCharacteristicType" class="help-inline"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-lable">Checkbox Characteristic Name Values</label>
                        <div class="col-sm-10" id="checkbox-values">
                            <input type="text" class="form-control" name="checkboxCharacteristicNameValuesString"
                                   placeholder="Checkbox Name Values"/>
                            <input type="text" class="form-control" name="checkboxCharacteristicNameValuesString"
                                   placeholder="Checkbox Name Values"/>
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
