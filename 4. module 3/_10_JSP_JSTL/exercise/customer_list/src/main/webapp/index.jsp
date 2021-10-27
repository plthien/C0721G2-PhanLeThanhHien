<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer</title>
    <style>
      table, td, th{
        border-collapse: collapse;
        border: 1px solid lightgray;
      }

      td:nth-child(1){
        text-align: center;
        width: 40px;
      }
      td:nth-child(2){
        text-align: left;
        width: 200px;
      }
      td:nth-child(3){
        text-align: center;
        width: 110px;
      }
      td:nth-child(4){
        text-align: center;
        width: 90px;
      }
    </style>
  </head>
  <body>
  <table>
    <caption>Customer List</caption>
    <tr>
      <th>No</th>
      <th>Name</th>
      <th>Date of Birth</th>
      <th>Address</th>
      <th>Avatar</th>
    </tr>

      <c:forEach var="customer" items="${customerListServlet}" varStatus="countLoop">
      <tr>
        <td><c:out value="${countLoop.count}"/></td>
        <td><c:out value="${customer.name}"/></td>
        <td><c:out value="${customer.dateOfBirth}"/></td>
        <td><c:out value="${customer.address}"/></td>
        <td><img src="${customer.avatar}" width="80px" height="80px"/></td>
      </tr>

      </c:forEach>

  </table>
  </body>
</html>
