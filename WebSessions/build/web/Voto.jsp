<%-- 
    Document   : Voto
    Created on : 30/11/2014, 15:06:46
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votar</title>
    </head>
    <body>
        <h1>Voto.jsp</h1><br>
       <h2><%=application.getAttribute("questao")%></h2>
       <form method="post">
           <input type="radio" name="altSelecionada" value="alt1" checked=""> <%=application.getAttribute("alt1")%> <br>
           <input type="radio" name="altSelecionada" value="alt2"> <%=application.getAttribute("alt2")%> <br>
           <input type="radio" name="altSelecionada" value="alt3"> <%=application.getAttribute("alt3")%><br><br>
           <input type="submit" value="Votar">
       </form>
       
        <%
        int votos=0;
        if(request.getParameter("altSelecionada")!=null){
            if(request.getParameter("altSelecionada").equals("alt1")){
               votos = Integer.parseInt(application.getAttribute("votosAlt1").toString());
               votos++;
               application.setAttribute("votosAlt1", votos);
               response.sendRedirect("/WebSessions/Resultado.jsp");
            }else if(request.getParameter("altSelecionada").equals("alt2")){
                votos = Integer.parseInt(application.getAttribute("votosAlt2").toString());
                votos++;
                application.setAttribute("votosAlt2", votos);
                response.sendRedirect("/WebSessions/Resultado.jsp");
            }else if(request.getParameter("altSelecionada").equals("alt3")){
                votos = Integer.parseInt(application.getAttribute("votosAlt3").toString());
                votos++;
                application.setAttribute("votosAlt3", votos);
                response.sendRedirect("/WebSessions/Resultado.jsp");
            }
        }
        %>
    </body>
</html>
