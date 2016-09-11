/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Endereco;
import br.com.modelo.Pessoa;
import br.com.modelo.PessoaFisica;
import br.com.modelo.TipoEndereco;
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
public class TesteEndereco {
    
    EntityManager em;
    
    public TesteEndereco() {
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
            Endereco e = new Endereco();
            e.setBairro("Centro");
            e.setCep("07044-001");
            e.setComplemento("bloco 29 apto 4");
            e.setEndereco("rua paula ferreira ");
            e.setNickname("neo");
            e.setNumero("190");
            e.setReferencia("P.A Paraiso");
            e.setTipoEndereco(em.find(TipoEndereco.class, 1));
            pf.adicionarEndereco(e);
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
