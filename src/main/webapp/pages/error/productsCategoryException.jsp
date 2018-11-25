<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 07.11.2018
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>
<div class="panel panel-default" id="content-exception">
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
        <c:forEach items="${listProductCategoryDTO}" var="productCategoryDTO">
            <tr>
                <td>${productCategoryDTO.id}</td>
                <td>${productCategoryDTO.parent}</td>
                <td>${productCategoryDTO.name}</td>
                <td>${productCategoryDTO.leftKey}</td>
                <td>${productCategoryDTO.rightKey}</td>
                <td>${productCategoryDTO.level}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
