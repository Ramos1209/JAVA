/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import Acabamento.CorteVinco;
import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author paulo
 */
public class TestePersistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        CorteVinco cv = new CorteVinco();
        
        
        System.out.println(cv.Calcula(2500, 30));
        
    }
    
}
