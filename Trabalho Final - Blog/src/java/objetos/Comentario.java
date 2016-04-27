package objetos;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Usuario usuariocoment;
    
    @Lob
    private String comentario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    @ManyToOne
    private Post post = new Post();
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dia;

    public Usuario getUsuariocoment() {
        return usuariocoment;
    }

    public void setUsuariocoment(Usuario usuariocoment) {
        this.usuariocoment = usuariocoment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia() {
        this.dia = new GregorianCalendar().getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}