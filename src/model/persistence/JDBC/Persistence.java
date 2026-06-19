/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanito
 */
public class Persistence {
    
    // xampp user login credentials
    private static String login = "root";
    private static String password = "";

    // url to local database 
    private static String url = "jdbc:mysql://localhost:3306/gamelog?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";

    private static Connection conn = null;
    
    public static Connection createConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, login, password);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (java.lang.InstantiationException e) {
                System.out.println(e);
            } catch (java.lang.IllegalAccessException e) {
                System.out.println(e);
            }
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
