<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 23.10.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <%@ include file="/pages/head.jsp"%>
</head>
<body>
<%@ include file="/pages/navbar.jsp"%>
<header class="header">
        <div class="row">
            <div class="col-sm-4">
                <div class="list-group">
                    <a href="<c:url value="/profile" />" class="list-group-item list-group-item-action">
                        Edit user
                    </a>
                    <a href="<c:url value="/profile" />" class="list-group-item list-group-item-action">
                        Edit password
                    </a>
                    <a href="<c:url value="/profile" />" class="list-group-item list-group-item-action">
                        Orders list
                    </a>
                    <a href="<c:url value="/profile" />" class="list-group-item list-group-item-action">
                        Админка
                    </a>
                    <a href="<c:url value="/profile" />" class="list-group-item list-group-item-action active">
                        Users list for admin
                    </a>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="container-fluid">

                </div>
            </div>

        </div>


</header>

</body>
</html>
