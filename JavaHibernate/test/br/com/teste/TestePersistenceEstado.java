/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Estado;
import br.com.modelo.Pais;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author paulo
 */
public class TestePersistenceEstado {

    EntityManager em;

    public TestePersistenceEstado() {

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
            Estado e = new Estado();
            e.setNome("Sao Paulo");
            e.setUf("SP");
            e.setPais(em.find(Pais.class, 1));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false,exception);

    }
}
