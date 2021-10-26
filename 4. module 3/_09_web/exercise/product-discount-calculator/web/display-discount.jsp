<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 10/26/2021
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <p>Product Description: <%= request.getAttribute("productDescription")%></p>
        <p>List Price: <%= request.getAttribute("listPrice")%></p>
        <p>Discount Percent: <%= request.getAttribute("discountPercent")%></p>
        <p>Discount Amount: <%= request.getAttribute("discountAmount")%></p>
        <p>Discount Price: <%= request.getAttribute("discountPrice")%></p>
</body>
</html>
