<%-- 
    Document   : index
    Created on : 14/10/2015, 21:58:17
    Author     : dahda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="FrontController" method="POST">
                <input type="text" name="username" placeholder="Usuario" />
                <input type="password" name="password" placeholder="Senha" />
                <input type ="hidden" name="command" value="login">
                <input type="submit" value="Log in" />
            </form>
    </body>
</html>
