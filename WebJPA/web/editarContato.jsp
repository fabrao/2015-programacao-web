<%-- 
    Document   : editarContato
    Created on : 07/12/2014, 01:54:56
    Author     : Renan
--%>

<%@page import="utfpr.cp.model.Contato"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Contato</title>
        <link href="estilo.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <div id="principalH">
                <div id="contato">
                    <a href="catSearch.jsp">Buscar</a> - 
                    <a href="novoContato.jsp">Cadastrar</a> - 
                    <a href="excluirContato.jsp">Excluir </a>
                </div>
                <div id="logout">
                     <form action="VerificarUser" method="post">
                        <input type="hidden" name="sair" value="true">
                        Olá <strong><%= request.getSession().getAttribute("usuario").toString() %></strong>. Caso queira sair clique <input type="submit" value="AQUI">
                    </form>
                </div>
            </div>
        </header>
        
        <h1>Editar Contato</h1>
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

            <div>
                 <form method="post">
                        <div>
                            Selecione o Contato: 
                           <select name="contatoSelecionado">
                             <%for(int i=0; i< listaContatos.size() ; i++){%>
                             <option value="<%=listaId.get(i)%>"><%=listaContatos.get(i)%> ---------------- <%=listaTels.get(i)%></option>
                            <%}%> 
                          </select>
                        </div><br><br><br>
                        <div id="divEdit">
                            Novo nome: <input type="text" name="NomeCompleto" placeholder=" Nome Completo" size="50" maxlength="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            Novo telefone: <input type="tel" name="Telefone" placeholder=" (DDD)  0000-0000" maxlength="16" size="12"><br><br>
                            <input type="submit" name="Button" value="Salvar">
                        </div>
                  </form>
            </div>
<%              
        if(request.getParameter("contatoSelecionado")!= null && request.getParameter("Button").equals("Salvar")){
           
            request.setCharacterEncoding("UTF-8");
            String idParameter = request.getParameter("contatoSelecionado").toString();
            String nomeParameter = request.getParameter("NomeCompleto").toString();
            String telefoneParameter = request.getParameter("Telefone").toString();
            
            if(nomeParameter == null){
                nomeParameter = "";
            }
            if(telefoneParameter == null){
                telefoneParameter = "";
            }
            
            
            if(!nomeParameter.isEmpty() && !telefoneParameter.isEmpty()){           
                EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("default");
                EntityManager em2 = emf2.createEntityManager();
                    EntityTransaction tx = em2.getTransaction();
                    Contato contato = new Contato();
                    contato.setId(Long.parseLong(idParameter));
                    contato = em2.find(contato.getClass(), contato.getId());
                    contato.setNome(nomeParameter);
                    contato.setTel(telefoneParameter);
                    tx.begin();
                    
                    em2.persist(contato);
                    tx.commit();
                em2.close();
                emf2.close(); 
                response.sendRedirect("editarContato.jsp");
            }else if(nomeParameter.isEmpty() || telefoneParameter.isEmpty()){

                %><br><br><br><mark>ERRO: Nome ou Telefone vazio(s)!</mark><%
            }
        }
%>           
    </body>
</html>
