<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Result:</h2>
    <div>
        <c:out value="${aFromServlet}"/>
        <c:out value="${operatorFromServlet}"/>
        <c:out value="${bFromServlet}"/>
        <c:out value="${equalFromServlet}"/>
        <c:out value="${resultFromServlet}"/>
    </div>
    <div>
        <c:out value="${exceptionFromServlet}"/>
    </div>
</body>
</html>
