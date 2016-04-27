<%-- 
    Document   : catSearch
    Created on : 02/12/2014, 14:45:50
    Author     : Renan
--%>

<%@page import="java.util.regex.Pattern"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet">
        <title>CatSearch</title>
    </head>
    <body>  
        <header>
            <div id="principalH">
                
                <div id="contato">
                    <a href="novoContato.jsp">Cadastrar</a> -  
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
                    
        <h1>CatSearch</h1>
        
        <div id="img"><img src="cat.jpg"><br></div><br>
        
        <form method="get" action="BuscarContato">
            <input type="text" name="busca">
            <input type="submit" value="Pesquisar">
        </form>
        <h3>${results}</h3><br>
        <div>
        <%if(request.getAttribute("resultadoNomes") != null){
            String uva = request.getAttribute("resultadoNomes").toString();
            uva = uva.replaceAll("\\[|\\]", "");
            String listaNomes[] = uva.split(",");
            String pera = request.getAttribute("resultadoTels").toString();
            pera = pera.replaceAll("\\[|\\]", "");
            String listaTels[] = pera.split(","); %> 
            <table> 
                <tr>
                    <th>Nome</th>
                    <th>Número</th>
                </tr>
                <%for(int i=0; i<listaNomes.length; i++){%>
                    <tr>
                        <td><%= listaNomes[i]%></td>
                        <td><%= listaTels[i]%></td>  
                    </tr>
                 <%}%> 
            </table>
        </div>
      <%}%>
    </body>
</html>
