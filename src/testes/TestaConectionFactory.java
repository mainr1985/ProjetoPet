/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Maíra & Rafael
 */
public class TestaConectionFactory {
    public static void main (String args[]) throws SQLException
    {
        Connection conexao = new ConnectionFactory().getConnection();
        System.out.println("conexão aberta");
        conexao.close();
        System.out.println("conexão fechada");
    }   
}