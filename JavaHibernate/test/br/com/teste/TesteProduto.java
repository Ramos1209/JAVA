/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Categoria;
import br.com.modelo.Marca;
import br.com.modelo.Produto;
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
public class TesteProduto {
    
    EntityManager em;

    public TesteProduto() {
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
            Categoria c = new Categoria();
            c.setNome("Eletrônicos");
            Marca m = new Marca();
            m.setNome("Samsung");
            Produto p = new Produto();
            p.setNome("Monitor Samsung 15");
            p.setCategoria(c);
            p.setMarca(m);
            p.setDescricao("blablabla");
            p.setPreco(400.00);
            p.setQuantidadeEstoque(20.0);
            em.getTransaction().begin();
            em.persist(c);
            em.persist(m);
            em.persist(p);
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

