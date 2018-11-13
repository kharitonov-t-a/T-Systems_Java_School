<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 05.11.2018
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
    <script src="<c:url value="/resources/js/productCharacteristic.js" />"></script>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>
<header class="header">
    <div class="container" style="max-width: 800px;" id="content-profile-box">
        <h2 class="form-signin-heading">
            Add new product characteristic
        </h2>

        <div id="list-characteristic-box">
            <table class="table table-hover" id="user-list-table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>CharacteristicType</th>
                    <th></th>
                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                    <th></th>
                    </sec:authorize>
                </tr>
                <c:forEach var="field" items="${listProductCharacteristic}">
                    <tr>
                        <td>${field.id}</td>
                        <td>${field.productCharacteristicType.name}</td>
                        <td>
                            <c:if test="${CharacteristicTypeEnum.BOOLEAN.compareTo(field.productCharacteristicType.characteristicType) == 0}">
                                ${field.booleanCharacteristicValue}
                            </c:if>
                            <c:if test="${CharacteristicTypeEnum.INTEGER.compareTo(field.productCharacteristicType.characteristicType) == 0}">
                                ${field.integerCharacteristicValue}
                            </c:if>
                            <c:if test="${CharacteristicTypeEnum.DOUBLE.compareTo(field.productCharacteristicType.characteristicType) == 0}">
                                ${field.doubleCharacteristicValue}
                            </c:if>
                            <c:if test="${CharacteristicTypeEnum.STRING.compareTo(field.productCharacteristicType.characteristicType) == 0}">
                                ${field.stringCharacteristicValue}
                            </c:if>
                            <c:if test="${CharacteristicTypeEnum.CHECKBOX.compareTo(field.productCharacteristicType.characteristicType) == 0}">
                                <c:forEach var="fieldCheckbox"
                                           items="${field.productCharacteristicType.checkboxCharacteristicNameValues}">
                                    <c:if test="${field.checkboxCharacteristicValuesInteger.contains(fieldCheckbox.id)}">
                                        ${fieldCheckbox.name} |
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                            <td><a href="<c:url value='/edit-user-${user.id}' />"
                                   class="btn btn-success custom-width btn-edit-user">edit</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>

        <select class="custom-select" name="ProductCharacteristicType" id="ProductCharacteristicType">
            <c:forEach var="field" items="${listProductCharacteristicTypeDTO}">
                <option value="${field.id}">
                    Name: ${field.name} | Measure: ${field.measure} | Type: ${field.characteristicType}
                </option>
            </c:forEach>
        </select>
        <button class="btn btn-lg btn-primary btn-block" id="ProductCharacteristicTypeButton"
                attrIdProduct="${idProduct}">
            Add product characteristic
        </button>

        <div id="product-characteristic-addform-box">

        </div>
    </div>
</header>
</body>
</html>
