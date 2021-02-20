<%-- 
    Document   : login
    Created on : Feb 19, 2021, 12:23:21 AM
    Author     : 631503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password <input type="password" name="password" value="${password}"><br>
            <input type="submit" value="Log In">
        </form>
        <p>${message}</p>
    </body>
</html>
