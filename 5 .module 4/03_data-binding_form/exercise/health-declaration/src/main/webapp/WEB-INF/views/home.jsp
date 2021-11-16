<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khai báo y tế</title>
</head>
<body>
<a href="/declare">Khai báo ý tế</a>
<div>${mess}</div>
<form  action="/declaration" method="post" >
    <label for="idCard"></label>
    <input type="text" id="idCard" name="idCard" placeholder="Nhap so CMND">
    <button type="submit">Tìm kiếm</button>
</form>
</body>
</html>
