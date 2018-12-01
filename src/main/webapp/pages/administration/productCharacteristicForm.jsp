<%@ page import="com.web.shop.model.enums.CharacteristicType" %>
<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 09.11.2018
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="productDTO" type="com.web.shop.dto.product.ProductDTO"--%>
<form:form modelAttribute="productDTO" method="post" class="form-horizontal">
    <div id="characteristic-box">
        <c:forEach items="${productCharacteristicTypeDTOList}" var="productCharacteristicTypeDTO" varStatus="counter">

            <%--<c:set var="fieldValue" scope="page" value="" />--%>
            <%--<c:set var="productCharacteristicId" scope="page" value="" />--%>

            <form:input path="productCharacteristicList[${counter.count-1}].productCharacteristicType.id" hidden="true"
                        value="${productCharacteristicTypeDTO.id}"/>
            <form:input type="number" path="productCharacteristicList[${counter.count-1}].id" hidden="true"/>

            <div class="form-group row">
                <label class="col-sm-2 control-lable">${productCharacteristicTypeDTO.name}
                    <c:if test="${productCharacteristicTypeDTO.measure != null && productCharacteristicTypeDTO.measure.length()>0}">
                        , ${productCharacteristicTypeDTO.measure}
                    </c:if>
                </label>
                <div class="col-sm-10">
                    <c:if test="${CharacteristicType.BOOLEAN.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">

                        <div class="custom-control custom-radio custom-control-inline">
                            <form:radiobutton class="custom-control-input"
                                              path="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue"
                                              value="true"
                                              id="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue1"/>
                            <label class="custom-control-label"
                                   for="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue1">Yes</label>
                        </div>

                        <div class="custom-control custom-radio custom-control-inline">
                            <form:radiobutton class="custom-control-input"
                                              path="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue"
                                              value="false"
                                              id="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue2"/>
                            <label class="custom-control-label"
                                   for="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue2">No</label>
                        </div>

                        <div class="has-error">
                            <form:errors path="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue"
                                         class="help-inline"></form:errors>
                        </div>

                    </c:if>

                    <c:if test="${CharacteristicType.INTEGER.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                        <form:input type="number" class="form-control"
                                    path="productCharacteristicList[${counter.count-1}].integerCharacteristicValue"/>
                        <div class="has-error">
                            <form:errors path="productCharacteristicList[${counter.count-1}].integerCharacteristicValue"
                                         class="help-inline"></form:errors>
                        </div>
                    </c:if>

                    <c:if test="${CharacteristicType.DOUBLE.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                        <form:input type="number" class="form-control"
                                    path="productCharacteristicList[${counter.count-1}].doubleCharacteristicValue"/>
                        <div class="has-error">
                            <form:errors path="productCharacteristicList[${counter.count-1}].doubleCharacteristicValue"
                                         class="help-inline"></form:errors>
                        </div>
                    </c:if>

                    <c:if test="${CharacteristicType.STRING.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                        <form:input type="text" class="form-control"
                                    path="productCharacteristicList[${counter.count-1}].stringCharacteristicValue"/>
                        <div class="has-error">
                            <form:errors path="productCharacteristicList[${counter.count-1}].stringCharacteristicValue"
                                         class="help-inline"></form:errors>
                        </div>
                    </c:if>

                    <c:if test="${CharacteristicType.CHECKBOX.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">

                        <c:forEach var="productCharacteristicCheckboxField"
                                   items="${productCharacteristicTypeDTO.productCharacteristicCheckboxFieldList}"
                                   varStatus="countField">

                            <c:set var="fieldValue" scope="page" value=""/>
                            <c:set var="fieldId" scope="page" value=""/>

                            <c:forEach items="${productDTO.productCharacteristicList}" var="productCharacteristicDTO">
                                <c:forEach var="productCharacteristicCheckboxValue"
                                           items="${productCharacteristicDTO.productCharacteristicCheckboxValueList}">
                                    <c:if test="${productCharacteristicCheckboxField.id == productCharacteristicCheckboxValue.productCharacteristicCheckboxField.id}">
                                        <c:set var="fieldValue" scope="page" value="true"/>
                                        <c:set var="fieldId" scope="page"
                                               value="${productCharacteristicCheckboxValue.id}"/>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>

                            <input type="number"
                                   name="productCharacteristicList[${counter.count-1}].productCharacteristicCheckboxValueList[${countField.count-1}].id"
                                   hidden="true" value="${fieldId}"/>
                            <div class="custom-control custom-checkbox">
                                <form:checkbox class="custom-control-input"
                                               path="productCharacteristicList[${counter.count-1}].productCharacteristicCheckboxValueList[${countField.count-1}].productCharacteristicCheckboxField.id"
                                               id="productCharacteristicList[${counter.count-1}].productCharacteristicCheckboxValueList[${countField.count-1}].productCharacteristicCheckboxField.id"
                                               value="${productCharacteristicCheckboxField.id}"
                                               checked="${fieldValue}"
                                />
                                <label class="custom-control-label"
                                       for="productCharacteristicList[${counter.count-1}].productCharacteristicCheckboxValueList[${countField.count-1}].productCharacteristicCheckboxField.id">${productCharacteristicCheckboxField.value}</label>
                            </div>
                        </c:forEach>
                    </c:if>

                </div>
            </div>


        </c:forEach>
            <%--<div class="form-group row">--%>
            <%--<label class="col-sm-2 control-label">${productCharacteristicTypeDTO.name}</label>--%>
            <%--<div class="col-sm-10">--%>

            <%--</div>--%>
            <%--</div>--%>

    </div>
</form:form>