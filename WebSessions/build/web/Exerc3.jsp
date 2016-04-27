<%-- 
    Document   : Exerc3
    Created on : 30/11/2014, 11:16:47
    Author     : Renan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Produtos</title>
        <%
        HttpSession sessao = request.getSession();
        
        List<String> nomes = new ArrayList<String>();
        List<String> valores = new ArrayList<String>();

        int cont;
        
        if(sessao.isNew()){
           sessao.setAttribute("cont", 0);
           sessao.setAttribute("nomes", nomes);
           sessao.setAttribute("valores", valores);
           cont = 0;
        }else{
            cont = Integer.parseInt(sessao.getAttribute("cont").toString());
            nomes = (ArrayList<String>)sessao.getAttribute("nomes");
            valores = (ArrayList<String>)sessao.getAttribute("valores");
        }
        %>
        
    </head>
    <body>
        <div style="width:45%; float:left; border:1px solid black">
            <form method="get">
                <h1>Cadastrar Produtos:</h1>
                Nome: <input type="text" name="nome" size="30"><br><br>
                Preço: <input type="text" name="valor" size="30"><br><br>
                <input type="submit" value="Cadastrar">
            </form>
            <%
                if((request.getParameter("nome")!=null) && (request.getParameter("valor")!=null) &&
                    (request.getParameter("nome")!="") && (request.getParameter("valor")!="")){
                    
                    nomes.add(cont, request.getParameter("nome").toString());
                    valores.add(cont, request.getParameter("valor").toString());
                   
                    sessao.setAttribute("nomes", nomes);
                    sessao.setAttribute("valores", valores);
                    
                    cont++;
                    sessao.setAttribute("cont", cont);
                }
            %>
        </div>

        <div style="width:45%; float:left; border:1px solid black">
            <h1>Produtos Cadastrados: </h1>
            <ul>
                <%
                    for(int i=0; i<cont; i++){
                        %>
                        <li>Nome: <%=nomes.get(i)%></li>
                        <li>Valor: <%=valores.get(i)%></li><br>
                        <%
                    }
                %>
            </ul>
        </div>
            
    </body>
</html>
