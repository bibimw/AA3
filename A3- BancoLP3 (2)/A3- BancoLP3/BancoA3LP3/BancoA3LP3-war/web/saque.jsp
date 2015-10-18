<%-- 
    Document   : saque
    Created on : 15/10/2015, 01:13:01
    Author     : dahda
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saque</title>
    </head>
    <body>
        
        
        
        <h1>Saque</h1>
                <form action="FrontController" method="POST"> 
                    Conta:
                    <select name = "id" >
                        <c:forEach var="conta" items="${conta}">
                            <option value="${conta.idConta}" selected="0"> ${conta.nomeConta}  </option>  
                        </c:forEach>
                    </select>                   
                    Valor a sacar:<input type="text" name="valor"  />                                 
                    <input type ="hidden" name="command" value="conta.sacar">                
                    <input type="submit" value="sacar" />
                </form>
        
    </body>
</html>
