<%-- 
    Document   : index
    Created on : 17/10/2015, 17:10:25
    Author     : Bianca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" type="text/css" href="css/style.css"/>

    </head>
    <body>
        <section>
            
            <h1>LOGIN</h1>

            <form action="FrontController" method="POST">
                <input type="hidden" name="command" value="login.login"/>
                <p>User<br><input type="text" name="username" placeholder="username" required/>*<p/>
                <p>Password<br><input type="password" name="password" placeholder="password" reqiured/>*<p/>
                <p><input type="submit" value="LOGIN"/><p/>
            </form>
        </section>
    </body>
</html>
