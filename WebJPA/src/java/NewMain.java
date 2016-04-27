
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebJPAPU");
            EntityManager em = emf.createEntityManager(); 
                //Query q = em1.createQuery("SELECT Nome FROM Contato WHERE Nome LIKE 'uva%'");
                //List<Object> listaContatos = q.getResultList();
                //Query q2 = em1.createQuery("SELECT Tel FROM Contato WHERE Nome LIKE '"+ nomeBusca +"%'");
                //List<Object> listaTels = q2.getResultList();   
            em.close();
            emf.close();
    }
    
}
