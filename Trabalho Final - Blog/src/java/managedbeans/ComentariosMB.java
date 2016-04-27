package managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import objetos.Comentario;
import objetos.Post;
import objetos.Usuario;

@ManagedBean
@RequestScoped
public class ComentariosMB {
    
    Comentario comentario = new Comentario();

    public String enviaComentario(Usuario usuario){
        comentario.setDia();
        comentario.setUsuariocoment(usuario);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
    
        comentario.setPost(manager.find(Post.class, comentario.getPost().getId()));
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        manager.persist(comentario);
        tx.commit();
          
        manager.close();
        factory.close();

        FacesMessage msg = new FacesMessage ("Comentario enviado!");
        FacesContext.getCurrentInstance().addMessage("msg", msg);
        comentario = new Comentario();
        return "blog";
    }
    
    public void getComentarios(Post post){
        System.out.println(post.getId());
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public ComentariosMB() {
        
    }
    
    
}
