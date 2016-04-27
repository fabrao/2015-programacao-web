/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.cp.servlets;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utfpr.cp.model.Usuario;

/**
 *
 * @author Renan
 */
public class CadastrarUser extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");
        if (nome == null) {
            nome = "";
        }
        if (senha1 == null) {
            senha1 = "";
        }
        if (senha2 == null) {
            senha2 = "";
        }
        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
        EntityManager em1 = emf1.createEntityManager();
        Query q = em1.createQuery("SELECT nome FROM Usuario");
        List<Object> listaUsuarios = q.getResultList();
        em1.close();
        emf1.close();
        
        if ((nome.isEmpty() || senha1.isEmpty() || senha2.isEmpty()) || (!senha1.equals(senha2))) {
            RequestDispatcher index = request.getRequestDispatcher("/novoUser.jsp");
            request.setAttribute("erro", "Todos os campos devem ser preenchidos e a senha deve ser idêntica a confirmação");
            request.setAttribute("nome", nome);
            request.setAttribute("senha1", senha1);
            request.setAttribute("senha2", senha2);
            
        }else if(listaUsuarios.contains(nome)){
            
            RequestDispatcher index = request.getRequestDispatcher("/novoUser.jsp");
            request.setAttribute("erro", "Nome de Usuário já Cadastrado!");
            //request.setAttribute("erro", listaUsuarios);
            request.setAttribute("nome", nome);
            request.setAttribute("senha1", senha1);
            request.setAttribute("senha2", senha2);
            index.forward(request, response);
        }else {
            try {
                //Criando o gerenciador de entidades
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
                EntityManager em = emf.createEntityManager();

                //Criando o objeto de entidade
                Usuario user = new Usuario();
                user.setNome(nome);
                user.setSenha(senha1);
                
                //Criando e dando inicio a uma transação
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(user);
                tx.commit();

                //Fechando as conexões
                em.close();
                emf.close();
                
                response.sendRedirect("login.jsp");
            }
            catch (Exception err) {
                err.printStackTrace();
                RequestDispatcher newUser = request.getRequestDispatcher("/novoUser.jsp");
                request.setAttribute("erro", "Falha ao cadastrar usuário no banco");
                newUser.forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
