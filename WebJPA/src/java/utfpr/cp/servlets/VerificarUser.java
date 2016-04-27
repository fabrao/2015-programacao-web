/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.cp.servlets;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class VerificarUser extends HttpServlet {


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
        String sair = request.getParameter("sair");
        if(sair == null){
            sair = "";
        }
        if(sair.equals("true")){
            request.getSession().setAttribute("logado", null);
            request.getSession().setAttribute("usuario", "");
            response.sendRedirect("/WebJPA/catSearch.jsp");
        }
        
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
        String senha = request.getParameter("senha");
        
        if(nome == null){
            nome = "";
        }
        if(senha == null){
            senha = "";
        }

        if (nome.isEmpty() || senha.isEmpty()) {
            RequestDispatcher index = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("erro", "Erro: Usuário e/ou Senha vazio(s)");
            request.setAttribute("nome", nome);
            request.setAttribute("senha", senha);
            index.forward(request, response);
        }else{
            
            EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
            EntityManager em1 = emf1.createEntityManager();
            Query q = em1.createQuery("SELECT u FROM Usuario u WHERE u.nome = :login AND u.senha = :pass");
            q.setParameter("login", nome);
            q.setParameter("pass", senha);
            
            try{
                Usuario user = (Usuario) q.getSingleResult();
                if (user.getNome().equals(nome) && user.getSenha().equals(senha)) {
                    request.getSession().setAttribute("logado", new Boolean(true));
                    request.getSession().setAttribute("usuario", user.getNome());
                   response.sendRedirect("/WebJPA/catSearch.jsp");
                }
           }catch(Exception e){      
                RequestDispatcher index = request.getRequestDispatcher("/login.jsp");
                request.setAttribute("erro", "Senha ou Usuário Inválido(s)");
                request.setAttribute("nome", nome);
                request.setAttribute("senha", senha);
                index.forward(request, response);
           }
            em1.close();
            emf1.close();
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
