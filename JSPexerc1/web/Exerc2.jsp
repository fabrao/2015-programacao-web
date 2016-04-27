<%-- 
    Document   : Exerc2
    Created on : 26/11/2014, 18:13:03
    Author     : Renan
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Map<String, Integer> disciplinas = new HashMap<String, Integer>();
            disciplinas.put("Calculo1", 6);
            disciplinas.put("Fisica", 6);
            disciplinas.put("Geometria", 5);
            disciplinas.put("Calculo2", 6);
            disciplinas.put("Quimica", 5);
            disciplinas.put("Java", 4);
            disciplinas.put("Embarcados", 4);
        %>
        <h1>Marque as Disciplinas já Cursadas</h1>
        <form method="get">
            <%
            for (String Discp : disciplinas.keySet()) {                          
            %>
                <input type="checkbox" name="<%=Discp%>" value="ok"><%=Discp%><br>
            <% }  %> 
            <br><input type="submit" value="Enviar" />
        </form>
            
        
            <h2>Disciplinas Faltantes:</h2>
            <ul>
        <%
            int credCursado = 0;
            int credFaltante = 0;
            for(Map.Entry<String, Integer> entry : disciplinas.entrySet() ){   
                if((request.getParameter(entry.getKey()) != null) && (request.getParameter(entry.getKey()).equals("ok"))){
                    credCursado += entry.getValue();
                }else{
        %>
                    <li><h4><%=entry.getKey()%></h4></li>
        <%
                    credFaltante += entry.getValue();
                }   
            }          
        %>
            </ul>
                <h3>Créditos Cursados: <%=credCursado%></h3> 
                <h3>Créditos Faltantes: <%=credFaltante%></h3> 
         
    </body>
</html>