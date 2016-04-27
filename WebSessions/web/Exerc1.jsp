<%-- 
    Document   : Exerc1
    Created on : 29/11/2014, 16:21:38
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession sessao = request.getSession();
            String color;
            if((request.getParameter("corfundo")== null) && (!sessao.isNew())){
                color = sessao.getAttribute("corbg").toString();
            }else if(request.getParameter("corfundo")!= null){
                sessao.setAttribute("corbg", request.getParameter("corfundo").toString());
                color = sessao.getAttribute("corbg").toString();
            }else{
                color = "white";
            } 
        %>
    </head>
    <body  bgcolor="<%=color%>">
        <h1>HELLOW WORD</h1>
        <form method="post">
            <select name="corfundo">
                <option value="red">Vermelho</option>
                <option value="green">Verde</option>
                <option value="blue">Azul</option>
            </select>
            <input type="submit" value="Alterar Cor"><br>
        </form>
        
        <%
            //sessao.setAttribute("corbg", request.getParameter("corfundo"));
            //sessao.setAttribute("corbg", "red");
        %>
    </body>
</html>
