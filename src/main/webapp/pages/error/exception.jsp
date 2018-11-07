<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 02.11.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <%@ include file="/pages/head.jsp"%>
</head>
<body>
<%@ include file="/pages/navbar.jsp"%>
<header class="header">
    <div class="generic-container">
        <h2 class="form-signin-heading">
            ${exception}
        </h2>
    </div>
</header>
</body>
</html>
