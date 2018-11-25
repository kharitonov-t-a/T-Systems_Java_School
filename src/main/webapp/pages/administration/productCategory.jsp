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
<section class="page-content" id="productCategory">
    <div class="container">
        <div style="max-width: 800px;" id="content-profile-box">
            <div class="col-md-12">

                    <h2 class="form-signin-heading">
                        Products category
                    </h2>

                    <div class="form-group row">
                        <div class="col-sm-4">
                            <button class="btn btn-lg btn-primary btn-block getProductCategoryForm" name="create">
                                Create new category
                            </button>
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-lg btn-primary btn-block getProductCategoryForm" name="edit">
                                Edit category
                            </button>
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-lg btn-primary btn-block deleteCategory" name="delete">
                                Delete category
                            </button>
                        </div>
                    </div>

                    <div id="content-productCategory-box">

                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label treeLabel">Category</label>
                        <div class="col-md-12">
                            <ul class="treeview">
                                <c:set var="level" value="${0}"/>
                                <c:forEach items="${productCategoryList}" var="productCategoryListElement">
                                <c:choose>

                                <c:when test="${productCategoryListElement.level == level + 1 }">
                                <ul>
                                    <li>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="parent" class="custom-control-input"
                                                              value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                            <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                        </div>
                                        <c:set var="level" value="${level + 1}"/>
                                </c:when>

                                <c:when test="${productCategoryListElement.level < level}">
                                <c:forEach begin="${productCategoryListElement.level}" end="${level - 1}">
                                    </li>
                                </ul>
                                </c:forEach>
                                <c:set var="level" value="${productCategoryListElement.level}"/>
                                </li>
                                <li>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio"  class="custom-control-input" name="parent"
                                                          value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                        <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                    </div>
                                </c:when>

                                <c:when test="${productCategoryListElement.level == level}">
                                </li>
                                <li>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio"  class="custom-control-input" name="parent"
                                                          value="${productCategoryListElement.id}" id="productCategoryDTO${productCategoryListElement.id}"/>
                                        <label class="custom-control-label" for="productCategoryDTO${productCategoryListElement.id}">${productCategoryListElement.name}</label>
                                    </div>
                                    </c:when>

                                </c:choose>

                                    </c:forEach>

                                    <c:if test="${level > 0}">
                                    <c:forEach begin="${2}" end="${level}">
                                </li>
                            </ul>
                            </c:forEach>
                            </c:if>
                            </ul>
                        </div>
                    </div>


            </div>
        </div>
    </div>
</section>
</body>
</html>
