<%-- 
    Document   : paginaform
    Created on : 25/11/2014, 14:48:17
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Qual seu ano de nascimento?</h1>
        <form method="get">
            <select name="anonasc">
<%
                for(int i=1990; i<=2014; i++){
%>  
                    <option value="<%=i%>"> <%=i%></option>
<%
                }
%>
            </select>
        <input type="submit" value="Enviar" />
<%
        
        if((request.getParameter("anonasc")!= "")&&(request.getParameter("anonasc")!= null)){
            try{
                int anoNasc = Integer.parseInt(request.getParameter("anonasc"));

                int idade = (2014 - anoNasc);
                    if(idade > 18){     
%>                
                    <script language="javascript" type="text/javascript"> alert('Acesso Permitido'); </script>
<%
                }else{
%>                
                <script language="javascript" type="text/javascript"> alert('Acesso Proibido'); </script>
<%
                }
            }catch (Exception e) {
%>        
                <script language="javascript" type="text/javascript"> alert('Ano Inválido'); </script>
<%
            }
        }
%>
    </body>
</html>
