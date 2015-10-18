<%-- 
    Document   : saldo
    Created on : 15/10/2015, 01:12:39
    Author     : dahda
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saldo</title>
    </head>
    <body>
        <h1>Contas e Saldos:</h1>
        
        <c:forEach var="conta" items="${conta}">
             <c:out value="${conta.nomeConta}" /> - <c:out value="${conta.saldo}" /> <br/>
        </c:forEach>
             
        <form action="menu.jsp">
            <input type="submit" value="Voltar">
        </form>      
             
             
    </body>
</html>
