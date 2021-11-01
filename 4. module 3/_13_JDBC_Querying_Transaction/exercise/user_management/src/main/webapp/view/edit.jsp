<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>
    <h3>Edit User</h3>
    <form method="post">
        <fieldset>
            <legend>Information User</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" value="${user.getName()}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" value="${user.getEmail()}" ></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input type="text" name="country" id="country" value="${user.getCountry()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Save</button></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <div><a href="/users">Back to List of Users</a></div>

</body>
</html>
