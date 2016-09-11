/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Marca;
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
public class TesteMarca {

    EntityManager em;

    public TesteMarca() {

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
        boolean exception = false;
        try {
            Marca m = new Marca();
            m.setNome("sansung");
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
