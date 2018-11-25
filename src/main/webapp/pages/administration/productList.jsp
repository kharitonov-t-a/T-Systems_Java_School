<%--
  Created by IntelliJ IDEA.
  User: trinita
  Date: 11/22/18
  Time: 2:03 PM
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
            <div class="col-md-12" id="product">

                <div class="form-horizontal">

                    <h2 class="form-signin-heading">
                        Product
                    </h2>

                    <div class="form-group">
                        <div class="col-sm-12">
                            <button class="btn btn-lg btn-primary btn-block" id="createProductButton">
                                Create new product
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
                                    <button type="button" class="btn btn-primary" id="modalProductFormButton">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading"><span class="lead">Products</span></div>
                        <table class="table table-hover" id="list-table">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Character code</th>
                                <th>Price</th>
                                <th>Stock quantity</th>
                                <th>Category</th>
                                <th width="100"></th>
                                <th width="100"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${productDTOList}" var="productDTO">
                                <tr>
                                    <td>${productDTO.name}</td>
                                    <td>${productDTO.characterCode}</td>
                                    <td>${productDTO.price}</td>
                                    <td>${productDTO.stockQuantity}</td>
                                    <td>${productDTO.productCategory.name}</td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
                                        <td>
                                            <a href="<c:url value='/product/${productDTO.id}' />"
                                               class="btn btn-success custom-width btn-edit-product">edit</a>
                                        </td>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td>
                                            <a href="<c:url value='/product/${productDTO.id}' />"
                                               class="btn btn-danger custom-width btn-delete-product">delete</a>
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
