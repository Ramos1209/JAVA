/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.descritivo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author paulo
 */
public class NumeroFolhas {

    public double calculaMedida(int med1, int med2,int qtd) {
      
        double  result = med1 * med2;
        BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_EVEN);
        double pedacoPorFolha = 64 * 88 / result;
        Math.floor(pedacoPorFolha);
        int result2 = 0;
       
       
        result2 =  (int) (qtd /pedacoPorFolha);
        double pedacoPorFolha1 = 66 * 96 / result;
        
        double pedacoPorFolha2 = 76 * 112 / result;
        double pedacoPorFolha3 = 77 * 113 / result;
        double pedacoPorFolha4 = 89 * 117 / result;
        
        
        if (pedacoPorFolha > pedacoPorFolha1 && pedacoPorFolha > pedacoPorFolha2 && pedacoPorFolha > pedacoPorFolha3 && pedacoPorFolha > pedacoPorFolha4) {
         
            return  result2 ;
        }
//       else if (pedacoPorFolha1 > pedacoPorFolha && pedacoPorFolha1 > pedacoPorFolha2 && pedacoPorFolha1 > pedacoPorFolha3 && pedacoPorFolha1 > pedacoPorFolha4) {
//            return result2 = (int) pedacoPorFolha1;
//        }
//       else if (pedacoPorFolha2 > pedacoPorFolha && pedacoPorFolha2 > pedacoPorFolha1 && pedacoPorFolha2 > pedacoPorFolha3 && pedacoPorFolha2 > pedacoPorFolha4) {
//            return result2 = (int) pedacoPorFolha2;
//        }
//      else if (pedacoPorFolha3 > pedacoPorFolha && pedacoPorFolha3 > pedacoPorFolha1 && pedacoPorFolha3 > pedacoPorFolha2 && pedacoPorFolha3 > pedacoPorFolha4) {
//            return result2 =  (int) pedacoPorFolha3;
//        }
//       else if (pedacoPorFolha4 > pe,dacoPorFolha && pedacoPorFolha4 > pedacoPorFolha1 && pedacoPorFolha4 > pedacoPorFolha2 && pedacoPorFolha4 > pedacoPorFolha3) {
//            return result2 =  (int) pedacoPorFolha4;
//        }
      return result2;
      
    
    }
        int calculaQuatidadePapel(int qtd){
           return qtd;
        }
    
    

    
}
