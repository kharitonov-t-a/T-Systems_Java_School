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
<header class="header">
    <div class="container" style="max-width: 800px;"  id="content-profile-box">
        <%--@elvariable id="userDTO" type="com.web.shop.dto.UserDTO"--%>
        <form:form modelAttribute="userDTO" method="post" class="form-horizontal">


            <h2 class="form-signin-heading">
                ${message}
            </h2>

            <%--if we edit user we need id--%>
            <c:if test="${edit == true}">
                <form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>
            </c:if>

            <%--if we edit password we don't show info user--%>
            <c:if test="${notEditInfoUser == null || notEditInfoUser == false}">
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="text" class="form-control" name="email" placeholder="Email address"
                                autofocus="true" required="true" path="email"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"></form:errors>
                        <%--Additional error if email already exist--%>
                        <form:errors class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
            </c:if>

            <%--if we edit user we don't show password--%>
            <c:if test="${notEditPassword == null || notEditPassword == false}">
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="password" class="form-control" name="password" placeholder="Password"
                                required="true"
                                path="password"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="password" class="form-control" name="confirmPassword" placeholder="Confirm password"
                                required="true"
                                path="confirmPassword"/>
                    <div class="has-error">
                        <form:errors path="confirmPassword" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
            </c:if>

            <%--if we edit password we don't show info user--%>
            <c:if test="${notEditInfoUser == null ||notEditInfoUser == false}">
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="text" class="form-control" name="firstName" placeholder="First Name"
                                required="true"
                                path="firstName"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="text" class="form-control" name="surnName" placeholder="Surn Name"
                                path="surnName"/>
                    <div class="has-error">
                        <form:errors path="surnName" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <form:input type="date" class="form-control" name="birthday" placeholder="Birthday" required="true"
                                path="birthday" max="1999-12-31" id="birthdayInput"/>
                    <div class="has-error">
                        <form:errors path="birthday" class="help-inline"></form:errors>
                    </div>
                </div>
            </div>
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

            </c:if>

            <button class="btn btn-lg btn-primary btn-block" type="submit">
                ${button}
            </button>
            <%--<form:hidden  class="form-control" name="id" placeholder="ID" value="0" path="id"/>--%>
            <%--<form:hidden  class="form-control" name="UserRoleID" placeholder="Role" value="2" path="userRoleID" />--%>
            <%--<form:input class="form-control" name="eMail" placeholder="Email address" path="eMail"/>--%>
            <%--<form:input  class="form-control" name="password" placeholder="Password" path="password"/>--%>
            <%--<form:input  class="form-control" name="firstName" placeholder="First Name" path="firstName" />--%>
            <%--<form:input  class="form-control" name="surnName" placeholder="Surn Name" path="surnName"/>--%>
            <%--<form:input  class="form-control" name="birthday" placeholder="Birthday" path="birthday"/>--%>
            <%--<form:button class="btn btn-lg btn-primary btn-block" type="submit">--%>
            <%--Зарегистрировать!--%>
            <%--</form:button>--%>
        </form:form>
    </div>
</header>
</body>
</html>
