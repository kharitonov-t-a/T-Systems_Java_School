<%--
  Created by IntelliJ IDEA.
  User: trinita
  Date: 12/12/18
  Time: 8:38 PM
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
                        Addresses
                    </h2>

                    <div class="form-group">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block" id="createUserAddressBtn">
                                Create new address
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
                                    <button type="button" class="btn btn-primary" id="modalUserAddressFormButton">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">Addres</span></div>
                        <table class="table table-hover" id="list-table">
                            <thead>
                            <tr>
                                <th>Country</th>
                                <th>City</th>
                                <th>Street</th>
                                <th>House</th>
                                <th>Flat</th>
                                <th>ZIP</th>
                                <th width="100"></th>
                                <th width="100"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${userAddressDTOList}" var="userAddress">
                                <tr>
                                    <td>${userAddress.country}</td>
                                    <td>${userAddress.city}</td>
                                    <td>${userAddress.street}</td>
                                    <td>${userAddress.house}</td>
                                    <td>${userAddress.flat}</td>
                                    <td>${userAddress.zip}</td>
                                    <td>
                                        <a href="<c:url value='/user/address/${userAddress.id}' />"
                                           class="btn btn-success custom-width btn-edit-userAddress">edit</a>
                                    </td>
                                    <td>
                                        <a href="<c:url value='/user/address/${userAddress.id}' />"
                                           class="btn btn-danger custom-width btn-delete-userAddress">delete</a>
                                    </td>
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
