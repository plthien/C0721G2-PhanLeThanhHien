<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 11/12/2021
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich Condiments:</h3>
<form action="/condiments">
    <input type="checkbox" name="condiment" id="condiment1" value="Lettuce">
    <label for="condiment1">Lettuce</label>
    <input type="checkbox" name="condiment" id="condiment2" value="Tomato">
    <label for="condiment2">Tomato</label>
    <input type="checkbox" name="condiment" id="condiment3" value="Mustard">
    <label for="condiment3">Mustard</label>
    <input type="checkbox" name="condiment" id="condiment4" value="Sprouts">
    <label for="condiment4">Sprouts</label>
    <button type="submit">Save</button>
</form>
</body>
</html>
