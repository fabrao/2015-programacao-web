<%-- 
    Document   : Cadastra
    Created on : 30/11/2014, 15:06:23
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>

    </head>
    <body>
        <h1>Cadastra.jsp</h1>
        <form method="post" action="ServletCadastra">
            <h3>Digite a questão: </h3>
            <input type="text" name="questao" size="80"><br><br>
            <h3>Preencha as três alternativas: </h3>
            Alternativa 1: <input type="text" name="alt1" size="30"><br>
            Alternativa 2: <input type="text" name="alt2" size="30"><br>
            Alternativa 3: <input type="text" name="alt3" size="30"><br><br>
            <input type="submit" value="Cadastrar">    
        </form>
    </body>
</html>
