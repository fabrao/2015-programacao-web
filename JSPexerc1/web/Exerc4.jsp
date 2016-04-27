<%-- 
    Document   : Exerc4
    Created on : 29/11/2014, 15:36:24
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulário</h1>
        <form method="post">
            Nome: <input type="text" name="nome" size="50"><br><br>
            EMail: <input type="email" name="email" size="50"><br><br>
            Assunto: <select name="assunto">
                        <option value="sugestao">Sugestão</option>
                        <option value="reclamacao">Reclamação</option>
                        <option value="sugestao">Dúvida</option>
            </select><br><br>
            <textarea name="tArea" cols="60" rows="15"></textarea><br>
            <input type="submit" value="Enviar">
        </form>
        <%
            try {
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String assunto = request.getParameter("assunto");
                String texto = request.getParameter("tArea");
                
                if(texto != null){
        %>        
                <h2>O que foi informado pelo usuário:</h2>
                <p>Nome: <%=nome%></p>
                <p>Email: <%=email%></p>
                <p>Assunto: <%=assunto%></p>
                <h3>Menssagem: </h3>
                <p><%=texto%></p>
        <%
                }
            } catch ( NumberFormatException e ) {
            }
            %>
    </body>
</html>
