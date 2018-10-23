<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp"%>
</head>
<body>
    <%@ include file="/pages/navbar.jsp"%>
    <header class="header">
        <div class="generic-container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Users </span></div>
                <table class="table table-hover" id="user-list-table">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Surn name</th>
                        <th>Email</th>
                        <th>Birthday</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.surnName}</td>
                            <td>${user.email}</td>
                            <td>${user.birthday}</td>
                            <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                <td><a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-success custom-width">edit</a></td>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN')">
                                <td><a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-danger custom-width btndeleteuser">delete</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <sec:authorize access="hasRole('ADMIN')">
                <%--<div class="well">--%>
                    <%--<a href="<c:url value='/newuser' />">Add New User</a>--%>
                <%--</div>--%>
            </sec:authorize>
        </div>
    </header>
</body>
</html>
