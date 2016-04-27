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
import utfpr.cp.model.Contato;


/**
 *
 * @author Renan
 */
public class CadastrarContato extends HttpServlet {


    

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
        String nome = request.getParameter("NomeCompleto");
        String telefone = request.getParameter("Telefone");

        if (nome == null) {
            nome = "";
        }
        if (telefone == null) {
            telefone = "";
        }

        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("default");
            EntityManager em1 = emf1.createEntityManager();
                Query q = em1.createQuery("SELECT Nome FROM Contato");
                List<Object> listaContatos = q.getResultList();
            em1.close();
        emf1.close();
        
        
        if (nome.isEmpty() || telefone.isEmpty()) {
            
            RequestDispatcher index = request.getRequestDispatcher("/novoContato.jsp");
            request.setAttribute("erro", "Todos os campos devem ser preenchidos");
            request.setAttribute("NomeCompleto", nome);
            request.setAttribute("Telefone", telefone);
            index.forward(request, response);
        
        }else if(listaContatos.contains(nome)){
            RequestDispatcher index = request.getRequestDispatcher("/novoContato.jsp");
            request.setAttribute("erro", "Contato já Cadastrado!");
            request.setAttribute("NomeCompleto", nome);
            request.setAttribute("Telefone", telefone);
            index.forward(request, response);
        
        }else {
            try {
                RequestDispatcher index = request.getRequestDispatcher("/novoContato.jsp");
                
                //Criando o gerenciador de entidades
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
                EntityManager em = emf.createEntityManager();

                //Criando o objeto de entidade
                Contato contato = new Contato();
                contato.setNome(nome);
                contato.setTel(telefone);
                
                //Criando e dando inicio a uma transação
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                //ERRO
                em.persist(contato);
                tx.commit();

                //Fechando as conexões
                em.close();
                emf.close();
                

                request.setAttribute("erro", "Contato Cadastrado com Sucesso!");
                index.forward(request, response);
            }
            catch (Exception err) {
                err.printStackTrace();
                RequestDispatcher newUser = request.getRequestDispatcher("/novoContato.jsp");
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
