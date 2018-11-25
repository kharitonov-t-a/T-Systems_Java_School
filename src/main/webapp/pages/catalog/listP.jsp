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
<div class="content">
    <div class="container">

        <div class="content-mid">
            <h3>Trending Items</h3>
            <label class="line"></label>
            <c:set var="counter" value="${4}"/>
            <c:forEach items="${listProductsDTO}" var="product">
                <c:if test="${counter%4 == 0}">
                    <div class="mid-popular">
                </c:if>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="<c:url value="/resources/images/pc.jpg" />" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="<c:url value="/resources/images/pc.jpg" />" rel="title"
                                   class="b-link-stripe b-animate-go  thickbox"><i
                                        class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                        <%--<span>Women</span>--%>
                                    <h6><a href="detailproduct/${product.id}">${product.name}</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p><label>$100.00</label><em class="item_price">$${product.price}</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"></div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <c:if test="${counter%4 == 3}">
                    </div>
                </c:if>
                <c:set var="counter" value="${counter + 1}"/>
            </c:forEach>


        </div>

    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/resources/js/jsCatalog/simpleCart.min.js" />"></script>
<!-- slide -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!--light-box-files -->
<script src="<c:url value="/resources/js/jsCatalog/jquery.chocolat.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/cssCatalog/chocolat.css" />" type="text/css" media="screen"
      charset="utf-8">
<!--light-box-files -->
<script type="text/javascript" charset="utf-8">
    $(function () {
        $('a.picture').Chocolat();
    });
</script>
</body>
</html>