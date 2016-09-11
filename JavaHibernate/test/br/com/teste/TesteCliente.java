/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Cliente;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import static javax.xml.bind.DatatypeConverter.parseDateTime;
import static org.joda.time.format.ISODateTimeFormat.date;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author paulo
 */
public class TesteCliente {
     EntityManager em;
     
    public TesteCliente() {
        
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
    public void Test(){
          boolean exception = false;
          Cliente c = new Cliente();
          c.setNome("Ramos");
          c.setCpf("12345678909");
          c.setCnpj("12345678909/0001");
          c.setEndereco("rua da fortuna ");
          c.setEmail("paulo@gmail.com");
          Date data = new Date();
          c.setDataCadastro(data);
          c.setTelefone("11984093334");
          c.setAtivo(true);
          c.setCelular("1149650514");
          try{
           em.getTransaction().begin();
           em.persist(c);
           em.getTransaction().commit();
          }catch(Exception e)
          {
               exception = true;
            e.printStackTrace();
              
          }
          Assert.assertEquals(false,exception);
    }
    
  
    
}
