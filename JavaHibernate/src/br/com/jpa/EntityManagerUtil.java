package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo
 */
public class EntityManagerUtil {
    
    public static EntityManagerFactory factory = null;
    public static EntityManager em = null;
    
    public static EntityManager GetEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("JavaHibernatePU");
        }
        if(em == null){
            em = factory.createEntityManager();
        }
       return em;
    }
}
