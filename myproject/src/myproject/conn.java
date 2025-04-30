/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

/**
 *
 * @author Asus
 */


import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;

    conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///user", "root", "BHUMIKA@");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
         new conn();
    }
}