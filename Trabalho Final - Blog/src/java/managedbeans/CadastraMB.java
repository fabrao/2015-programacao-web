package managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import objetos.Usuario;

@ManagedBean
@RequestScoped
public class CadastraMB {

    private Usuario usuario = new Usuario();
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public CadastraMB() {
    }
    
    public String cadastraUsuario(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        if(manager.find(Usuario.class, usuario.getLogin()) != null){
            FacesMessage msg = new FacesMessage ("Usuario não disponivel!");
            FacesContext.getCurrentInstance().addMessage("erro", msg);
            return null;
        }else{
            if(senha.equals(usuario.getSenha())){
                EntityTransaction tx = manager.getTransaction();
                tx.begin();
                manager.persist(usuario);
                tx.commit();
                manager.close();
                factory.close();
                FacesMessage msg = new FacesMessage ("Usuário cadastrado com sucesso!");
                FacesContext.getCurrentInstance().addMessage("cad", msg);
                return "login";
            }else{
                manager.close();
                factory.close();
                FacesMessage msg = new FacesMessage ("Senhas diferentes!");
                FacesContext.getCurrentInstance().addMessage("erro", msg);
                return null;
            }
        }
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
