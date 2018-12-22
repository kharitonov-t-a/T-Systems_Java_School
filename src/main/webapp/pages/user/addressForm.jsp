<%--
  Created by IntelliJ IDEA.
  User: trinita
  Date: 12/12/18
  Time: 10:15 PM
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
                <%--@elvariable id="userAddressDTO" type="com.web.shop.dto.user.UserAddressDTO"--%>
                <form:form modelAttribute="userAddressDTO" method="post" class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Create address
                    </h2>

                    <form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>


                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="country">Country</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="Country"
                                        autofocus="true" required="true" path="country"/>
                            <div class="has-error">
                                <form:errors path="country" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="city">City</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="City"
                                        autofocus="true" required="true" path="city"/>
                            <div class="has-error">
                                <form:errors path="city" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="street">Street</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" placeholder="Street"
                                        autofocus="true" required="true" path="street"/>
                            <div class="has-error">
                                <form:errors path="street" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="house">House</label>
                        <div class="col-sm-10">
                            <form:input type="number" class="form-control" placeholder="House"
                                        autofocus="true" required="true" path="house"/>
                            <div class="has-error">
                                <form:errors path="house" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="flat">Flat</label>
                        <div class="col-sm-10">
                            <form:input type="number" class="form-control" placeholder="Flat"
                                        autofocus="true" required="true" path="flat"/>
                            <div class="has-error">
                                <form:errors path="flat" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-lable" for="zip">ZIP</label>
                        <div class="col-sm-10">
                            <form:input type="number" class="form-control" placeholder="ZIP"
                                        autofocus="true" required="true" path="zip"/>
                            <div class="has-error">
                                <form:errors path="zip" class="help-inline"></form:errors>
                            </div>
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
