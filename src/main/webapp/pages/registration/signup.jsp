<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 17.10.2018
  Time: 13:12
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
            <div class="hidden" id="successFlag" data="<c:out value="${success}"/>"></div>
            <div class="col-md-12">

                <%--@elvariable id="userDTO" type="com.web.shop.dto.user.UserDTO"--%>
                <form:form modelAttribute="userDTO" method="post" class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Please sign up
                    </h2>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Email</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" name="email" placeholder="Email"
                                        autofocus="true" required="true" path="email"/>
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Password</label>
                        <div class="col-sm-10">
                            <form:input type="password" class="form-control" name="password" placeholder="Password"
                                        required="true"
                                        path="password"/>
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Confirm password</label>
                        <div class="col-sm-10">
                            <form:input type="password" class="form-control" name="confirmPassword"
                                        placeholder="Confirm password"
                                        required="true"
                                        path="confirmPassword"/>
                            <div class="has-error">
                                <form:errors path="confirmPassword" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">First Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" name="firstName" placeholder="First Name"
                                        required="true"
                                        path="firstName"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Last Name</label>
                        <div class="col-sm-10">
                            <form:input type="text" class="form-control" name="lastName" placeholder="Last Name"
                                        path="lastName"/>
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Birthday</label>
                        <div class="col-sm-10">
                            <form:input type="date" class="form-control" name="birthday" placeholder="Birthday"
                                        required="true"
                                        path="birthday" max="1999-12-31" id="birthdayInput"/>
                            <div class="has-error">
                                <form:errors path="birthday" class="help-inline"></form:errors>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Sign up!
                            </button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
