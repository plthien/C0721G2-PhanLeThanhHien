<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h3>Sandwich Condiments:</h3>
<ul>
    <c:forEach var="condiment" items="${condimentList}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
