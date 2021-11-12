<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Calculator</h3>
<form action="/calculate">
    <input type="text" name="numberOne" value="${numberOne}">
    <input type="text" name="numberTwo" value="${numberTwo}">
    <br>
    <br>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="X">Multiplication(X)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
    <br>
    <p>${result}</p>
</form>
</body>
</html>
