/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.PessoaFisica;
import java.util.Calendar;
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
public class TestePessoaFisica {
    
    EntityManager em;
    
    public TestePessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("645.432.080-48");
            pf.setNomeUsuario("ramos");
            pf.setEmail("pauloramos.1209@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Paulo Cesar Ramos");
            pf.setRg("27672444-6");
            pf.setTelefone("(11)49650514");
            pf.setSenha("12345");
           
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
