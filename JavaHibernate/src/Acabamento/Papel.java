
package Acabamento;

import java.text.DecimalFormat;

/**
 *
 * @author paulo
 */
public class Papel {
   
    
    public String CalculaPapel(float lar,float compr,int grm,int qtd,double preco){
        double result = 0;
        
        Math.ceil(result = (lar * compr /10000));
        double result2 = result *grm * qtd /1000;
        double result3 = result2 * preco;
        DecimalFormat df = new DecimalFormat("###,##0.000");
        return df.format(result3);
    }
    
    public int calculaQuantidadeDeFolhas(int quantidade){
        
        
        
        
        return quantidade;
    }
}
