<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 07.11.2018
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<html>
<head>
    <%@ include file="/pages/head.jsp"%>
</head>
<body>
<%@ include file="/pages/navbar.jsp"%>
<header class="header">
    <div class="generic-container">
        <div class="panel panel-default" id="content-profile-box">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">${exceptionMessage}</span></div>
            <table class="table table-hover" id="user-list-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Parent</th>
                    <th>Name</th>
                    <th>LeftKey</th>
                    <th>RightKey</th>
                    <th>Level</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listProductsCategoryDTO}" var="productsCategoryDTO">
                    <tr>
                        <td>${productsCategoryDTO.id}</td>
                        <td>${productsCategoryDTO.parent}</td>
                        <td>${productsCategoryDTO.name}</td>
                        <td>${productsCategoryDTO.leftKey}</td>
                        <td>${productsCategoryDTO.rightKey}</td>
                        <td>${productsCategoryDTO.level}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</header>
</body>
</html>
