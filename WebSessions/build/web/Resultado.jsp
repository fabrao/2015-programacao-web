<%-- 
    Document   : Resultado
    Created on : 30/11/2014, 15:07:06
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <%
            int vAlt1=0, vAlt2=0, vAlt3=0, totalVotos=0;
            int pAlt1=0, pAlt2=0, pAlt3=0;
            
            vAlt1= Integer.parseInt(application.getAttribute("votosAlt1").toString());
            vAlt2= Integer.parseInt(application.getAttribute("votosAlt2").toString());
            vAlt3= Integer.parseInt(application.getAttribute("votosAlt3").toString());
            
            totalVotos = vAlt1 + vAlt2 + vAlt3;
            
            pAlt1 = (vAlt1 * 100)/totalVotos;
            pAlt2 = (vAlt2 * 100)/totalVotos;
            pAlt3 = (vAlt3 * 100)/totalVotos;
        %>
            
        
    </head>
    <body>
        <h1>Resultado.jsp</h1><br>
        <h3>Alternativa 1: <%= pAlt1 %>%</h3>
        <h3>Alternativa 2: <%= pAlt2 %>%</h3>
        <h3>Alternativa 3: <%= pAlt3 %>%</h3><br>
        
        <a href="/WebSessions/Voto.jsp">Votar novamente</a><br>
        <a href="/WebSessions/Cadastra.jsp">Cadastrar nova pergunta</a>
        
    </body>
</html>
