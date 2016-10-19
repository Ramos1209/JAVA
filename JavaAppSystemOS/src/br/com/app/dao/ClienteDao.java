
package br.com.app.dao;

import br.com.app.Util.EntityManagerUtil;
import br.com.app.modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author paulo
 */
public class ClienteDao {
    
    EntityManager em = EntityManagerUtil.getEntityManagerFactory();
   
    
    public void addCliente(Cliente cliente){
        
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }
    
    public void atualizaCliente(Cliente cliente){
        
        try {
            em.getTransaction().begin();
            em.find(Cliente.class, cliente.getId());
            em.merge(cliente);
            em.getTransaction().commit();
 
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.getMessage();
        }
        
    }
    public void deleteCliente(Integer id){
        try {
            
            em.getTransaction().begin();  
            Cliente cliente = em.find(Cliente.class, id);
            em.remove(cliente);
            em.flush();
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
        
    }
    
    public List<Cliente> pesquisarPorNome(String Nome){
        List<Cliente> result = null;
        try {
             em.getTransaction().begin();
             result =  em.createNamedQuery("Cliente.findByClienteNome")
                    .setParameter("nome","%" +Nome)
                    .getResultList();
                    
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
       
    }
}
  