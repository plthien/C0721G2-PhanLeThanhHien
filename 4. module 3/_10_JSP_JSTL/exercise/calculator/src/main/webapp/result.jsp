<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Result:</h2>
    <div>
        <c:out value="${requestScope.aFromServlet}"/>
        <c:out value="${requestScope.operatorFromServlet}"/>
        <c:out value="${requestScope.bFromServlet}"/>
        <c:out value="${requestScope.equalFromServlet}"/>
        <c:out value="${requestScope.resultFromServlet}"/>
    </div>
    <div>
        <c:out value="${requestScope.exceptionFromServlet}"/>
    </div>
</body>
</html>
