<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 22.10.2018
  Time: 12:24
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
    <div class="container" style="" id="content-profile-box">
        <div class="alert alert-danger">
            <p>${message}</p>
        </div>
    </div>
</header>
</body>
</html>
