/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.PessoaFisica;
import br.com.modelo.Produto;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author paulo
 */
public class TestePersistenciaRelacionamentoPessoaFisica_produto {
    
    EntityManager em;
    
    public TestePersistenciaRelacionamentoPessoaFisica_produto() {
    }
    
    @Before
    public void setUp() {
         em = EntityManagerUtil.GetEntityManager();
    }
    
    @After
    public void tearDown() {
         em.close();
    }
    
    
    @Test
    public void Teste() {
        boolean exception = false;
        try {
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Produto p = em.find(Produto.class, 1);
            pf.getDesejos().add(p);
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);

    }
}
