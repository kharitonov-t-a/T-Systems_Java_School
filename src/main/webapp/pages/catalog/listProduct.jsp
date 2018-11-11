<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 20.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%@ include file="/pages/head.jsp" %>
</head>
<body>
<%@ include file="/pages/navbar.jsp" %>

<section class="page-content">
    <div class="container">
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
                    <h4 class="shop-price-title">Price</h4>
                    <div class="info_widget">
                        <div class="price_filter">
                            <div id="slider-range"></div>
                            <div class="price_slider_amount">
                                <input type="text" id="amount" name="price" placeholder="Add Your Price"/>
                                <input type="submit" value="Filter"/>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- shop-filter start -->
                <!-- filter-by start -->
                <div class="accordion_one">
                    <h4><a class="accordion-trigger" data-toggle="collapse" href="#divone">Color</a></h4>
                    <div id="divone" class="collapse in">
                        <div class="filter-menu">
                            <ul>
                                <li><a href="#">Black (2)</a></li>
                                <li><a href="#">Blue (2)</a></li>
                                <li><a href="#">Brown (3)</a></li>
                                <li><a href="#">Green (3)</a></li>
                                <li><a href="#">Orange (2)</a></li>
                                <li><a href="#">Pink (2)</a></li>
                                <li><a href="#">Red (11)</a></li>
                                <li><a href="#">Yellow (3)</a></li>
                            </ul>
                        </div>
                    </div>
                    <h4><a class="accordion-trigger" data-toggle="collapse" href="#div2">manufacture</a></h4>
                    <div id="div2" class="collapse in">
                        <div class="filter-menu">
                            <ul>
                                <li><a href="#">Chanel (2)</a></li>
                                <li><a href="#">Christian Dior (2)</a></li>
                                <li><a href="#">Ermenegildo Zegna (2)</a></li>
                                <li><a href="#">Ferragamo (1)</a></li>
                                <li><a href="#">Hermes (2)</a></li>
                                <li><a href="#">Louis Vuitton (3)</a></li>
                                <li><a href="#">Prada (1)</a></li>
                            </ul>
                        </div>
                    </div>
                    <h4><a class="accordion-trigger" data-toggle="collapse" href="#div3">Size</a></h4>
                    <div id="div3" class="collapse in">
                        <div class="filter-menu">
                            <ul>
                                <li><a href="#">L (1)</a></li>
                                <li><a href="#">M (5)</a></li>
                                <li><a href="#">S (7)</a></li>
                                <li><a href="#">XL (5)</a></li>
                                <li><a href="#">XXL (6)</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- filter-by end -->
            </div>
            <div class="col-md-9">
                <!-- START PRODUCT-AREA -->
                <div class="product-area">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- Start Product-Menu -->
                            <div class="product-menu">
                                <div class="product-title">
                                    <h3 class="title-group-3 gfont-1">cameras & photography</h3>
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
                                    <select>
                                        <option value="#">Default</option>
                                        <option value="#">Name (A - Z)</option>
                                        <option value="#">Name (Z - A)</option>
                                        <option value="#">Price (Low > High)</option>
                                        <option value="#">Rating (Highest)</option>
                                        <option value="#">Rating (Lowest)</option>
                                        <option value="#">Name (A - Z)</option>
                                        <option value="#">Model (Z - A))</option>
                                        <option value="#">Model (A - Z)</option>
                                    </select>
                                </div>
                                <div class="limit">
                                    <label>Show:</label>
                                    <select>
                                        <option value="#">8</option>
                                        <option value="#">16)</option>
                                        <option value="#">24</option>
                                        <option value="#">40</option>
                                        <option value="#">80</option>
                                        <option value="#">100</option>
                                    </select>
                                </div>
                            </div>

                            <!-- End Product-Menu -->
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <!-- Start Product -->
                            <div class="product">
                                <div class="tab-content">
                                    <!-- Product -->
                                    <div role="tabpanel" class="tab-pane fade in  active" id="display-1-2">
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
                                                                <img class="primary-img" src="<c:url value="/resources/images/pc.jpg" />" alt="Product">
                                                                <%--<img class="secondary-img" src="<c:url value="/resources/images/pc.jpg" />" alt="Product">--%>
                                                            </a>
                                                        </div>
                                                        <div class="product-description">
                                                            <h5><a href="detailproduct/${product.id}">${product.name}</a></h5>
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
                                                                    <button class="addProduct" attrIdProduct="${product.id}" href="<c:url value="/addProductToOrder"/>"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
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
                                            <div class="pagination-area">
                                                <div class="row">
                                                    <div class="col-xs-5">
                                                        <div class="pagination">
                                                            <ul>
                                                                <li class="active"><a href="#">1</a></li>
                                                                <li><a href="#">2</a></li>
                                                                <li><a href="#">></a></li>
                                                                <li><a href="#">>|</a></li>
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
                                        </div>
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