<%-- 
    Document   : login
    Created on : 02/12/2014, 14:25:44
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login TeleLista</title>
        <link href="estilo.css" rel="stylesheet">
    </head>
    <body id="telaLogin">
        
        <h1 id="telelista">TeleLista</h1>
        <mark>${erro}</mark>
        <form action="VerificarUser" method="POST">
            Login: <input type="text" name="nome" value=""><br>
            Senha: <input type="password" name="senha" value=""><br>
            <input type="submit"  value="Logar">
        </form><br>
        
        <a href="novoUser.jsp">Criar Login</a>
    </body>
</html>
