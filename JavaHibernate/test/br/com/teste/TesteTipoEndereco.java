/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.TipoEndereco;
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
public class TesteTipoEndereco {
    
    EntityManager em;

    public TesteTipoEndereco() {
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
    public void teste() {
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
            TipoEndereco te1 = new TipoEndereco();
            te1.setDescricao("Residencial");
            TipoEndereco te2 = new TipoEndereco();
            te2.setDescricao("Trabalho");
            em.getTransaction().begin();
            em.persist(te1);            
            em.persist(te2);            
            em.getTransaction().commit();
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }
}


