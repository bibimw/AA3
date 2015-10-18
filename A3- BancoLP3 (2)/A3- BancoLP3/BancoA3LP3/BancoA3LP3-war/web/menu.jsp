<%-- 
    Document   : newjspmenu
    Created on : 15/10/2015, 00:58:48
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
        <h1>Escolha:</h1>
            <form action="FrontController" method="POST">                
                <h3><input type="radio" name="command" value="conta.saldo" checked/> Saldo</h3></br> 
                <h3><input type="radio" name="command" value="conta.transferir" /> Tranferência</h3></br> 
                <h3><input type="radio" name="command" value="conta.saque" /> Saque </h3></br> 
                <input type="submit" value="Entrar" />
            </form>
    </body>
</html>
