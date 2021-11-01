<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>
    <h3>Create new User</h3>
    <form method="post">
        <fieldset>
            <legend>Information User</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" placeholder="Enter your name"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" placeholder="Enter your email"></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input type="text" name="country" id="country" placeholder="Enter your country"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Create</button></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <div><a href="/users">Back to List of Users</a></div>

</body>
</html>
