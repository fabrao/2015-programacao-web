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
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan
 */
public class BuscarContato extends HttpServlet {

    

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
        
        request.setCharacterEncoding("UTF-8");
        String nomeBusca = request.getParameter("busca").toString();

        if(nomeBusca.isEmpty()){
            RequestDispatcher index = request.getRequestDispatcher("/catSearch.jsp");
            request.setAttribute("results", "RESULTADO DA BUSCA:");
            EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
            EntityManager em1 = emf1.createEntityManager();
                Query q = em1.createQuery("SELECT Nome FROM Contato ORDER BY Nome ASC");
                List<Object> listaContatos = q.getResultList();
                Query q2 = em1.createQuery("SELECT Tel FROM Contato ORDER BY Nome ASC");
                List<Object> listaTels = q2.getResultList();
               
            em1.close();
            emf1.close();

            request.setAttribute("resultadoNomes", listaContatos);
            request.setAttribute("resultadoTels", listaTels);
            index.forward(request, response);
        }else{
            RequestDispatcher index = request.getRequestDispatcher("/catSearch.jsp");
            request.setAttribute("results", "RESULTADO DA BUSCA:");
            EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
            EntityManager em1 = emf1.createEntityManager(); 
                Query q = em1.createQuery("SELECT Nome FROM Contato WHERE Nome LIKE '"+ nomeBusca +"%'");
                List<Object> listaContatos = q.getResultList();
                Query q2 = em1.createQuery("SELECT Tel FROM Contato WHERE Nome LIKE '"+ nomeBusca +"%'");
                List<Object> listaTels = q2.getResultList();   
            em1.close();
            emf1.close();
            
            request.setAttribute("resultadoNomes", listaContatos);
            request.setAttribute("resultadoTels", listaTels);
            index.forward(request, response);
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
