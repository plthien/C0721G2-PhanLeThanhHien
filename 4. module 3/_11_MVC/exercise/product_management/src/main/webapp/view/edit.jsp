<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<div>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>
</div>
<div>
    <a href="/products">Back to Product List</a>
</div>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" id="description" value="${product.getDescription()}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td><input type="text" name="brand" id="brand" value="${product.getBrand()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Update Product</button>
                </td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
