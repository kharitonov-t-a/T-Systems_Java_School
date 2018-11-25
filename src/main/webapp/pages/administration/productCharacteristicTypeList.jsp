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

                    <div class="form-group">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block" id="createCharacteristicBtn">
                                Create new product characteristic type
                            </button>
                        </div>
                    </div>

                    <div class="modal fade bd-example-modal-lg" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">${modalTitle}</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div id="content-modal-box"></div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" id="modalCharacteristicFormButton">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">Product Characteristic Type</span></div>
                        <table class="table table-hover" id="list-table">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Measure</th>
                                <th>Characteristic Type</th>
                                <th>Checkbox Name Values</th>
                                <th>Category</th>
                                <th width="100"></th>
                                <th width="100"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productCharacteristicTypeDTOList}" var="productCharacteristicType">
                                <tr>
                                    <td>${productCharacteristicType.name}</td>
                                    <td>${productCharacteristicType.measure.toString()}</td>
                                    <td>${productCharacteristicType.characteristicType.name()}</td>
                                    <td><c:forEach items="${productCharacteristicType.productCharacteristicCheckboxFieldList}"
                                                   var="checkboxCharacteristicName">
                                        / ${checkboxCharacteristicName.value}
                                    </c:forEach> /
                                    </td>
                                    <td>${productCharacteristicType.productCategory.name}</td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                        <td>
                                            <a href="<c:url value='/product/characteristic/type/${productCharacteristicType.id}' />"
                                               class="btn btn-success custom-width btn-edit-productCharacteristic">edit</a>
                                        </td>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td>
                                            <a href="<c:url value='/product/characteristic/type/${productCharacteristicType.id}' />"
                                               class="btn btn-danger custom-width btn-delete-productCharacteristic">delete</a>
                                        </td>
                                    </sec:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
