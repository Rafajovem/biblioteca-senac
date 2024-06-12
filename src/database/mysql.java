/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author rafael.tolomeotti
 */
public class mysql {
    public static Connection conexão(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
              return DriverManager.getConnection("jdbc:mysql://localhost/db_biblioteca_senac?" +
                                   "user=root&password=root");
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar o bando de dados");
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
