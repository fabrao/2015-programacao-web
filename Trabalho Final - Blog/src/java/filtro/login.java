package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managedbeans.UsuarioMB;

public class login implements Filter {
    
    private FilterConfig filterConfig = null;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession(true);
        UsuarioMB usuarioMB;
        if((UsuarioMB)session.getAttribute("usuarioMB")==null){
            usuarioMB = new UsuarioMB();
            session.setAttribute("usuarioMB", usuarioMB);
        }else{
            usuarioMB = (UsuarioMB)session.getAttribute("usuarioMB");
        }
        
        
        if(usuarioMB.isLogado()){
        } else {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/faces/login.xhtml");
        }
        
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

}
