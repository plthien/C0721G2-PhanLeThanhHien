<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<div>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>
</div>
<div>
    <a href="/products">Back to Product List</a>
</div>
<form method="post" onsubmit=" return confirm('Do you want to delete this product ?')">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Description:</td>
                <td>${product.getDescription()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td>${product.getBrand()}</td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Delete Product</button>
                </td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>