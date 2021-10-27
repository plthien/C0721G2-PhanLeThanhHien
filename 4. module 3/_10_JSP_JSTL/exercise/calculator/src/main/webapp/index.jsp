<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
    <style>
      fieldset {
        border: 1px solid lightgray;
        width: 400px;
        height: 130px;
      }
      label{
        width: 150px;
        display: block;
        float: left;
        clear: left;

      }
      input {
        outline: none;
      }
      fieldset div{
        margin-bottom: 5px;
      }
      button{
        border-radius:5px ;
        margin-left: 150px;
      }
    </style>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="/calculator" >
    <fieldset>
      <legend>Calculator</legend>
      <div>
        <label for="firstOperand">First operand:</label>
        <input type="text" name="firstOperand" id="firstOperand">
      </div>
      <div>
        <label for="operator">Operator:</label>
        <select name="operator" id="operator">
          <option value="addition">Addition</option>
          <option value="subtraction">Subtraction</option>
          <option value="multiplication">Multiplication</option>
          <option value="division">Division</option>
        </select>
      </div>
      <div>
        <label for="secondOperand">Second operand:</label>
        <input type="text" name="secondOperand" id="secondOperand">
      </div>
      <div>

        <button type="submit">Calculate</button>
      </div>
    </fieldset>


  </form>
  </body>
</html>
