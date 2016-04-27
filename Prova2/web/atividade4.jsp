<%-- 
    Document   : atividade4
    Created on : 03/12/2014, 14:59:22
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atividade 4</title>
<%
        HttpSession sessao = request.getSession();
        String textosessao;

        if (sessao.isNew()) {
            int aleatorio = 34;
            sessao.setAttribute("numAleatorio", aleatorio);
            //textosessao =  sessao.getAttribute("texto").toString();
        }
%>
    </head>
    <body>
        <h1>Atividade 4</h1>
        <form method="post">
            <a href="atividade4.jsp?dobra=true">Dobra</a>
            <a href="atividade4.jsp?metade=true">Metade</a>
            <a href="atividade4.jsp?soma1=true">Soma1</a>  
        </form>
         <h1> <%=sessao.getAttribute("numAleatorio").toString() %></h1> 
<%
        int aux=0;
        String dobra = request.getParameter("dobra");
        String metade = request.getParameter("metade");
        String soma1 = request.getParameter("soma1");

        if(dobra == null){
            dobra = "";
        }
        if(metade == null){
            metade ="";
        }
        if(soma1==null){
            soma1= "";
        }
        
        if(dobra.equals("true")){
            aux = Integer.parseInt(sessao.getAttribute("numAleatorio").toString());
            aux = aux*2;
            sessao.setAttribute("numAleatorio", aux);
            response.sendRedirect("atividade4.jsp");
        }else if(metade.equals("true")){
            aux = Integer.parseInt(sessao.getAttribute("numAleatorio").toString());
            aux = aux/2;
            sessao.setAttribute("numAleatorio", aux);
            response.sendRedirect("atividade4.jsp");
        }else if(soma1.equals("true")){
            aux = Integer.parseInt(sessao.getAttribute("numAleatorio").toString());
            aux = aux+1;
            sessao.setAttribute("numAleatorio", aux);
            response.sendRedirect("atividade4.jsp");
        }  
        
%>     
    </body>
</html>
