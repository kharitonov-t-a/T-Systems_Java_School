<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 14.10.2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<nav class="navbar navbar-expand-lg fixed-top">
    <a class="navbar-brand" href="#">
        Home
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <sec:authorize access="!isAuthenticated()">
            <ul class="navbar-nav ml-md-auto first-nav-element-incollapse">
                <li class="nav-item">
                    <a class="btn btn-success nav-btn" href="/signup" role="button">SIGN UP</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-success nav-btn" href="<c:url value="/login" />" role="button">LOG IN</a>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <ul class="navbar-nav ml-md-auto first-nav-element-incollapse">
                <li class="nav-item">
                    <p>Ваш логин: <sec:authentication property="principal.username" /></p>
                </li>
                <li class="nav-item">
                    <a class="btn btn-warning nav-btn" href="<c:url value="/logout" />" role="button">Выйти</a>
                </li>
            </ul>
        </sec:authorize>
        <ul class="navbar-nav col-md-7 ml-md-auto order-first">
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Portfolio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Team</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Post</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#">Contact</a>
            </li>
        </ul>
    </div>
</nav>
