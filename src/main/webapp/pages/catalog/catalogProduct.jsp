<%@ page import="com.web.shop.model.enums.CharacteristicType" %>
<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
    <script src="<c:url value="/resources/js/catalog.js" />"></script>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>

<section class="page-content">
    <div class="container ${changeCategory}" id="categoryContainer">
        <%--@elvariable id="productDTO" type="com.web.shop.dto.product.ProductDTO"--%>
        <form:form modelAttribute="productDTO" method="post" class="form-horizontal" id="catalogForm">
            <%--<div class="row">--%>
            <%--<div class="col-md-12">--%>
            <%--<ul class="page-menu">--%>
            <%--<li><a href="index.html">Home</a></li>--%>
            <%--<li class="active"><a href="#">Special Offers</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="row">
                <div class="col-md-3">
                    <!-- shop-filter start -->
                    <div class="shop-filter">
                        <div class="area-title">
                            <h3 class="title-group gfont-1">Filters Products</h3>
                        </div>
                        <form:input type="number" path="productCategory.id" hidden="true"/>

                        <div class="form-group row">
                            <label class="col-sm-10 control-lable" for="priceFilterMin">Price</label>
                            <div class="col-sm-5">
                                <form:input type="number" class="form-control" placeholder="Min"
                                            path="priceFilterMin"/>
                            </div>
                            <div class="col-sm-5">
                                <form:input type="number" class="form-control" placeholder="Max"
                                            path="priceFilterMax"/>
                            </div>
                        </div>

                        <c:forEach items="${ProductCharacteristicTypeDTOList}" var="productCharacteristicTypeDTO"
                                   varStatus="counter">
                            <%--<c:set var="fieldValue" scope="page" value="" />--%>
                            <%--<c:set var="productCharacteristicId" scope="page" value="" />--%>

                            <form:input
                                    path="productCharacteristicList[${counter.count-1}].productCharacteristicType.id"
                                    hidden="true" value="${productCharacteristicTypeDTO.id}"/>
                            <%--<form:input--%>
                                    <%--path="productCategory.id"--%>
                                    <%--hidden="true" value="${categoryId}"/>--%>

                            <div class="form-group row">
                                <label class="control-lable col-sm-10">${productCharacteristicTypeDTO.name}
                                    <c:if test="${productCharacteristicTypeDTO.measure != null && productCharacteristicTypeDTO.measure.length()>0}">
                                        , ${productCharacteristicTypeDTO.measure}
                                    </c:if>
                                </label>

                                <c:if test="${CharacteristicType.BOOLEAN.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                                    <div class="col-sm-10">
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
                                            <form:errors
                                                    path="productCharacteristicList[${counter.count-1}].booleanCharacteristicValue"
                                                    class="help-inline"></form:errors>
                                        </div>
                                    </div>

                                </c:if>

                                <c:if test="${CharacteristicType.INTEGER.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                                    <div class="col-sm-5">
                                        <form:input type="number" class="form-control"
                                                    path="productCharacteristicList[${counter.count-1}].integerCharacteristicFilterMin"
                                                    placeholder="Min"/>
                                    </div>
                                    <div class="col-sm-5">
                                        <form:input type="number" class="form-control"
                                                    path="productCharacteristicList[${counter.count-1}].integerCharacteristicFilterMax"
                                                    placeholder="Max"/>
                                    </div>

                                    <%--<div class="has-error">--%>
                                    <%--<form:errors--%>
                                    <%--path="productCharacteristicList[${counter.count-1}].integerCharacteristicValue"--%>
                                    <%--class="help-inline"></form:errors>--%>
                                    <%--</div>--%>

                                </c:if>

                                <c:if test="${CharacteristicType.DOUBLE.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                                    <div class="col-sm-5">
                                        <form:input type="number" class="form-control"
                                                    path="productCharacteristicList[${counter.count-1}].doubleCharacteristicFilterMin"
                                                    placeholder="Min"/>
                                    </div>
                                    <div class="col-sm-5">
                                        <form:input type="number" class="form-control"
                                                    path="productCharacteristicList[${counter.count-1}].doubleCharacteristicFilterMax"
                                                    placeholder="Max"/>
                                    </div>
                                    <%--<div class="has-error">--%>
                                    <%--<form:errors--%>
                                    <%--path="productCharacteristicList[${counter.count-1}].doubleCharacteristicValue"--%>
                                    <%--class="help-inline"></form:errors>--%>
                                    <%--</div>--%>

                                </c:if>

                                <c:if test="${CharacteristicType.STRING.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                                    <div class="col-sm-10">
                                        <form:input type="text" class="form-control"
                                                    path="productCharacteristicList[${counter.count-1}].stringCharacteristicValue"/>
                                        <div class="has-error">
                                            <form:errors
                                                    path="productCharacteristicList[${counter.count-1}].stringCharacteristicValue"
                                                    class="help-inline"></form:errors>
                                        </div>
                                    </div>

                                </c:if>

                                <c:if test="${CharacteristicType.CHECKBOX.compareTo(productCharacteristicTypeDTO.characteristicType) == 0}">
                                    <div class="col-sm-10">
                                        <c:forEach var="productCharacteristicCheckboxField"
                                                   items="${productCharacteristicTypeDTO.productCharacteristicCheckboxFieldList}"
                                                   varStatus="countField">

                                            <c:set var="fieldValue" scope="page" value=""/>
                                            <c:set var="fieldId" scope="page" value=""/>

                                            <c:forEach items="${productDTO.productCharacteristicList}"
                                                       var="productCharacteristicDTO">
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
                                    </div>

                                </c:if>

                            </div>


                        </c:forEach>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Filter
                        </button>


                    </div>
                </div>
                <div class="col-md-9">
                    <!-- START PRODUCT-AREA -->
                    <div class="product-area">
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- Start Product-Menu -->
                                <div class="product-menu">
                                    <div class="product-title">
                                        <h3 class="title-group-3 gfont-1">${productDTO.productCategory.name}</h3>
                                    </div>
                                </div>
                                <div class="product-filter">
                                    <ul role="tablist">
                                        <li role="presentation" class="list active">
                                            <a href="#display-1-1" role="tab" data-toggle="tab"></a>
                                        </li>
                                        <li role="presentation" class="grid ">
                                            <a href="#display-1-2" role="tab" data-toggle="tab"></a>
                                        </li>
                                    </ul>
                                    <div class="sort">
                                        <label>Sort By:</label>
                                        <form:select path="sort" multiple="false"><%--class="form-control input-sm"--%>
                                        <form:options
                                                items="${com.web.shop.model.enums.Sorting.values()}"
                                                itemLabel="name"/>
                                        </form:select>
                                    </div>
                                        <%--<div class="limit">--%>
                                        <%--<label>Show:</label>--%>
                                        <%--<select>--%>
                                        <%--<option value="#">8</option>--%>
                                        <%--<option value="#">16</option>--%>
                                        <%--<option value="#">24</option>--%>
                                        <%--<option value="#">40</option>--%>
                                        <%--<option value="#">80</option>--%>
                                        <%--<option value="#">100</option>--%>
                                        <%--</select>--%>
                                        <%--</div>--%>
                                </div>

                                <!-- End Product-Menu -->
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="row" id="catalogBox">
                            <div class="col-xs-12 col-md-12">
                                <!-- Start Product -->
                                <div class="product">
                                    <div class="tab-content">
                                        <!-- Product -->
                                        <div role="tabpanel" class="tab-pane in  active" id="display-1-2">
                                            <div class="row">
                                                    <%--<div class="listview">--%>


                                                <c:forEach items="${listProductsDTO}" var="product">
                                                    <!-- Start Single-Product -->

                                                    <div class="col-md-3 col-sm-4 col-xs-12">
                                                        <div class="single-product">
                                                                <%--<div class="label_new">--%>
                                                                <%--<span class="new">new</span>--%>
                                                                <%--</div>--%>
                                                                <%--<div class="sale-off">--%>
                                                                <%--<span class="sale-percent">-55%</span>--%>
                                                                <%--</div>--%>
                                                            <div class="product-img">
                                                                <a href="#">
                                                                    <img class="primary-img"
                                                                         src="<c:url value="/resources/images/pc.jpg" />"
                                                                         alt="Product">
                                                                        <%--<img class="secondary-img" src="<c:url value="/resources/images/pc.jpg" />" alt="Product">--%>
                                                                </a>
                                                            </div>
                                                            <div class="product-description">
                                                                <h5>
                                                                    <a href="detailproduct/${product.id}">${product.name}</a>
                                                                </h5>
                                                                <div class="price-box">
                                                                    <span class="price">$${product.price}</span>
                                                                        <%--<span class="old-price">$110.00</span>--%>
                                                                </div>
                                                                <span class="rating">
																	<%--<i class="fa fa-star"></i>--%>
																	<%--<i class="fa fa-star"></i>--%>
																	<%--<i class="fa fa-star"></i>--%>
																	<%--<i class="fa fa-star"></i>--%>
																	<%--<i class="fa fa-star-o"></i>--%>
                                                            </span>
                                                            </div>
                                                            <div class="product-action">
                                                                <div class="button-group">
                                                                    <div class="product-button">
                                                                        <button class="addProduct"
                                                                                attrIdProduct="${product.id}"
                                                                                href="<c:url value="/addProductToOrder"/>">
                                                                            <i class="fa fa-shopping-cart"></i> Add to
                                                                            Cart
                                                                        </button>
                                                                    </div>
                                                                    <div class="product-button-2">
                                                                            <%--<a href="#" data-toggle="tooltip" title="Wishlist"><i class="fa fa-heart-o"></i></a>--%>
                                                                            <%--<a href="#" data-toggle="tooltip" title="Compare"><i class="fa fa-signal"></i></a>--%>
                                                                            <%--<a href="#" class="modal-view" data-toggle="modal" data-target="#productModal"><i class="fa fa-search-plus"></i></a>--%>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- End Single-Product -->
                                                </c:forEach>
                                                    <%--</div>--%>
                                                <!-- Start Pagination Area -->

                                            </div>
                                            <div class="pagination-area">
                                                <div class="row">
                                                    <div class="col-xs-5">
                                                        <div class="pagination">
                                                            <ul>
                                                                <c:forEach var="counter" begin="1" end="${countPage}">
                                                                    <li class="${counter == currentPage ? "active" : ""}">
                                                                        <a class="catalogPageNavigate" href="<c:out value="/catalog/${productDTO.productCategory.id}/${counter}"/>">${counter}</a>
                                                                    </li>
                                                                </c:forEach>
                                                                    <%--<li class="active"><a href="#">1</a></li>--%>
                                                                    <%--<li><a href="#">2</a></li>--%>
                                                                    <%--<li><a href="#">></a></li>--%>
                                                                    <%--<li><a href="#">>|</a></li>--%>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                        <%--<div class="col-xs-7">--%>
                                                        <%--<div class="product-result">--%>
                                                        <%--<span>Showing 1 to 16 of 19 (2 Pages)</span>--%>
                                                        <%--</div>--%>
                                                        <%--</div>--%>
                                                </div>
                                            </div>
                                            <!-- End Pagination Area -->
                                            <!-- End Product = TV -->
                                        </div>
                                    </div>
                                    <!-- End Product -->
                                </div>
                            </div>
                        </div>
                        <!-- END PRODUCT-AREA -->
                    </div>
                </div>

            </div>
        </form:form>
    </div>

</section>

<div id="alertStock" class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" id="error">
        </div>
    </div>
</div>

</body>
</html>