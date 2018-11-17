<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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

                <div class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Characteristic type
                    </h2>


                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block">
                                Create new user
                            </button>
                        </div>
                    </div>


                    <!-- Default panel contents -->
                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">${message}</span></div>
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
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>${user.birthday}</td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                        <td><a href="<c:url value='/edit-user-${user.id}' />"
                                               class="btn btn-success custom-width btn-edit-user">edit</a></td>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td><a href="<c:url value='/delete-user-${user.id}' />"
                                               class="btn btn-danger custom-width btn-delete-user">delete</a></td>
                                    </sec:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <sec:authorize access="hasRole('ADMIN')">
                    <%--<div class="well">--%>
                    <%--<a href="<c:url value='/newuser' />">Add New User</a>--%>
                    <%--</div>--%>
                </sec:authorize>
            </div>
        </div>
    </div>
</section>
</body>
</html>
