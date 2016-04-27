<%@page import="java.util.List"%>
<%@page import="utfpr.cp.model.Recado"%>
<%@page import="utfpr.cp.model.Recado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            ul { margin: 0; padding: 5px; }
            li { list-style: none; margin-bottom: 10px; border-bottom: 1px dashed #EEE; }
            li strong {font-size: 20px; color: blue; }
        </style>
    </head>
    <body>
        <h1>Mural de Recados!</h1>
        <hr>
        <a href="index.jsp">Deixar um novo recado</a>
        <ul>
            <% 
            List<Recado> lista = (List<Recado>)request.getAttribute("mural");
            for(Recado rec : lista) {
                out.println("<li><strong>" + rec.getNome() + "</strong><br>"+
                      rec.getTexto() + "</li>" );
            }
            if (lista.size() == 0) {
                out.println("<li><i>Nenhum recado até o momento!</i></li>");
            }
            %>
        </ul>
    </body>
</html>
