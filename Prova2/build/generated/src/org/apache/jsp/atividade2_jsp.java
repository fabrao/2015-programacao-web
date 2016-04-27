package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class atividade2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Atividade 2</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Atividade 2</h1>\n");
      out.write("        <form method=\"post\">\n");
      out.write("            Texto: <input type=\"text\" name=\"texto\"><br><br>\n");
      out.write("            Tamanho: <input type=\"text\" name=\"tamanho\"><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Enviar\"><br><br>\n");
      out.write("        </form>\n");

            String tamanhoSP= request.getParameter("tamanho");
            String textoP= request.getParameter("texto");
        
            if(tamanhoSP == null){
                tamanhoSP ="0";
            }
            if(textoP == null){
                textoP = "";
            }
            int tamanhoP = Integer.parseInt(tamanhoSP);
            
        if(tamanhoP<=0){

      out.write("          <h3> Erro: parâmetro 'tamanho' nulo ou negativo</h3>\n");
      }else if(textoP.isEmpty()){

      out.write("          <h3> Erro: parâmetro 'texto' vazio </h3>\n");
      }else{
            int tamanhoTexto = textoP.length();
            if(textoP.length() > tamanhoP){
 
      out.write("             <h3> Qtde de caracteres do Texto é MAIOR que o valor do Parâmetro </h3>\n");
          }else if(textoP.length() < tamanhoP){

      out.write("          <h3> Qtde de caracteres do Texto é MENOR que o valor do Parâmetro </h3>\n");
          }else{

      out.write("                  <h3> Qtde de caracteres do Texto é IGUAL o valor do Parâmetro </h3>\n");
      
            }
        }        

      out.write("   \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
