<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 11.11.2018
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="shoppingCartHide shoppingCart" id="smallShoppingCart">
    <div class="table-responsive">
        <table class="table table-bordered shCrt" id="smShCrt">
            <thead>
            <tr>
                <%--<td class="text-center">Image</td>--%>
                <th class="text-left"><span>Product Name</span></th>
                <%--<td class="text-left">Model</td>--%>
                <th class="text-left"><span>Count</span></th>
                <th class="text-right"><span>Price</span></th>
                <td class="text-right"> </td>
                <%--<td class="text-right">Total</td>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderSession.orderProductList}" var="orderProduct">
                <tr>
                        <%--<td class="text-center">--%>
                        <%--<a href="#"><img class="img-thumbnail" src="img/product/cart/2.jpg" alt="#" /></a>--%>
                        <%--</td>--%>
                    <td class="text-left">
                        <a href="#">${orderProduct.product.name}</a>
                        <c:if test="${!orderProduct.inStock}">
                            This product is out of stock.
                        </c:if>
                    </td>
                    <td class="text-left">
                        <div class="input-group mb-3 countProductAction">
                            <div class="input-group-prepend">
                                <button class="btn btn-outline-secondary reduceCountProduct"
                                        type="button"
                                        productId="${orderProduct.product.id}">
                                    -
                                </button>
                            </div>
                            <input type="text" class="form-control countProductAdd"
                                   placeholder="" aria-label=""
                                   aria-describedby="basic-addon1" max="${orderProduct.product.stockQuantity}"
                                   min="1" value="${orderProduct.count}"
                                   autocomplete="off" disabled="disabled">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary increaseCountProduct"
                                        type="button"
                                        productId="${orderProduct.product.id}">
                                    +
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="text-right unitPrice">${orderProduct.price}</td>
                    <td class="text-left">
                        <a class="btn btn-success deleteOrderProduct" productId="${orderProduct.product.id}" href="<c:url value="/deleteProductInOrder" />" role="button"><span aria-hidden="true">&times;</span></a>
                    </td>
                        <%--<div class="btn-block cart-put">--%>
                        <%--<input class="form-control" type="number" placeholder="1" />--%>
                        <%--<div class="input-group-btn cart-buttons">--%>
                        <%--<button class="btn btn-primary" data-toggle="tooltip" title="Update" >--%>
                        <%--<i class="fa fa-refresh"></i>--%>
                        <%--</button>--%>
                        <%--<button class="btn btn-danger" data-toggle="tooltip" title="Remove">--%>
                        <%--<i class="fa fa-times-circle"></i>--%>
                        <%--</button>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</td>--%>
                    <%--<td class="text-right total-cost">${orderProduct.price}</td>--%>
                        <%--<td class="text-right">$100.00</td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="tooltip-block"></div>
    <a class="btn btn-success" href="<c:url value="/checkoutOrder" />" role="button">Checkout</a>
</div>
