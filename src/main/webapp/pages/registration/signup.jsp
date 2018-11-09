<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 17.10.2018
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>
<header class="header">
    <div class="container" style="max-width: 800px;"  id="content-profile-box">

        <%--@elvariable id="userDTO" type="com.web.shop.dto.users.UserDTO"--%>
        <form:form modelAttribute="userDTO" method="post" class="form-horizontal">


            <h2 class="form-signin-heading">
                ${message}
            </h2>

            <c:forEach var="field" items="${userDTO.fieldsMap}">
                <%-- id need only when --%>
                <c:if test="${(edit == true && field.key.compareToIgnoreCase(\"id\") == 0) ||
                ((notEditInfoUser == null || notEditInfoUser == false) && field.key.compareToIgnoreCase(\"id\") != 0 && field.key.compareToIgnoreCase(\"password\") != 0 && field.key.compareToIgnoreCase(\"confirmPassword\") != 0) ||
                ((notEditPassword == null || notEditPassword == false) && field.key.compareToIgnoreCase(\"id\") != 0 && (field.key.compareToIgnoreCase(\"password\") == 0 || field.key.compareToIgnoreCase(\"confirmPassword\") == 0))
                }">
                <div class="row" <c:out value="${field.key.compareToIgnoreCase(\"id\") == 0 ? \"hidden\" : \"\"}"/>>
                    <div class="form-group col-md-12">
                        <form:input path="${field.key}"
                                    type="${field.key.compareToIgnoreCase(\"password\") == 0 || field.key.compareToIgnoreCase(\"confirmPassword\") == 0 ? \"password\" :
                                            field.key.compareToIgnoreCase(\"birthday\") == 0 ? \"date\" :
                                            \"text\"}"
                                    class="form-control" name="${field.key}" placeholder="${field.value}"/>
                                    <%--${field.key.compareToIgnoreCase(\"password\") == 0 ? \"max='1999-12-31'\" : \"\"}"--%>
                        <div class="has-error">
                            <form:errors path="${field.key}" class="help-inline"></form:errors>
                        </div>
                    </div>
                </div>
                </c:if>
            </c:forEach>

            <%--&lt;%&ndash;if we edit user we need id&ndash;%&gt;--%>
            <%--<c:if test="${edit == true}">--%>
                <%--<form:input type="text" class="form-control" name="id" placeholder="ID" hidden="true" path="id"/>--%>
            <%--</c:if>--%>

            <%--&lt;%&ndash;if we edit password we don't show info user&ndash;%&gt;--%>
            <%--<c:if test="${notEditInfoUser == null || notEditInfoUser == false}">--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="text" class="form-control" name="email" placeholder="Email address"--%>
                                <%--autofocus="true" required="true" path="email"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="email" class="help-inline"></form:errors>--%>
                        <%--&lt;%&ndash;Additional error if email already exist&ndash;%&gt;--%>
                        <%--<form:errors class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--</c:if>--%>

            <%--&lt;%&ndash;if we edit user we don't show password&ndash;%&gt;--%>
            <%--<c:if test="${notEditPassword == null || notEditPassword == false}">--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="password" class="form-control" name="password" placeholder="Password"--%>
                                <%--required="true"--%>
                                <%--path="password"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="password" class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="password" class="form-control" name="confirmPassword" placeholder="Confirm password"--%>
                                <%--required="true"--%>
                                <%--path="confirmPassword"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="confirmPassword" class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--</c:if>--%>

            <%--&lt;%&ndash;if we edit password we don't show info user&ndash;%&gt;--%>
            <%--<c:if test="${notEditInfoUser == null ||notEditInfoUser == false}">--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="text" class="form-control" name="firstName" placeholder="First Name"--%>
                                <%--required="true"--%>
                                <%--path="firstName"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="firstName" class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="text" class="form-control" name="surnName" placeholder="Surn Name"--%>
                                <%--path="surnName"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="surnName" class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<form:input type="date" class="form-control" name="birthday" placeholder="Birthday" required="true"--%>
                                <%--path="birthday" max="1999-12-31" id="birthdayInput"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="birthday" class="help-inline"></form:errors>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="form-group col-md-12">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<label class="col-md-3 control-lable" for="userProfiles">Roles</label>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="col-md-7">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id"&ndash;%&gt;--%>

                                     <%--&lt;%&ndash;itemLabel="type" class="form-control input-sm" />&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="has-error">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<form:errors path="userProfiles" class="help-inline"/>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

            <%--</c:if>--%>

            <button class="btn btn-lg btn-primary btn-block" type="submit">
                ${button}
            </button>
            <%--<form:hidden  class="form-control" name="id" placeholder="ID" value="0" path="id"/>--%>
            <%--<form:hidden  class="form-control" name="UserRoleID" placeholder="Role" value="2" path="userRoleID" />--%>
            <%--<form:input class="form-control" name="eMail" placeholder="Email address" path="eMail"/>--%>
            <%--<form:input  class="form-control" name="password" placeholder="Password" path="password"/>--%>
            <%--<form:input  class="form-control" name="firstName" placeholder="First Name" path="firstName" />--%>
            <%--<form:input  class="form-control" name="surnName" placeholder="Surn Name" path="surnName"/>--%>
            <%--<form:input  class="form-control" name="birthday" placeholder="Birthday" path="birthday"/>--%>
            <%--<form:button class="btn btn-lg btn-primary btn-block" type="submit">--%>
            <%--Зарегистрировать!--%>
            <%--</form:button>--%>
        </form:form>
    </div>
</header>
</body>
</html>
