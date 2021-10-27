<%--
  Created by IntelliJ IDEA.
  User: tt
  Date: 10/26/2021
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      input {
        padding: 2px ;
      }
      label{
        width:150px;
        display: block;
        float: left;
        clear: left;
      }
      div{
        margin-top: 5px;
      }
      button{
        margin-left: 50px ;
      }
    </style>
  </head>
  <body>
  <form action="/discount">
    <div>
      <label for="productDescription">Product Description: </label>
      <input type="text" name="productDescription" id="productDescription">
    </div>
    <div>
      <label for="listPrice">List Price: </label>
      <input type="text" name="listPrice" id="listPrice">
    </div>
    <div>
      <label for="discountPercent">Discount Percent: </label>
      <input type="text" name="discountPercent" id="discountPercent">
    </div>
    <div>
      <button type="submit">Calculate Discount</button>
    </div>
  </form>
  </body>
</html>
