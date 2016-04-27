<%-- 
    Document   : atividade2
    Created on : 03/12/2014, 14:06:37
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atividade 2</title>
    </head>
    <body>
        <h1>Atividade 2</h1>
        <form method="post">
            Texto: <input type="text" name="texto"><br><br>
            Tamanho: <input type="text" name="tamanho"><br><br>
            <input type="submit" value="Enviar"><br><br>
        </form>
<%
            String tamanhoSP= request.getParameter("tamanho");
            String textoP= request.getParameter("texto");
        
            if(tamanhoSP == null){
                tamanhoSP ="0";
            }
            if(textoP == null){
                textoP = "";
            }
            int tamanhoP = Integer.parseInt(tamanhoSP);
            
        if(tamanhoP<=0){
%>          <h3> Erro: parâmetro 'tamanho' nulo ou negativo</h3>
<%      }else if(textoP.isEmpty()){
%>          <h3> Erro: parâmetro 'texto' vazio </h3>
<%      }else{
            int tamanhoTexto = textoP.length();
            if(textoP.length() > tamanhoP){
 %>             <h3> Qtde de caracteres do Texto é MAIOR que o valor do Parâmetro </h3>
<%          }else if(textoP.length() < tamanhoP){
%>          <h3> Qtde de caracteres do Texto é MENOR que o valor do Parâmetro </h3>
<%          }else{
%>                  <h3> Qtde de caracteres do Texto é IGUAL o valor do Parâmetro </h3>
<%      
            }
        }        
%>   
    </body>
</html>
