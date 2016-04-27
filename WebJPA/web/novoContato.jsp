<%-- 
    Document   : newPhone
    Created on : 03/12/2014, 11:50:41
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Telefone</title>
        <link href="estilo.css" rel="stylesheet">
    </head>
    <body>
         <header>
            <div id="principalH">
                
                <div id="contato">
                    <a href="catSearch.jsp">Buscar</a> - 
                    <a href="editarContato.jsp">Editar</a> - 
                    <a href="excluirContato.jsp">Excluir </a>
                </div>
                <div id="logout">
                     <form action="VerificarUser" method="GET">
                        <input type="hidden" name="sair" value="true">
                        Olá <strong><%= request.getSession().getAttribute("usuario").toString() %></strong>. Caso queira sair clique <input type="submit" value="AQUI">
                    </form>
                </div>
            </div>
        </header>
        <h1>Cadastrar Telefone</h1>
        <mark>${erro}</mark>
        <form  action="CadastrarContato" method="post">   
            Nome: <input type="text" name="NomeCompleto" placeholder=" Nome Completo" size="50" maxlength="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Telefone: <input type="tel" name="Telefone" placeholder=" (DDD)  0000-0000" maxlength="16" size="12"><br><br>
            <input type="submit" value="Cadastrar"> 
        </form>

    </body>
</html>
