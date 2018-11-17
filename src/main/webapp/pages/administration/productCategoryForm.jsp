<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 16.11.2018
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--@elvariable id="productCategory" type="com.web.shop.dto.product.ProductCategoryDTO"--%>
<form:form modelAttribute="productCategory" method="post" class="form-horizontal">
    <div id="content-productCategory">
        <div class="form-group row">
            <label class="col-sm-2 control-label" for="name">Category name</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" name="name" placeholder="Name"
                            autofocus="true" required="true" path="name"/>
                <div class="has-error">
                    <form:errors path="name" class="help-inline"></form:errors>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label" for="characterCode">Character code</label>
            <div class="col-sm-10">
                <div class="input-group mb-3">
                    <form:input type="text" class="form-control" name="characterCode" placeholder="Character code"
                                autofocus="true" required="true" path="characterCode" disabled="true" aria-describedby="characterCodeButton"/>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="characterCodeButton">Change</button>
                    </div>
                </div>
                <div class="has-error">
                    <form:errors path="name" class="help-inline"></form:errors>
                </div>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            ${buttonName}
        </button>
    </div>
</form:form>