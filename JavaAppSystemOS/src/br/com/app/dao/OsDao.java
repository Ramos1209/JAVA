/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.dao;

import br.com.app.Util.EntityManagerUtil;
import br.com.app.modelo.OS;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public class OsDao {

    EntityManager em;

    public void salvarOs(OS os) {
        em = EntityManagerUtil.getEntityManagerFactory();
        try {
            em.getTransaction().begin();
            em.persist(os);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.getMessage();
        }

    }
    
    public void alteraOs(OS os){
        em = EntityManagerUtil.getEntityManagerFactory();
        try {
            em.getTransaction().begin();
            em.merge(os);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public OS pesquisarOS(Integer num) {
        em = EntityManagerUtil.getEntityManagerFactory();
        try {

            OS os = (OS) em.createQuery("SELECT O FROM OS O WHERE O.id = :num")
                    .setParameter("num", num)
                    .getSingleResult();

            return os;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }
}
