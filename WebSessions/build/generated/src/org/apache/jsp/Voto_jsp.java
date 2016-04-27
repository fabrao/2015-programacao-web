package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Voto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Votar</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Voto.jsp</h1><br>\n");
      out.write("       <h2>");
      out.print(application.getAttribute("questao"));
      out.write("</h2>\n");
      out.write("       <form method=\"post\">\n");
      out.write("           <input type=\"radio\" name=\"altSelecionada\" value=\"alt1\" checked=\"\"> ");
      out.print(application.getAttribute("alt1"));
      out.write(" <br>\n");
      out.write("           <input type=\"radio\" name=\"altSelecionada\" value=\"alt2\"> ");
      out.print(application.getAttribute("alt2"));
      out.write(" <br>\n");
      out.write("           <input type=\"radio\" name=\"altSelecionada\" value=\"alt3\"> ");
      out.print(application.getAttribute("alt3"));
      out.write("<br><br>\n");
      out.write("           <input type=\"submit\" value=\"Votar\">\n");
      out.write("       </form>\n");
      out.write("       \n");
      out.write("        ");

        int votos=0;
        if(request.getParameter("altSelecionada").equals("alt1")){
           votos = Integer.parseInt(application.getAttribute("votosAlt1").toString());
           votos++;
           application.setAttribute("votosAlt1", votos);
           response.sendRedirect("/WebSessions/Resultado.jsp");
        }else if(request.getParameter("altSelecionada").equals("alt2")){
            votos = Integer.parseInt(application.getAttribute("votosAlt2").toString());
            votos++;
            application.setAttribute("votosAlt2", votos);
            response.sendRedirect("/WebSessions/Resultado.jsp");
        }else if(request.getParameter("altSelecionada").equals("alt3")){
            votos = Integer.parseInt(application.getAttribute("votosAlt3").toString());
            votos++;
            application.setAttribute("votosAlt3", votos);
            response.sendRedirect("/WebSessions/Resultado.jsp");
        }
        
      out.write("\n");
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
