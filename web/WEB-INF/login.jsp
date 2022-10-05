<%-- 
    Document   : login
    Created on : Oct 4, 2022, 8:05:59 PM
    Author     : Sharon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="text" name="password" value="${password}"><br>
            <input type="submit" value="Login">
        </form>
            <p>${message}</p>
    </body>
</html>
