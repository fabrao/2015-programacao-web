<%-- 
    Document   : excluirContato
    Created on : 05/12/2014, 12:59:09
    Author     : Renan
--%>

<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="utfpr.cp.model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet">
        <title>Excluir Contato</title>
    </head>
    
    <body>
        
        <form method="get" id="formulario" name="formulario" action="GerenciarContatos">
            <input type="hidden" name="manage" value="true">
        </form>
         <header>
            <div id="principalH">
                <div id="contato">
                    <a href="catSearch.jsp">Buscar</a> - 
                    <a href="novoContato.jsp">Cadastrar</a> - 
                    <a href="editarContato.jsp">Editar </a>
                </div>
                <div id="logout">
                     <form action="VerificarUser" method="GET">
                        <input type="hidden" name="sair" value="true">
                        Olá <strong><%= request.getSession().getAttribute("usuario").toString() %></strong>. Caso queira sair clique <input type="submit" value="AQUI">
                    </form>
                </div>
            </div>
        </header>
                    
        <h1>Excluir Contatos</h1>
        <%
            List<Object> listaContatos = null;
            List<Object> listaTels = null;
            List<Object> listaId = null;

            EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
            EntityManager em1 = emf1.createEntityManager();
                Query q = em1.createQuery("SELECT Nome FROM Contato ORDER BY Nome ASC");
                listaContatos = q.getResultList();
                Query q2 = em1.createQuery("SELECT Tel FROM Contato ORDER BY Nome ASC");
                listaTels = q2.getResultList();
                Query q3 = em1.createQuery("SELECT id FROM Contato ORDER BY Nome ASC");
                listaId = q3.getResultList();
            em1.close();
            emf1.close();   
        %>

            <div id="table">
                 <form method="post">
                    <table> 
                       <tr>
                           <th>Num</th>
                           <th>Nome</th>
                           <th>Número</th>
                       </tr>

                       <%for(int i=0; i< listaContatos.size() ; i++){%>

                               <tr>
                                   <td><input type="radio" name="idContato" value="<%=listaId.get(i)%>">
                                   <td><%=listaContatos.get(i)%></td>
                                   <td><%=listaTels.get(i)%></td>  
                               </tr>

                      <%}%> 
                    </table><br>
                    <input type="submit" name="Button" value="Excluir">
                 </form>
            </div>   

        <%
        if(request.getParameter("idContato")!= null && request.getParameter("Button").equals("Excluir")){
            request.setCharacterEncoding("UTF-8");
            String idParameter = request.getParameter("idContato").toString();
            
            EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("default");
            EntityManager em2 = emf2.createEntityManager();
                EntityTransaction tx = em2.getTransaction();
                Contato contato = new Contato();
                contato.setId(Long.parseLong(idParameter));
                contato = em2.getReference(contato.getClass(), contato.getId());
                tx.begin();
                em2.remove(contato);
                tx.commit();
            em2.close();
            emf2.close(); 
            response.sendRedirect("excluirContato.jsp");
        }
%>

    </body>
</html>
