<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <style>
        input {
            width: 400px;
            height: 40px;
            font-size: 1.3em;
            border-radius: 20px;
            padding: 10px;
            border: none;
            outline: none;
            color: #5f6062;
        }

        button {
            border-radius: 50%;
            width: 50px;
            height: 50px;
            background: yellow;
            border: none;
        }

        form {
            width: 600px;
            height: 400px;
            margin: 100px auto;
            text-align: center;
            background-color: #33FF66;
            padding: 10px;
            border-radius: 40px;
        }

        div {
            margin-top: 20px;
            margin-left: 70px;
            text-align: left;
            font-size: 1.1em;
        }
    </style>
</head>
<body>
<form action="/translate">
    <h1>Từ điển Anh-Việt</h1>
    <input type="text" name="english" value="${english}"  placeholder="Type English">
    <button type="submit"> <i class="fas fa-search"></i></button>
    <br>
    <div id="result">${vietnamese}</div>
</form>
</body>
</html>
