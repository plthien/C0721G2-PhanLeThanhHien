<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert USD To VND</title>
    <style>
        form {
            width: 300px;
            height: 100px;
        }

    </style>
</head>
<body>
<form action="/convert">
    <fieldset>
        <legend>
            Convert USD To VND
        </legend>
        <table>
            <tr>
                <td><label for="usd">USD:</label></td>
                <td><input type="text" id="usd" name="usd" value="${usd}"></td>
            </tr>
            <tr>
                <td><label for="rate">Rate:</label></td>
                <td><input type="text" value="23000" id="rate" name="rate"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Convert</button></td>
            </tr>
            <tr>
                <td>VND:</td>
                <td><p>${vnd}</p></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
