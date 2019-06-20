/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {

    private Connection con;

    private static DataSource data;
    private String url = "jdbc:mysql://localhost:3306/govoyagedb";
    private String login = "root";
    private String pwd = "";

    private DataSource() {
        try {
            //Druiive classe dans jdbc
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }
//Singleton Instancisation une seul fois qui va etre par la suite controler 
    public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;
    }

}
