$<%--
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
<header class="header">

    <div class="container" style="max-width: 800px;">
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
            <div class="row">
                <div class="form-group col-md-12">
                    <input type="text" class="form-control" name="email" placeholder="Email address" required autofocus>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Войти
            </button>
        </form>
    </div>
</header>
</body>
</html>
