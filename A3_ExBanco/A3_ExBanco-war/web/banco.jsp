<%-- 
    Document   : banco
    Created on : 17/10/2015, 17:53:06
    Author     : Bianca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banco</title>
    </head>
    <body>
        <h1>Bem Vindo,
            <%
                String username = request.getSession().getAttribute("user").toString();
                out.println(" <br>"+username+"<br>");
            %>
        </h1>
        
        <p>O que você deseja fazer?</p>
        <form action="FrontController" method="POST">                
                <h3><input type="radio" name="command" value="operacao.saldo" checked/>Saldo</h3></br> 
                <h3><input type="radio" name="command" value="operacao.transferir" />Tranferência</h3></br> 
                <h3><input type="radio" name="command" value="operacao.saque" />Saque</h3></br> 
                <input type="submit" value="Entrar" />
        </form>
    </body>
</html>
