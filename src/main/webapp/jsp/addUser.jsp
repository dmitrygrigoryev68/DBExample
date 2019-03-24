<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please, Add User
    </div>
    <form method="post" action="/users">
        <label for="first_name">First name
            <input class="input-field" type = "text" id="first_name" name = "first_name">
        </label>
        <label for="last_name"> Last name
            <input class="input-field" type = "text" id = "last_name" name = "last_name">
        </label>
        <input type="submit" value="Add User">
    </form>
</div>
</body>
</html>