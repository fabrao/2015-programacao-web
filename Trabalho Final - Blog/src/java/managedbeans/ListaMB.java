package managedbeans;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetos.Usuario;

@ManagedBean
@ApplicationScoped
public class ListaMB {

    List<Usuario> listaUsuarios;
    
    public ListaMB() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        listaUsuarios = manager.createQuery("Select u from Usuario u").getResultList();
        manager.close();
        factory.close();
    }
    
    public void atualiza(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BlogPU");
        EntityManager manager = factory.createEntityManager();
        listaUsuarios = manager.createQuery("Select u from Usuario u").getResultList();
        manager.close();
        factory.close();
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
}
