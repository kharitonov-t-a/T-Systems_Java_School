<%--
  Created by IntelliJ IDEA.
  User: Trinita
  Date: 02.11.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
</head>
<body>
    <div class="generic-container">
        <h2 class="form-signin-heading">
            <div id="content-exception">
                ${exception}
            </div>
        </h2>
    </div>
</body>
</html>
