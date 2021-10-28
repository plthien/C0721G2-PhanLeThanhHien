<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<div><a href="/products?actionUser=create">Create new Product</a></div>
<table border="1">
    <tr>
        <td>No</td>
        <td>Id</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
        <td>Detail</td>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td><a href="/products?actionUser=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/products?actionUser=delete&id=${product.getId()}">Delete</a></td>
            <td><a href="/products?actionUser=view&id=${product.getId()}">Detail</a></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
