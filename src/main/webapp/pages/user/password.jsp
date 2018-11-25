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
                <form:form modelAttribute="userDTO" method="post" class="form-horizontal userForm">

                    <h2 class="form-signin-heading">
                        Change password
                    </h2>

                    <form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>

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
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Change!
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
