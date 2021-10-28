<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<div>
    <a href="/products">Back to Product List</a>
</div>
<form>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${product.getId()}</td>
            </tr>
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

        </table>
    </fieldset>

</form>
</body>
</html>