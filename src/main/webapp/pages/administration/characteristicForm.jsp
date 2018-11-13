<%@ page import="com.web.shop.model.enums.CharacteristicTypeEnum" %><%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 09.11.2018
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="productCharacteristicDTO" type="com.web.shop.dto.products.ProductCharacteristicDTO"--%>
<form:form modelAttribute="productCharacteristicDTO" method="post" class="form-horizontal">

    <form:hidden name="productCharacteristicTypeId" required="true" path="productCharacteristicType.id" value="${productCharacteristicTypeDTO.id}"/>
    <form:hidden name="productId" required="true" path="product.id" value="${productId}"/>

    <div class="row">
        <label class="col-md-3 control-lable">${productCharacteristicTypeDTO.name}</label>
        <div class="form-group col-md-12">
            <c:if test="${CharacteristicTypeEnum.BOOLEAN.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                <form:radiobutton class="form-control" path="booleanCharacteristicValue" value="true" name="booleanCharacteristicValue"/>Yes
                <form:radiobutton class="form-control" path="booleanCharacteristicValue" value="false" name="booleanCharacteristicValue"/>No
                <div class="has-error">
                    <form:errors path="booleanCharacteristicValue" class="help-inline"></form:errors>
                </div>
            </c:if>
            <c:if test="${CharacteristicTypeEnum.INTEGER.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                <form:input type="number" class="form-control" path="integerCharacteristicValue" name="integerCharacteristicValue"/>
                <div class="has-error">
                    <form:errors path="integerCharacteristicValue" class="help-inline"></form:errors>
                </div>
            </c:if>
            <c:if test="${CharacteristicTypeEnum.DOUBLE.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                <form:input type="number" class="form-control" path="doubleCharacteristicValue" name="doubleCharacteristicValue"/>
                <div class="has-error">
                    <form:errors path="doubleCharacteristicValue" class="help-inline"></form:errors>
                </div>
            </c:if>
            <c:if test="${CharacteristicTypeEnum.STRING.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                <form:input type="text" class="form-control" path="stringCharacteristicValue" name="stringCharacteristicValue"/>
                <div class="has-error">
                    <form:errors path="stringCharacteristicValue" class="help-inline"></form:errors>
                </div>
            </c:if>
            <c:if test="${CharacteristicTypeEnum.CHECKBOX.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                <c:forEach var="field" items="${productCharacteristicTypeDTO.checkboxCharacteristicNameValues}">
                    <form:checkbox path="checkboxCharacteristicValues[].value" value="${field.id}"/>${field.value}
                </c:forEach>
                <div class="has-error">
                    <form:errors path="checkboxCharacteristicValues" class="help-inline"></form:errors>
                </div>
            </c:if>
        </div>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create
    </button>
</form:form>