/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan
 */
public class ServletCadastra extends HttpServlet {
    String question, alternativa1, alternativa2, alternativa3;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCadastra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCadastra at " + request.getContextPath() + "</h1>");
            out.println("<h2>");
            //getServletContext().getAttribute("alt1");
            out.println("</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        question = request.getParameter("questao");
        alternativa1 = request.getParameter("alt1");
        alternativa2 = request.getParameter("alt2");
        alternativa3 = request.getParameter("alt3");
        
        getServletContext().setAttribute("questao", question);
        getServletContext().setAttribute("alt1", alternativa1);
        getServletContext().setAttribute("alt2", alternativa2);
        getServletContext().setAttribute("alt3", alternativa3);
        
        getServletContext().setAttribute("votosAlt1", "0");
        getServletContext().setAttribute("votosAlt2", "0");
        getServletContext().setAttribute("votosAlt3", "0");
        
        response.sendRedirect("/WebSessions/Voto.jsp");
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
