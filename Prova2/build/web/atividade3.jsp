<%-- 
    Document   : atividade3
    Created on : 03/12/2014, 14:29:42
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atividade 3</title>
<%
        HttpSession sessao = request.getSession();
        String textosessao;
        if (sessao.isNew()) {
                sessao.setAttribute("texto", "");
                textosessao =  sessao.getAttribute("texto").toString();
        }else {
                //textosessao = "huashuashu";
             textosessao = sessao.getAttribute("texto").toString();
        }
%>
    </head>
    <body>
        <h1>Atividade 3</h1>
        <form method="post">
            <textarea name="tArea" cols="82" rows="15" ><%=sessao.getAttribute("texto").toString() %></textarea><br>
            <input type="submit" value="Salvar">
        </form>
<%
        String textArea = request.getParameter("tArea");
        if(textArea == null){
            textArea = ""; 
        }else{
            sessao.setAttribute("texto", textArea);
            response.sendRedirect("atividade3.jsp");
        }
%>        
    </body>
</html>
