/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mbeyo
 */
public class JDBC {

     private final static String URL = "jdbc:mysql://localhost:3306/summerbankbd";
     private final static String USER = "root";
     private final static String PASSWORD = "";


    public static Connection getConnexion() throws ClassNotFoundException, SQLException{
            Connection connexion = null;

            Class.forName("com.mysql.jdbc.Driver");

            return (Connection) DriverManager.getConnection(URL,USER,PASSWORD) ;

    }
}