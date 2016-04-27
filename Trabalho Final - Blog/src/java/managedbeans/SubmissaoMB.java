package managedbeans;

import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.Part;
import objetos.Post;
import objetos.Usuario;
import org.apache.tomcat.util.http.fileupload.IOUtils;

@ManagedBean
@RequestScoped
public class SubmissaoMB {

    private Post post = new Post();
    private Part imagem;
   

  

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public void inserePost(Usuario usuario) throws IOException{ 
        post.setDia();
        post.setUsuario(usuario);
        
        if(imagem != null){
            if(imagem.getContentType().startsWith("image")){
                post.setExtensaoimg(imagem.getContentType().substring(6));
                InputStream input = imagem.getInputStream();
                byte[] img = new byte[input.available()]; 
                IOUtils.readFully(input, img);
                post.setImagem(img);
            }else{
                FacesMessage msg = new FacesMessage ("Post não submetido, arquivo deve ser uma imagem!");
                FacesContext.getCurrentInstance().addMessage("erro", msg);
                imagem=null;
                return;
            }
        }
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(post);
        tx.commit();
        manager.close();
        factory.close();
        FacesMessage msg = new FacesMessage ("Post submetido!");
        FacesContext.getCurrentInstance().addMessage("erro", msg);
        post = new Post();
        imagem=null;
    }
    
    
    public SubmissaoMB() {
        
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
}
