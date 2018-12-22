<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 14.10.2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div id='nuvebar'>
    <ul id="nuvigate">
        <li><a href='/'>Home</a></li>
        <li class='rootCutalog'><a href='/catalog/1/1'>Catalog</a>
            <c:set var="level" value="${1}"/>
            <c:forEach items="${allProductsCategoryForNavBar}" var="productCategoryDTO">
            <c:choose>
            <c:when test="${productCategoryDTO.level == level + 1 }">
            <ul>
                <li><a href='/catalog/${productCategoryDTO.id}/1'>${productCategoryDTO.name}</a>
                    <c:set var="level" value="${level + 1}"/>
                    </c:when>
                    <c:when test="${productCategoryDTO.level < level}">
                    <c:forEach begin="${productCategoryDTO.level}" end="${level - 1}">
                </li>
            </ul>
            </c:forEach>
            <c:set var="level" value="${productCategoryDTO.level}"/>
        </li>
        <li><a href='/catalog/${productCategoryDTO.id}/1'>${productCategoryDTO.name}</a>
            </c:when>
            <c:when test="${productCategoryDTO.level == level}">
        </li>
        <li><a href='/catalog/${productCategoryDTO.id}/1'>${productCategoryDTO.name}</a>
            </c:when>
            </c:choose>
            </c:forEach>

            <c:if test="${level > 0}">
            <c:forEach begin="${2}" end="${level}">
        </li>
    </ul>
    </c:forEach>
    </c:if>
    </li>
    <li><a href='#'>Delivery</a></li>
    <li><a href='#'>Payment</a></li>
    </ul>

    <ul id="authorize">
        <sec:authorize access="!isAuthenticated()">
            <li>
                <a class="btn-success nav-btn" href="<c:url value="/signup" />" role="button">SIGN UP</a>
            </li>
            <li>
                <a class="btn-success nav-btn" href="<c:url value="/login" />" role="button">LOG IN</a>
            </li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li>
                <a class="btn-warning nav-btn" href="<c:url value="/profile" />" role="button">User profile:
                    <sec:authentication property="principal.username"/></a>
            </li>
            <li>
                <a class="btn-warning nav-btn" href="<c:url value="/logout" />" role="button">Exit</a>
            </li>
        </sec:authorize>
    </ul>

</div>
<a href="<c:url value="/checkoutOrder" />" class="cd-cart-container"><img
        src="<c:url value="/resources/images/cart.png" />" alt=""></a>
<%@ include file="catalog/smallShoppingCart.jsp" %>
