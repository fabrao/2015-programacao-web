<%-- 
    Document   : novoUser
    Created on : 02/12/2014, 15:11:27
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Usuário</title>
        <link href="estilo.css" rel="stylesheet">
    </head>
    <body>
        <h1>Cadastrar Usuário</h1>
        <mark>${erro}</mark>
        <form action="CadastraUser" method="post">
            Nome de Usuário:<br>
            <input type="text" name="nome"><br><br>
            
            Senha: <br>
            <input type="password" name="senha1"><br><br>
            
            Confirmar Senha: <br>
            <input type="password" name="senha2"><br><br>
            <input type="submit" value="Cadastrar">
        </form>
        <br>
        <a href="login.jsp">Voltar para Página de Login</a>
        
    </body>
</html>
