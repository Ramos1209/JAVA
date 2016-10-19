/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author paulo
 */
public class EntityManagerUtil {

    public static EntityManagerFactory factory = null;
    public static EntityManager em = null;

    public static EntityManager getEntityManagerFactory() {
        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("JavaAppSystemOSPU");

                if (em == null) {
                    em = factory.createEntityManager();
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return em;
    }
}
