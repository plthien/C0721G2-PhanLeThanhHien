<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th {
            text-align: left;
            height: 40px;
            width: 100px;
        }

        td {
            text-align: left;
            height: 40px;
            width: 200px;
        }
    </style>
</head>
<body>
<h3>Settings</h3>
<form:form action="/update" modelAttribute="email" method="post">
    <table>
        <tr>
            <th>Languages:</th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>Show
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"></form:options>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spam filter:</th>
            <td>
                <form:checkbox path="spamsFilter" value="${email.isSpamsFilter()}"></form:checkbox>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature" value="${email.getSignature()}"></form:textarea>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button type="submit">Update</button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
