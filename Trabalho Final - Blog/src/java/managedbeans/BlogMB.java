package managedbeans;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetos.Comentario;
import objetos.Post;
import objetos.Usuario;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class BlogMB {

    List<Post> posts;
    Usuario usuario;
    Map<Post,List<Comentario>> comentarios = new HashMap<>();
    Map<Post,StreamedContent> imagens = new HashMap<>();
    
    
    public BlogMB(){
        
    }
    
    public String entraBlog(Usuario usuario) {
        posts = new ArrayList<>();
        comentarios = new HashMap<>();
        this.usuario = usuario;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        posts = manager.createQuery("Select p from Post p where p.usuario = :usuario ORDER BY p.dia DESC").setParameter("usuario", usuario).getResultList();
        byte[] b;
        for(Post post:posts){
            comentarios.put(post,manager.createQuery("Select c from Comentario c where c.post = :post").setParameter("post", post).getResultList());
            if(post.getImagem()!= null){
                b=post.getImagem();
                imagens.put(post, new DefaultStreamedContent(new ByteArrayInputStream(b)));
            }
        }
        manager.close();
        factory.close();
        return "blog";
    }

    public void setImagens(Map<Post, StreamedContent> imagens) {
        this.imagens = imagens;
    }

    public Map<Post, StreamedContent> getImagens() {
        return imagens;
    }
    
    public List<Comentario> retornaComentario(Post post){
        return comentarios.get(post);
    }

    public Map<Post, List<Comentario>> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Map<Post, List<Comentario>> comentarios) {
        this.comentarios = comentarios;
    }
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public StreamedContent retornaImagem(Post post){
        return imagens.get(post);
    }
    
}
