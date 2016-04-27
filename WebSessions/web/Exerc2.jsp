<%-- 
    Document   : Exerc2
    Created on : 30/11/2014, 10:58:26
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercício 2</title>
        <%
            int cont;
            HttpSession sessao = request.getSession();
            
            if (sessao.isNew()) {
                sessao.setAttribute("cont", 1);
            }
            else {
                cont = Integer.parseInt(sessao.getAttribute("cont").toString());
                cont++;
                sessao.setAttribute("cont", cont);
            }
            String qtdeAcessos = sessao.getAttribute("cont").toString();
        %>
    </head>
    <body>
        <h1>Qtde Acessos: <%=qtdeAcessos%></h1>
    </body>
</html>
