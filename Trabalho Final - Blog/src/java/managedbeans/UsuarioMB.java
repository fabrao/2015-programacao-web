package managedbeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import objetos.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable{
    private Usuario usuario = new Usuario();
    private boolean logado = false;

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    public String efetuarLogin(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        Query query =  manager.createQuery("Select u from Usuario u where u.login = :login").setParameter("login", usuario.getLogin());
        if(query.getResultList().isEmpty()){
            FacesMessage msg = new FacesMessage ("Usuário Inválido!");
            FacesContext.getCurrentInstance().addMessage("erro", msg);
            manager.close();
            factory.close();
            return null;
        }else{
            Usuario user = (Usuario) query.getSingleResult();
            if(user.getSenha().equals(usuario.getSenha())){
                manager.close();
                factory.close();
                logado=true;
                return "home";
            }else{
                manager.close();
                factory.close();
                FacesMessage msg = new FacesMessage ("Senha inválida!");
                FacesContext.getCurrentInstance().addMessage("erro", msg);
                return null;
            }
        }
        
    }
    
    public String logout(){
        usuario = new Usuario();
        logado=false;
        return "login";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

