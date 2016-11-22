/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author paulo
 */
public class FabricaConexao {

    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "ramos";

    public static Connection getConexao()  {
        if (conexao == null) {
            try {

                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
               
            } catch (ClassNotFoundException ex) {
              System.out.println("Erro ao conectar" +ex.getMessage());

            } catch (SQLException ex) {
                System.out.println("Erro de sql" +ex.getMessage());
            }

        }
        return conexao;

    }

    public static void fechaConexao()   {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                
            }
        }
        conexao = null;

    }
}
