<%-- 
    Document   : transferencia
    Created on : 15/10/2015, 01:12:51
    Author     : dahda
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>Transferência:</h1>
        <form action="FrontController" method="POST"> 
            Transferir <input type="text" name="valor" placeholder="valor" />    
            da conta:
            <select  name = "id1" >
                <c:forEach var="s" items="${conta}">
                    <option value="${s.idConta}"> ${s.nomeConta}  </option>  
                </c:forEach>
            </select>   
            para a conta:
            <select name = "id2" >
                <c:forEach var="s" items="${conta}">
                    <option value="${s.idConta}"> ${s.nomeConta}  </option>  
                </c:forEach>
            </select>                        
            <input type ="hidden" name="command" value="conta.tranferir">                
            <input type="submit" value="transferir" />
        </form>
    </body>
</html>
