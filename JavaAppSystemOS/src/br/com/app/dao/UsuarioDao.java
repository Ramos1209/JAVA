/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.dao;

import br.com.app.Util.EntityManagerUtil;
import br.com.app.modelo.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author paulo
 */
public class UsuarioDao implements Serializable{

    EntityManager  em ;
    Usuario user;

    public Usuario autenticarUsuario(String login, String senha) {

        em =EntityManagerUtil.getEntityManagerFactory();
      
        try {
            user = (Usuario) em.createNamedQuery("Usuario.findByLoginSenha")
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return user;

    }
//em.createQuery("SELECT U FROM Usuario U WHERE U.nomeUsuario = :nome")

    public Usuario BuscarPorNome(String nome) {

      
        try {
             em = EntityManagerUtil.getEntityManagerFactory();
            user = (Usuario) em.createNamedQuery("Usuario.findByNome")
                    .setParameter("nome", nome)
                    .getSingleResult();

        } catch (Exception e) {
            System.err.println("Erro" + e.getMessage() + e.getCause());
            e.printStackTrace();

        }

        return user;
    }

    public void AddUsuario(Usuario user) {
        try {
            em = EntityManagerUtil.getEntityManagerFactory();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void atualiza(Usuario user) {

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }
    
    public void deletar(Usuario user){
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
        
    }

}
