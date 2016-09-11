/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Cliente;
import br.com.modelo.Orcamentos;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulo
 */
public class TesteOrcamento {
    
     EntityManager em;
    
    public TesteOrcamento() {
        
    }
    
    @Before
    public void setUp() {
        em =   EntityManagerUtil.GetEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        
    }
    @Test
    public void Teste(){
      boolean exception = false;
             try{
                
                 Orcamentos or = new Orcamentos();
                 or.setAprovado(true);
                 or.setTipo(null);
                 Date d = new Date();
                 or.setDataAprovacao(d);
                 or.setDataDoOrcamento(d);
                 or.setCliente(em.find(Cliente.class,2));
                 em.getTransaction().begin();
                 em.persist(or);
                 em.getTransaction().commit();
             }catch(Exception e){
                 exception=true;
                  e.printStackTrace();
             }
        Assert.assertEquals(false,exception);
        
    }
    
}
