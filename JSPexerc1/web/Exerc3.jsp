<%-- 
    Document   : Exerc3
    Created on : 29/11/2014, 14:06:42
    Author     : Renan
--%>

<%@page import="java.util.StringTokenizer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contador de Palavras, Consoantes e Vogais</h1>
        <form method="post">
            <textarea name="tArea" cols="82" rows="15"></textarea><br>
            <input type="submit" value="Verificar">
        </form><br><br>
        
        <%
            if(request.getParameter("tArea") != null){
                String texto;
                texto = request.getParameter("tArea");
                
                int numPalavras=0, numConsoantes=0, numVogais=0;

                StringTokenizer parser = new StringTokenizer(texto);
                numPalavras = parser.countTokens();

                //http://pt.wikipedia.org/wiki/ASCII   

                for(int i=0; i< texto.length(); i++){
                    char letra = texto.charAt(i);
                    if(letra == 32){
                        continue;
                    }else if(letra == 65 || letra == 69 || letra == 73 || letra == 79 || letra ==85 ||
                             letra == 65+32 || letra == 69+32 || letra == 73+32 || letra == 79+32 || letra ==85+32){
                        numVogais++;
                    }else if((letra >=65 && letra<=90)||(letra >=65+32 && letra<=90+32)){
                        numConsoantes++;
                    }
                }
            %>
            <h3>Número de Palavras: <%=numPalavras%></h3>
            <h3>Número de Consoantes: <%=numConsoantes%></h3>
            <h3>Número de Vogais: <%=numVogais%></h3>
        <%}%>
    </body>
</html>
