<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 14.10.2018
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="col-md-12">

        <c:url value="/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post" class="form-horizontal">
            <h2 class="form-signin-heading">
                ${message}
            </h2>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <div class="form-group row">
                <label class="col-sm-2 control-label" for="inputEmail">Email userAddress</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="email" id="inputEmail" placeholder="Email userAddress" required autofocus>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 control-label" for="inputPassword">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password" required>
                </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Log in!
            </button>
        </form>
    </div>
</header>
</body>
</html>
