<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>DAOTest</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
         Already registered
    </div>
    <table>
        <tr>
            <th>First name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var = "user">
            <tr>
                <td>${user.firstName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
