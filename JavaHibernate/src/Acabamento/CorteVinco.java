/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acabamento;

/**
 *
 * @author paulo
 */
public class CorteVinco {
    
    private double quantidade;
    private double preco;
    
    public double Calcula(double quantidade, double preco){
        
        double result1 = quantidade / 1000;   
        double result2 = result1 * preco;
        return  result2 + preco;
    }
    
}
